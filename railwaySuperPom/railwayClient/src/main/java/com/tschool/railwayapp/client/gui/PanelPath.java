package com.tschool.railwayapp.client.gui;

import com.tschool.railwayapp.client.ConnectionHandlerClient;
import com.tschool.railwayapp.commons.commands.Command;
import com.tschool.railwayapp.commons.commands.CommandRequest;
import com.tschool.railwayapp.commons.commands.CommandResponse;
import com.tschool.railwayapp.commons.commands.ContentKey;
import com.tschool.railwayapp.commons.entities.Destination;
import com.tschool.railwayapp.commons.entities.Path;
import com.tschool.railwayapp.commons.entities.Pathmap;
import com.tschool.railwayapp.commons.entities.Station;
import com.tschool.railwayapp.commons.logger.LogUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PanelPath extends javax.swing.JPanel implements Refreshable {

    private org.apache.log4j.Logger logInfo;
    private org.apache.log4j.Logger logError;
    
    private FrameClientTerminal outerFrame;
    private ConnectionHandlerClient handler;
    private List<Station> stationList = new ArrayList<Station>();
    private List<Destination> destinationList = new ArrayList<Destination>();
    private Station nextStation;
    private Integer numberInPath;
    private Date time;
    private SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
    
    private NotEditTableModel tm;
    
    public PanelPath(FrameClientTerminal outerFrame) {
        logError = LogUtils.getErrorLogger();
        logInfo  = LogUtils.getInfoLogger();
        this.outerFrame = outerFrame;
        initComponents();
        
        String[] columnNames = {"Station", "Time"};
        tm = new NotEditTableModel(columnNames, 0);
        destTable.setModel(tm);
        
        refreshPanel();
    }

    @Override
    public void refreshPanel() {
        try {
            handler = ConnectionHandlerClient.getConnectionInstance();
            CommandRequest request = new CommandRequest();
            request.setCommand(Command.GET_STATION_LIST);
        
            CommandResponse response = handler.sendCommand(request);
            Exception ex = response.getException();
            if (ex != null)
                throw ex;
            stationList = (List<Station>) response.getContent().get(ContentKey.STATION_LIST);
        
            defaultVariables();
        } catch (IOException ex) {
            //Poppup menu
            logError.error("Can't connect to the server");
            outerFrame.logout();
        } catch (Exception ex) {
            logError.error(ex);
        }
    }
    
    private void defaultVariables() {
        destinationList.clear();
        nextStationChBox.removeAllItems();
        numberInPath = 0;
        while (tm.getRowCount() != 0)
            tm.removeRow(0);
        for(Station station : stationList)
            nextStationChBox.addItem(station);
        timeTextField.setText("00:00");
    }    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_ExistedTrain1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        destTable = new javax.swing.JTable();
        defineDestLabel = new javax.swing.JLabel();
        nextStationLabel = new javax.swing.JLabel();
        timeLabel = new javax.swing.JLabel();
        timeTextField = new javax.swing.JTextField();
        addRelationButton = new javax.swing.JButton();
        nextStationChBox = new javax.swing.JComboBox();
        pathLabel = new javax.swing.JLabel();
        addPathButton = new javax.swing.JButton();

        setName("Add path"); // NOI18N

        p_ExistedTrain1.setBackground(new java.awt.Color(255, 255, 255));

        destTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}
            },
            new String [] {
                "Station", "Time"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(destTable);

        defineDestLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        defineDestLabel.setText("Define destinations:");
        defineDestLabel.setToolTipText("");
        defineDestLabel.setName(""); // NOI18N

        nextStationLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nextStationLabel.setText("Next station:");
        nextStationLabel.setToolTipText("");
        nextStationLabel.setName(""); // NOI18N

        timeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        timeLabel.setText("Time:");
        timeLabel.setToolTipText("");
        timeLabel.setName(""); // NOI18N

        timeTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        timeTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        addRelationButton.setBackground(new java.awt.Color(255, 255, 255));
        addRelationButton.setText("Add destination");
        addRelationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRelationButtonActionPerformed(evt);
            }
        });

        nextStationChBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout p_ExistedTrain1Layout = new javax.swing.GroupLayout(p_ExistedTrain1);
        p_ExistedTrain1.setLayout(p_ExistedTrain1Layout);
        p_ExistedTrain1Layout.setHorizontalGroup(
            p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                        .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nextStationLabel)
                            .addComponent(timeLabel))
                        .addGap(26, 26, 26)
                        .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(nextStationChBox, 0, 143, Short.MAX_VALUE)
                            .addComponent(timeTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(addRelationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 363, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(defineDestLabel))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        p_ExistedTrain1Layout.setVerticalGroup(
            p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(defineDestLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                        .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nextStationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nextStationChBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(timeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(timeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(addRelationButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pathLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        pathLabel.setText("Add new path:");
        pathLabel.setToolTipText("");
        pathLabel.setName(""); // NOI18N

        addPathButton.setBackground(new java.awt.Color(204, 255, 204));
        addPathButton.setText("Add path");
        addPathButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addPathButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(pathLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addPathButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(p_ExistedTrain1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(p_ExistedTrain1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addPathButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addRelationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRelationButtonActionPerformed
        if (nextStationChBox.getItemCount() == 0) {
            logInfo.warn("No stations to add");
            return;
        }
        try {
            time = sdf.parse(timeTextField.getText());
        }
        catch(ParseException ex) {
            logError.error(ex);
            return;
        }
        
        nextStation = ((Station) nextStationChBox.getSelectedItem());
        
        Destination destination = new Destination();

        destination.setNumber(++numberInPath);
        destination.setStation(nextStation);
        destination.setTime(time);

        destinationList.add(destination);

        Vector<String> relation = new Vector<String>();
        relation.add(nextStation.toString());
        relation.add(timeTextField.getText());
        tm.addRow(relation);

        List<Pathmap> pathmapList = nextStation.getCurrentStations();
        stationList.clear();
        nextStationChBox.removeAllItems();
        for(Pathmap pathmap : pathmapList) {
            stationList.add(pathmap.getNextStation());
            nextStationChBox.addItem(pathmap.getNextStation());
        }
        logInfo.info("The new length of the path: " + destinationList.size() + " station(s)");
        
    }//GEN-LAST:event_addRelationButtonActionPerformed

    private void addPathButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addPathButtonActionPerformed
        try {
            if (tm.getRowCount() == 0) {
                logInfo.warn("No stations selected");
                return;
            }
            
            Path path = new Path();
            
            for(Destination destination : destinationList) {
                destination.setPath(path);
            }
            
            CommandRequest request = new CommandRequest();
            request.setCommand(Command.CREATE_PATH);
            request.putContent(ContentKey.PATH, path);
            request.putContent(ContentKey.DESTINATION_LIST, destinationList);
            //
            CommandResponse response = handler.sendCommand(request);
            Exception ex = response.getException();
            if (ex != null)
                throw ex;
            logInfo.info("Successfuly");
            refreshPanel();
        } catch (IOException ex) {
            //Poppup menu
            logError.error("Can't connect to the server");
            outerFrame.logout();
        } catch (Exception ex) {
            logError.error(ex);
        }
    }//GEN-LAST:event_addPathButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addPathButton;
    private javax.swing.JButton addRelationButton;
    private javax.swing.JLabel defineDestLabel;
    private javax.swing.JTable destTable;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox nextStationChBox;
    private javax.swing.JLabel nextStationLabel;
    private javax.swing.JPanel p_ExistedTrain1;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JLabel timeLabel;
    private javax.swing.JTextField timeTextField;
    // End of variables declaration//GEN-END:variables
}
