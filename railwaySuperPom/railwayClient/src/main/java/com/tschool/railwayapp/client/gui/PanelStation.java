package com.tschool.railwayapp.client.gui;

import com.tschool.railwayapp.client.ConnectionHandlerClient;
import com.tschool.railwayapp.commons.commands.Command;
import com.tschool.railwayapp.commons.commands.CommandRequest;
import com.tschool.railwayapp.commons.commands.CommandResponse;
import com.tschool.railwayapp.commons.commands.ContentKey;
import com.tschool.railwayapp.commons.entities.Pathmap;
import com.tschool.railwayapp.commons.entities.Station;
import com.tschool.railwayapp.commons.logger.LogUtils;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class PanelStation extends javax.swing.JPanel implements Refreshable {

    private org.apache.log4j.Logger logInfo;
    private org.apache.log4j.Logger logError;
    
    private FrameClientTerminal outerFrame;
    private ConnectionHandlerClient handler;
    private List<Station> stationList = new ArrayList<Station>();
    private List<Pathmap> pathmapForwardList = new ArrayList<Pathmap>();
    private List<Pathmap> pathmapBackList = new ArrayList<Pathmap>();
    private Station nextStation;
    private Float cost;
    
    NotEditTableModel tm;
    
    public PanelStation(FrameClientTerminal outerFrame) {
        logError = LogUtils.getErrorLogger();
        logInfo  = LogUtils.getInfoLogger();
        this.outerFrame = outerFrame;
        initComponents();
        
        String[] columnNames = {"Station", "Regular cost", "Bidirectional"};
        tm = new NotEditTableModel(columnNames, 0);
        pathmapsTable.setModel(tm);
        
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
        pathmapForwardList.clear();
        pathmapBackList.clear();
        while (tm.getRowCount() != 0)
            tm.removeRow(0);
        nextStationComboBox.removeAllItems();
        for(Station station : stationList)
            nextStationComboBox.addItem(station);
        nextStationComboBox.setSelectedIndex(0);
        bidirectionalChBox.setSelected(false);
        stationNameTextField.setText("");
        costTextField.setText("0");
        chooseNextStation();
    }    
    
    private void chooseNextStation() {
        nextStation = ((Station) nextStationComboBox.getSelectedItem());
    }  
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_ExistedTrain1 = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        stationNameTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        pathmapsTable = new javax.swing.JTable();
        relationsLabel = new javax.swing.JLabel();
        stationsLabel = new javax.swing.JLabel();
        costLabel = new javax.swing.JLabel();
        costTextField = new javax.swing.JTextField();
        addRelationButton = new javax.swing.JButton();
        nextStationComboBox = new javax.swing.JComboBox();
        bidirectionalChBox = new javax.swing.JCheckBox();
        stationLabel = new javax.swing.JLabel();
        addStationButton = new javax.swing.JButton();

        setName("Add station"); // NOI18N
        setPreferredSize(new java.awt.Dimension(490, 530));

        p_ExistedTrain1.setBackground(new java.awt.Color(255, 255, 255));

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameLabel.setText("Name:");
        nameLabel.setToolTipText("");
        nameLabel.setName(""); // NOI18N

        stationNameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        pathmapsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Station", "Cost", "Bidirectional"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(pathmapsTable);

        relationsLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        relationsLabel.setText("Relations with other stations:");
        relationsLabel.setToolTipText("");
        relationsLabel.setName(""); // NOI18N

        stationsLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stationsLabel.setText("station:");
        stationsLabel.setToolTipText("");
        stationsLabel.setName(""); // NOI18N

        costLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        costLabel.setText("Regular cost:");
        costLabel.setToolTipText("");
        costLabel.setName(""); // NOI18N

        costTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        costTextField.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        costTextField.setText("0");

        addRelationButton.setBackground(new java.awt.Color(255, 255, 255));
        addRelationButton.setText("Bind");
        addRelationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addRelationButtonActionPerformed(evt);
            }
        });

        nextStationComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        nextStationComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextStationComboBoxActionPerformed(evt);
            }
        });

        bidirectionalChBox.setBackground(new java.awt.Color(255, 255, 255));
        bidirectionalChBox.setText("Bidirectional");

        javax.swing.GroupLayout p_ExistedTrain1Layout = new javax.swing.GroupLayout(p_ExistedTrain1);
        p_ExistedTrain1.setLayout(p_ExistedTrain1Layout);
        p_ExistedTrain1Layout.setHorizontalGroup(
            p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                            .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(stationsLabel)
                                .addComponent(costLabel))
                            .addGap(26, 26, 26)
                            .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nextStationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(costTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(18, 18, 18)
                            .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(addRelationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(bidirectionalChBox)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addComponent(relationsLabel))
                    .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                        .addComponent(nameLabel)
                        .addGap(18, 18, 18)
                        .addComponent(stationNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(43, Short.MAX_VALUE))
        );
        p_ExistedTrain1Layout.setVerticalGroup(
            p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stationNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(relationsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stationsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nextStationComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bidirectionalChBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(costLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addRelationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        stationLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        stationLabel.setText("Add new Station:");
        stationLabel.setToolTipText("");
        stationLabel.setName(""); // NOI18N

        addStationButton.setBackground(new java.awt.Color(204, 255, 204));
        addStationButton.setText("Add station");
        addStationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addStationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(p_ExistedTrain1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addStationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(stationLabel)
                        .addGap(167, 167, 167))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(p_ExistedTrain1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addStationButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void addStationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addStationButtonActionPerformed
        try {
            if (stationNameTextField.getText().isEmpty()) {
                return;
            }
            else if (tm.getRowCount() == 0) {
                return;
            }
            Station station = new Station();
            station.setName(stationNameTextField.getText());
            
            for(int i =0; i<pathmapForwardList.size(); i++)
                pathmapForwardList.get(i).setCurrentStation(station);
            for(int i =0; i<pathmapBackList.size(); i++)
                pathmapBackList.get(i).setNextStation(station);
            
            CommandRequest request = new CommandRequest();
            request.setCommand(Command.CREATE_STATION);
            request.putContent(ContentKey.STATION, station);
            request.putContent(ContentKey.PATHMAP_FORWARD_LIST, pathmapForwardList);
            request.putContent(ContentKey.PATHMAP_BACK_LIST, pathmapBackList);
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
    }//GEN-LAST:event_addStationButtonActionPerformed

    private void addRelationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addRelationButtonActionPerformed
        if (nextStationComboBox.getItemCount() == 0) {
            logInfo.info("No stations to add");
            return;
        }
        Pathmap pathmapForward = new Pathmap();
        
        try {
            cost = Float.valueOf(costTextField.getText());
        } catch(NumberFormatException ex) {
            return;
        }
        
        pathmapForward.setCost(cost);
        pathmapForward.setNextStation(nextStation);
        pathmapForwardList.add(pathmapForward);
        
        if (bidirectionalChBox.isSelected()) {
            Pathmap pathmapBack = new Pathmap();
            pathmapBack.setCost(cost);
            pathmapBack.setCurrentStation(nextStation);
            pathmapBackList.add(pathmapBack);
        }
        
        Vector<String> relation = new Vector<String>();
        relation.add(nextStation.toString());
        relation.add(cost.toString());
        relation.add(String.valueOf(bidirectionalChBox.isSelected()));
        tm.addRow(relation);
        
        nextStationComboBox.removeItem(nextStation);
        
        bidirectionalChBox.setSelected(false);
        costTextField.setText("0");
        logInfo.info("New station is binded");
    }//GEN-LAST:event_addRelationButtonActionPerformed

    private void nextStationComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextStationComboBoxActionPerformed
        chooseNextStation();
    }//GEN-LAST:event_nextStationComboBoxActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addRelationButton;
    private javax.swing.JButton addStationButton;
    private javax.swing.JCheckBox bidirectionalChBox;
    private javax.swing.JLabel costLabel;
    private javax.swing.JTextField costTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JComboBox nextStationComboBox;
    private javax.swing.JPanel p_ExistedTrain1;
    private javax.swing.JTable pathmapsTable;
    private javax.swing.JLabel relationsLabel;
    private javax.swing.JLabel stationLabel;
    private javax.swing.JTextField stationNameTextField;
    private javax.swing.JLabel stationsLabel;
    // End of variables declaration//GEN-END:variables
}
