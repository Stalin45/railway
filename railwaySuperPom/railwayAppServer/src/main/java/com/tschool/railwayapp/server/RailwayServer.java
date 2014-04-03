package com.tschool.railwayapp.server;

import com.tschool.railwayapp.commons.entities.*;
import com.tschool.railwayapp.commons.logger.LogUtils;
import com.tschool.railwayapp.server.dao.RailwayDAO;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

public class RailwayServer extends Thread {

    private ServerSocket serverSocket;
    private final Integer port = 7777;
    private static volatile Boolean keepRunning = true;
    private static volatile List<ConnectionHandlerServer> usersOnline = new ArrayList<ConnectionHandlerServer>();
    private Logger logInfo;
    private Logger logError;

    @Override
    public void run() {    
   
        logError = LogUtils.getErrorLogger();
        logInfo = LogUtils.getInfoLogger();
        try {
            initializeServer();
        } catch (IOException ex) {
            logError.error(ex);
        }
    }

    private void initializeServer() throws IOException {
//// 
        logInfo.info("Server is starting...");
        serverSocket = new ServerSocket(port);
        logInfo.info("Server started on port: " + port.toString());
        while (keepRunning) {
            Socket socket = serverSocket.accept();
            if (keepRunning) {
                logInfo.info("New client connected");
                usersOnline.add(new ConnectionHandlerServer(socket));
            } else {
                logInfo.info("Server is closing...");
                for (ConnectionHandlerServer user : RailwayServer.getUsersOnline()) {
                    user.getSocket().close();
                }
                serverSocket.close();
                logInfo.info("Server closed");
            }
        }
    }

    public static Boolean isKeepRunning() {
        return keepRunning;
    }

    public static void setKeepRunning(Boolean keepRunning) {
        RailwayServer.keepRunning = keepRunning;
    }

    public static List<ConnectionHandlerServer> getUsersOnline() {
        return usersOnline;
    }

    public static void setUsersOnline(List<ConnectionHandlerServer> usersOnline) {
        RailwayServer.usersOnline = usersOnline;
    }
}

       
//        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
//        SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm");
//        Date date1 = null;
//        Date date2 = null;
//        Date date3 = null;
//        Date date4 = null;
//        Date time1 = null;
//        Date time2 = null;
//        Date time3 = null;
//        Date time4 = null;
//        try {
//            date1 = sdf.parse("20.04.2014");
//            date2 = sdf.parse("21.04.2014");
//            date3 = sdf.parse("22.04.2014");
//            date4 = sdf.parse("22.04.2014");
//            time1 = sdf2.parse("1:10");
//            time2 = sdf2.parse("3:54");
//            time3 = sdf2.parse("4:51");
//            time4 = sdf2.parse("6:18");
//        } catch (ParseException ex) {
//        }
//RailwayDAO rDAO = new RailwayDAO();
//                try {
//            rDAO.beginTransaction();
//            //Default settings         
//            TrainType ttp1 = new TrainType("normal", 1F);
//            TrainType ttp2 = new TrainType("fast", 1.4F);
//            
//            Station st1 = new Station("moscow");
//            Station st2 = new Station("petersburg");
//            Station st3 = new Station("gatchina");
//            Station st4 = new Station("pushkin");
//            
//            Pathmap pm1 = new Pathmap(st1, st2, 500F);
//            Pathmap pm2 = new Pathmap(st2, st1, 500F);
//            Pathmap pm3 = new Pathmap(st2, st3, 100F);
//            Pathmap pm4 = new Pathmap(st2, st4, 200F);
//            Pathmap pm5 = new Pathmap(st3, st2, 100F);
//            Pathmap pm6 = new Pathmap(st3, st4, 50F);
//            Pathmap pm7 = new Pathmap(st4, st2, 200F);
//            
//            Path ph1 = new Path();
//            Path ph2 = new Path();
//            
//            Destination dn1 = new Destination(1, st1, time1, ph1);
//            Destination dn2 = new Destination(2, st2, time2, ph1);
//            Destination dn3 = new Destination(3, st3, time3, ph1);
//            Destination dn4 = new Destination(1, st3, time1, ph2);
//            Destination dn5 = new Destination(2, st2, time2, ph2);
//            Destination dn6 = new Destination(3, st3, time3, ph2);
//            Destination dn7 = new Destination(4, st4, time4, ph2);
//            
//            //--------------------------//
//            //To add a train
//            Train tr1 = new Train(ttp1, 100);
//            Train tr2 = new Train(ttp2, 200);
//            
//            TimeTable ttb1 = new TimeTable(tr1, ph1, date1, 100);
//            TimeTable ttb2 = new TimeTable(tr1, ph1, date3, 100);
//            TimeTable ttb3 = new TimeTable(tr2, ph2, date3, 200);
//            TimeTable ttb4 = new TimeTable(tr2, ph2, date2, 200);
//            //----------------//
//
//            User user1 = new User();
//            user1.setLogin("user1");
//            user1.setPassword("pass1");
//            
//            Specialist spec1 = new Specialist();
//            spec1.setLogin("spec1");
//            spec1.setPassword("pass2");            
//            
//            rDAO.addEntity(ttp1);
//            rDAO.addEntity(ttp2);
//            
//            rDAO.addEntity(st1);
//            rDAO.addEntity(st2);
//            rDAO.addEntity(st3);
//            rDAO.addEntity(st4);    
//            
//            rDAO.addEntity(pm1);
//            rDAO.addEntity(pm2);
//            rDAO.addEntity(pm3);
//            rDAO.addEntity(pm4);
//            rDAO.addEntity(pm5);
//            rDAO.addEntity(pm6);
//            rDAO.addEntity(pm7);
//            
//            rDAO.addEntity(ph1);
//            rDAO.addEntity(ph2);
//            
//            rDAO.addEntity(tr1);
//            rDAO.addEntity(tr2);
//            
//            rDAO.addEntity(ttb1);
//            rDAO.addEntity(ttb2);
//            rDAO.addEntity(ttb3);
//            rDAO.addEntity(ttb4); 
//            
//            rDAO.addEntity(dn1);
//            rDAO.addEntity(dn2);
//            rDAO.addEntity(dn3);
//            rDAO.addEntity(dn4);
//            rDAO.addEntity(dn5);
//            rDAO.addEntity(dn6);
//            rDAO.addEntity(dn7);
//            
//            rDAO.addEntity(ttb1);
//            rDAO.addEntity(ttb2);
//            rDAO.addEntity(ttb3);
//            rDAO.addEntity(ttb4);
//            
//            rDAO.addEntity(user1);
//            rDAO.addEntity(spec1);
//                    
//            rDAO.commitTransaction();
//        }
//        catch(Exception e) {
//                e.printStackTrace();
//        }