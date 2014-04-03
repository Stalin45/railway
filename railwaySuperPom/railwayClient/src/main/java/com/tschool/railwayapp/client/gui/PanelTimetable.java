package com.tschool.railwayapp.client.gui;

import com.tschool.railwayapp.client.ConnectionHandlerClient;
import com.tschool.railwayapp.commons.commands.*;
import com.tschool.railwayapp.commons.entities.*;
import com.tschool.railwayapp.commons.logger.LogUtils;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PanelTimetable extends javax.swing.JPanel implements Refreshable {

    private org.apache.log4j.Logger logInfo;
    private org.apache.log4j.Logger logError;
    
    private FrameClientTerminal outerFrame;
    private ConnectionHandlerClient handler;
    private FrameDestinations fd;
    private List<Train> trainList;
    private List<Path> pathList;
    private List<Destination> destinationList = new ArrayList<Destination>();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    private Date date;
    private Train train;
    private Path path;
    
    public PanelTimetable(FrameClientTerminal outerFrame) {
        logError = LogUtils.getErrorLogger();
        logInfo  = LogUtils.getInfoLogger();
        this.outerFrame = outerFrame;
        initComponents();
    }
    
    @Override
    public void refreshPanel() {
        try {
            handler = ConnectionHandlerClient.getConnectionInstance();
            CommandRequest request = new CommandRequest();
            request.setCommand(Command.GET_TRAIN_AND_PATH_LIST);
        
            CommandResponse response = handler.sendCommand(request);
            Exception ex = response.getException();
            if (ex != null)
                throw ex;
            trainList = (List<Train>) response.getContent().get(ContentKey.TRAIN_LIST);
            pathList = (List<Path>) response.getContent().get(ContentKey.PATH_LIST);
 
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
        trainComboBox.removeAllItems();
        pathComboBox.removeAllItems();
        for(Train _train : trainList)
            trainComboBox.addItem(_train);
        for(Path _path : pathList)
            pathComboBox.addItem(_path);
        trainComboBox.setSelectedIndex(0);
        pathComboBox.setSelectedIndex(0);
        dateTextField.setText("");
        chooseTrain();
        choosePath();
    }   

    private void chooseTrain() {
        train = (Train) trainComboBox.getSelectedItem();
    }
    
    private void choosePath() {
        if (pathComboBox.getSelectedItem() != null) {
            path = (Path) pathComboBox.getSelectedItem();
            destinationList = path.getDestination();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        p_ExistedTrain1 = new javax.swing.JPanel();
        trainLabel = new javax.swing.JLabel();
        trainComboBox = new javax.swing.JComboBox();
        pathLabel = new javax.swing.JLabel();
        pathComboBox = new javax.swing.JComboBox();
        dateLabel = new javax.swing.JLabel();
        dateTextField = new javax.swing.JTextField();
        viewDestButton = new javax.swing.JButton();
        timetableLabel = new javax.swing.JLabel();
        addInTimetableButton = new javax.swing.JButton();

        setName("Modify timetable"); // NOI18N
        setPreferredSize(new java.awt.Dimension(490, 530));

        p_ExistedTrain1.setBackground(new java.awt.Color(255, 255, 255));

        trainLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        trainLabel.setText("Train:");
        trainLabel.setToolTipText("");
        trainLabel.setName(""); // NOI18N

        trainComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        trainComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainComboBoxActionPerformed(evt);
            }
        });

        pathLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pathLabel.setText("Path №:");
        pathLabel.setToolTipText("");
        pathLabel.setName(""); // NOI18N

        pathComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pathComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pathComboBoxActionPerformed(evt);
            }
        });

        dateLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateLabel.setText("Date:");
        dateLabel.setToolTipText("");
        dateLabel.setName(""); // NOI18N

        dateTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        viewDestButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        viewDestButton.setText("view destinations");
        viewDestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDestButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p_ExistedTrain1Layout = new javax.swing.GroupLayout(p_ExistedTrain1);
        p_ExistedTrain1.setLayout(p_ExistedTrain1Layout);
        p_ExistedTrain1Layout.setHorizontalGroup(
            p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                        .addComponent(dateLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                        .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(trainLabel)
                                    .addComponent(pathLabel))
                                .addGap(26, 26, 26)
                                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(trainComboBox, 0, 133, Short.MAX_VALUE)
                                    .addComponent(pathComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(viewDestButton)
                        .addGap(32, 32, 32))))
        );
        p_ExistedTrain1Layout.setVerticalGroup(
            p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trainComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewDestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        timetableLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        timetableLabel.setText("Modify timetable:");
        timetableLabel.setToolTipText("");
        timetableLabel.setName(""); // NOI18N

        addInTimetableButton.setBackground(new java.awt.Color(204, 255, 204));
        addInTimetableButton.setText("Modify");
        addInTimetableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addInTimetableButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(addInTimetableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(170, 170, 170)
                            .addComponent(timetableLabel))
                        .addGroup(layout.createSequentialGroup()
                            .addGap(27, 27, 27)
                            .addComponent(p_ExistedTrain1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(timetableLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(p_ExistedTrain1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addInTimetableButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(224, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void trainComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainComboBoxActionPerformed
        chooseTrain();
    }//GEN-LAST:event_trainComboBoxActionPerformed

    private void pathComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathComboBoxActionPerformed
        choosePath();
    }//GEN-LAST:event_pathComboBoxActionPerformed

    private void addInTimetableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addInTimetableButtonActionPerformed
        try {
            int maxSeats = train.getMaxSeats();
            
            try {
                date = sdf.parse(dateTextField.getText());
            } catch(ParseException ex) {
                logInfo.warn("Please, input time in a correct form (like 12:00)");
                return;
            }
            
            TimeTable timeTable = new TimeTable();
            timeTable.setTrain(train);
            timeTable.setPath(path);
            timeTable.setDate(date);
            timeTable.setFreeSeats(maxSeats);
            
            CommandRequest request = new CommandRequest();
            request.setCommand(Command.CREATE_TIMETABLE);
            request.putContent(ContentKey.TIMETABLE,timeTable);
            
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
            System.out.println(ex);
        }
    }//GEN-LAST:event_addInTimetableButtonActionPerformed

    private void viewDestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDestButtonActionPerformed
        if (fd != null)
            fd.dispose();
        fd = new FrameDestinations(path);
        fd.setVisible(true);
    }//GEN-LAST:event_viewDestButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addInTimetableButton;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JPanel p_ExistedTrain1;
    private javax.swing.JComboBox pathComboBox;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JLabel timetableLabel;
    private javax.swing.JComboBox trainComboBox;
    private javax.swing.JLabel trainLabel;
    private javax.swing.JButton viewDestButton;
    // End of variables declaration//GEN-END:variables
}
