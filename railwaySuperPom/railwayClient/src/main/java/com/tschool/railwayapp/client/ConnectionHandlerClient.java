package com.tschool.railwayapp.client;

import com.tschool.railwayapp.commons.commands.Command;
import com.tschool.railwayapp.commons.commands.CommandRequest;
import com.tschool.railwayapp.commons.commands.CommandResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ConnectionHandlerClient {
    
    private static ConnectionHandlerClient ch; 
    private static Socket clientSocket;
    private static ObjectOutputStream oos = null;
    private static ObjectInputStream ois = null;
    
    private ConnectionHandlerClient(String host, Integer port) throws UnknownHostException, ConnectException, IOException {
        initializeClientAndConnect(host, port);
    }
    
    private void initializeClientAndConnect(String host, Integer port) throws UnknownHostException, ConnectException, IOException {
            clientSocket = new Socket(host, port);
            oos = new ObjectOutputStream(clientSocket.getOutputStream());
            ois = new ObjectInputStream(clientSocket.getInputStream());
    }
    
    public static ConnectionHandlerClient getConnectionInstance() throws UnknownHostException, ConnectException, IOException {
        if (clientSocket == null || clientSocket.isClosed())
            synchronized(ConnectionHandlerClient.class) {
                if (clientSocket == null || clientSocket.isClosed()) {
                    ch = new ConnectionHandlerClient("localhost", 7777);
                }
            }
        return ch;
    }
    
    public CommandResponse sendCommand(CommandRequest request) throws IOException, ClassNotFoundException {
        CommandResponse response = new CommandResponse();
        oos.writeObject(request);
        oos.flush();
        response = (CommandResponse) ois.readObject();
        return response;
    }
    
    public static void closeSocket() throws IOException {
        clientSocket.close();
    }
}
