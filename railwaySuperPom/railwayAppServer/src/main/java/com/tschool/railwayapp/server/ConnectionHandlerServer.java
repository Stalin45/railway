package com.tschool.railwayapp.server;

import com.tschool.railwayapp.commons.commands.*;
import com.tschool.railwayapp.commons.entities.*;
import com.tschool.railwayapp.server.dao.RailwayDAO;
import com.tschool.railwayapp.commons.logger.LogUtils;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

class ConnectionHandlerServer implements Runnable {

    private final Socket socket;
    private Service service = new Service();
    private Logger logInfo;
    private Logger logError;
    
    public ConnectionHandlerServer(Socket socket) {
        logError = LogUtils.getErrorLogger();
        logInfo  = LogUtils.getInfoLogger();
        this.socket = socket;
        Thread t = new Thread(this);
        t.start();
    }

    public void run() {
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        try {
            ois = new ObjectInputStream(socket.getInputStream());
            oos = new ObjectOutputStream(socket.getOutputStream());
            while(RailwayServer.isKeepRunning()) {
                CommandRequest request = (CommandRequest)ois.readObject();
                CommandResponse response = new CommandResponse();
                Command action = request.getCommand();
                Integer resultCode = 0;
                switch(action) {
                    case GET_STATION_LIST:                                        
                        response = service.getStationList();
                        break;
                    case CREATE_PATH:
                        Path path = (Path) request.getContent().get(ContentKey.PATH);
                        List<Destination> destinationList = (List<Destination>) request.getContent().get(ContentKey.DESTINATION_LIST);
                        response = service.createPath(path, destinationList);
                        break;
                    case CREATE_TICKET:
                        Passenger passenger = (Passenger) request.getContent().get(ContentKey.PASSENGER);
                        Ticket ticket = (Ticket) request.getContent().get(ContentKey.TICKET);
                        response = service.createTicket(ticket, passenger);
                        break;
                    case CREATE_TIMETABLE:
                        TimeTable timeTable = (TimeTable) request.getContent().get(ContentKey.TIMETABLE);
                        response = service.createTimetable(timeTable);
                        break;
                    case CREATE_TRAIN:
                        Train train = (Train) request.getContent().get(ContentKey.TRAIN);
                        response = service.createTrain(train);
                        break;
                    case GET_PATHS_FIT_STATIONS:
                        try {
                        List<String> stationNameList = (List<String>) request.getContent().get(ContentKey.STRING_LIST);
                        String stationFrom = stationNameList.get(0);
                        String stationTo = stationNameList.get(1);
                        response = service.getPathsFitStations(stationFrom, stationTo);
                        }
                        catch (Exception ex) {
                            response.setException(ex);
                        }
                        break;
                    case GET_TIMETABLES_FIT_PATHS_DATE:
                        try {
                            List<String> stationNameList = (List<String>) request.getContent().get(ContentKey.STRING_LIST);
                            String stationFrom = stationNameList.get(0);
                            String stationTo = stationNameList.get(1);
                            Date date = (Date) request.getContent().get(ContentKey.DATE);
                            response = service.getTimetablesFitPathsDate(stationFrom, stationTo, date);
                        } catch (Exception ex) {
                            response.setException(ex);
                        }
                        break;
                    case GET_TRAIN_AND_PATH_LIST:
                        response = service.getTrainPath();
                        break;
                    case GET_TRAIN_TYPE_LIST:
                        response = service.getTrainTypeList();
                        break;
                    case CREATE_STATION:
                        Station station = (Station) request.getContent().get(ContentKey.STATION);
                        List<Pathmap> pathmapForwardList = (List<Pathmap>) request.getContent().get(ContentKey.PATHMAP_FORWARD_LIST);
                        List<Pathmap> pathmapBackList = (List<Pathmap>) request.getContent().get(ContentKey.PATHMAP_BACK_LIST);
                        response = service.createStation(station, pathmapForwardList, pathmapBackList);
                        break;
                    case CREATE_USER:
                        User user = (User) request.getContent().get(ContentKey.USER);
                        response = service.createUser(user);
                        break;
                    case IS_SIGNED_UP:
                        SuperUser userToFind = (SuperUser)request.getContent().get(ContentKey.USER);
                        response = service.isSignedUp(userToFind);
                        break;
                    default:
                        throw new UnsupportedOperationException("Unsupported query from client");
                }
            oos.writeObject(response);
            oos.flush();
            }
        }
        catch (Exception ex) {
            logError.error(ex);
        }
        finally {
            logInfo.info("Client disconnected");
            RailwayServer.getUsersOnline().remove(this);
            try {
                if (ois != null)
                        ois.close();
                if (oos != null)
                        oos.close();
                socket.close();
            } catch(IOException ex) {
                logError.error(ex);
            }
        }
    }

    public Socket getSocket() {
        return socket;
    }
}