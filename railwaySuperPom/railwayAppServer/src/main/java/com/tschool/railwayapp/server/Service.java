package com.tschool.railwayapp.server;

import com.tschool.railwayapp.commons.commands.CommandResponse;
import com.tschool.railwayapp.commons.commands.ContentKey;
import com.tschool.railwayapp.commons.entities.*;
import com.tschool.railwayapp.server.dao.RailwayDAO;
import com.tschool.railwayapp.commons.exceptions.FindException;
import com.tschool.railwayapp.commons.exceptions.SecondTicketException;
import com.tschool.railwayapp.commons.exceptions.SecondUserException;
import com.tschool.railwayapp.commons.exceptions.TicketAbsenceException;
import java.util.Date;
import java.util.List;

public class Service {
    
    RailwayDAO rDAO = new RailwayDAO();
    
    public CommandResponse getStationList() {
        CommandResponse response = new CommandResponse();
        try {
            rDAO.beginTransaction();
            List<Station> stationList = rDAO.getEntityList(Station.class);
            rDAO.commitTransaction();
            response.putContent(ContentKey.STATION_LIST, stationList);
        } catch (Exception ex) {
            response.setException(ex);
            return response;
        } 
        return response;
    }
    
    public CommandResponse createPath(Path path, List<Destination> destinationList) {
        CommandResponse response = new CommandResponse();
        int resultCode = 0;
        try {
            rDAO.beginTransaction();
            rDAO.addEntity(path);
            rDAO.addEntityList(destinationList);
            rDAO.commitTransaction();
            resultCode = 1;
        } catch (Exception ex) {
            response.setException(ex);
            response.setResultCode(resultCode);
            return response;
        } 
        response.setResultCode(resultCode);
        return response;
    }
    
    private Boolean isSecondTicket(Passenger passenger, Long timetableId) {
        List<Ticket> ticketList = passenger.getTicketList();
        
        for (Ticket ticket : ticketList) {
            TimeTable timetable = ticket.getTimetable();
            Long id = timetable.getId();
            if (id.toString().equals(timetableId.toString()))
                return true;
        }
        return false;
    }
    
    public CommandResponse createTicket(Ticket ticket, Passenger passenger) {
        CommandResponse response = new CommandResponse();
        int resultCode = 0;
        try {
            rDAO.beginTransaction();
            
            TimeTable timetable = ticket.getTimetable();
            
            boolean isPassengerExists;
            try {
                passenger = (Passenger) rDAO.findByPrimaryKey(Passenger.class, passenger.getPassport());
                isPassengerExists = true;
            } catch (FindException ex) {
                isPassengerExists = false;
            }
            if (isPassengerExists)
                if (isSecondTicket(passenger, timetable.getId()))
                    throw new SecondTicketException("This passenger has been already registered");
            
            rDAO.addEntity(passenger);
            
            timetable = (TimeTable) rDAO.findByPrimaryKey(TimeTable.class, timetable.getId());
            Integer freeSeats = timetable.getFreeSeats();
            if (freeSeats == 0) 
                throw new TicketAbsenceException("Tickets on this variant has just ended");
            freeSeats--;
            timetable.setFreeSeats(freeSeats);
            
            rDAO.addEntity(ticket);
            rDAO.commitTransaction();
            resultCode = 1;
        } catch (Exception ex) {
            response.setException(ex);
            response.setResultCode(resultCode);
            return response;
        } 
        response.setResultCode(resultCode);
        return response;
    }
    
    public CommandResponse createTimetable(TimeTable timeTable) {
        CommandResponse response = new CommandResponse();
        int resultCode = 0;
        try {
            rDAO.beginTransaction();
            rDAO.addEntity(timeTable);
            rDAO.commitTransaction();
            resultCode = 1;
        } catch (Exception ex) {
            response.setException(ex);
            response.setResultCode(resultCode);
            return response;
        } 
        response.setResultCode(resultCode);
        return response;
    }

    public CommandResponse createTrain(Train train) {
        CommandResponse response = new CommandResponse();
        int resultCode = 0;
        try {
            rDAO.beginTransaction();
            rDAO.addEntity(train);
            rDAO.commitTransaction();
            resultCode = 1;
        } catch (Exception ex) {
            response.setException(ex);
            response.setResultCode(resultCode);
            return response;
        } 
        response.setResultCode(resultCode);
        return response;
    }

    public CommandResponse getPathsFitStations(String stationFrom, String stationTo) {
        CommandResponse response = new CommandResponse();
        try {
            rDAO.beginTransaction();
            List<Path> pathList = rDAO.getEntityList(Path.class);
            List<Path> resultPaths = rDAO.whichPathsFitStations(pathList, stationFrom, stationTo);
            rDAO.commitTransaction();
            response.putContent(ContentKey.PATH_LIST, resultPaths);
        } catch (Exception ex) {
            response.setException(ex);
            return response;
        } 
        return response;
    }
    
    public CommandResponse getTimetablesFitPathsDate(String stationFrom, String stationTo, Date date) {
        CommandResponse response = new CommandResponse();
        try {
            rDAO.beginTransaction();
            List<Path> pathList = rDAO.getEntityList(Path.class);
            List<Path> fitPaths = rDAO.whichPathsFitStations(pathList, stationFrom, stationTo);
            List<TimeTable> timetableList = rDAO.whichTimetablesFitPathsDate(date, fitPaths);
            rDAO.commitTransaction();
            response.putContent(ContentKey.TIMETABLE_LIST, timetableList);
        } catch (Exception ex) {
            response.setException(ex);
            return response;
        } 
        return response;
    }
    
    public CommandResponse getTrainPath() {
        CommandResponse response = new CommandResponse();
        try {
            rDAO.beginTransaction();
            List<Train> trainList = rDAO.getEntityList(Train.class);
            List<Path> pathList = rDAO.getEntityList(Path.class);
            rDAO.commitTransaction();
            response.putContent(ContentKey.TRAIN_LIST, trainList);
            response.putContent(ContentKey.PATH_LIST, pathList);
        } catch (Exception ex) {
            response.setException(ex);
            return response;
        } 
        return response;
    }
    
    public CommandResponse getTrainTypeList() {
        CommandResponse response = new CommandResponse();
        try {
            rDAO.beginTransaction();
            List<TrainType> trainTypeList = rDAO.getEntityList(TrainType.class);
            response.putContent(ContentKey.TRAIN_TYPE_LIST, trainTypeList);
            rDAO.commitTransaction();
        } catch (Exception ex) {
            response.setException(ex);
            return response;
        } 
        return response;
    }
    
    public CommandResponse createStation(Station station, List<Pathmap> pathmapForwardList, List<Pathmap> pathmapBackList) {
        CommandResponse response = new CommandResponse();
        int resultCode = 0;
        try {
            rDAO.beginTransaction();
            rDAO.addEntity(station);
            rDAO.addEntityList(pathmapForwardList);
            rDAO.addEntityList(pathmapBackList);
            rDAO.commitTransaction();
            resultCode = 1;
        } catch (Exception ex) {
            response.setException(ex);
            response.setResultCode(resultCode);
            return response;
        } 
        response.setResultCode(resultCode);
        return response;
    }
    
    public CommandResponse createUser(User user) {
        CommandResponse response = new CommandResponse();
        int resultCode = 0;
        try {
            rDAO.beginTransaction();
            try {
                rDAO.findByPrimaryKey(User.class, user.getLogin());
                throw new SecondUserException("This user is already registered");
            } catch (FindException ex) {}
            
            rDAO.addEntity(user);
            rDAO.commitTransaction();
            resultCode = 1;
        } catch (Exception ex) {
            response.setException(ex);
            response.setResultCode(resultCode);
            return response;
        } 
        response.setResultCode(resultCode);
        return response;
    }
    
    public CommandResponse isSignedUp(SuperUser userToFind) {
        CommandResponse response = new CommandResponse();
        int resultCode = 0;
        try {
            rDAO.beginTransaction();
            SuperUser user = (SuperUser) rDAO.findByPrimaryKey(SuperUser.class, userToFind.getLogin());
            rDAO.commitTransaction();
            if (userToFind.getPassword().equals(user.getPassword())) {
                if (user instanceof User)
                    resultCode = 1;
                else resultCode = 2;
            }
        } catch (Exception ex) {
            response.setException(ex);
            response.setResultCode(resultCode);
            return response;
        } 
        response.setResultCode(resultCode);
        return response;
    }
}