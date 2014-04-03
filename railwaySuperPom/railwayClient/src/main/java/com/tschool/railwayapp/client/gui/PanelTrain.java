package com.tschool.railwayapp.client.gui;

import com.tschool.railwayapp.client.ConnectionHandlerClient;
import com.tschool.railwayapp.commons.commands.*;
import com.tschool.railwayapp.commons.entities.*;
import com.tschool.railwayapp.commons.logger.LogUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PanelTrain extends javax.swing.JPanel implements Refreshable {

    private org.apache.log4j.Logger logInfo;
    private org.apache.log4j.Logger logError;
    
    private FrameClientTerminal outerFrame;
    private ConnectionHandlerClient handler;
    private List<TrainType> trainTypeList = new ArrayList<TrainType>();
    private TrainType trainType;
    private Integer maxSeats;
    
    public PanelTrain(FrameClientTerminal outerFrame) {
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
            request.setCommand(Command.GET_TRAIN_TYPE_LIST);
        
            CommandResponse response = handler.sendCommand(request);
            Exception ex = response.getException();
            if (ex != null)
                throw ex;
            trainTypeList = (List<TrainType>) response.getContent().get(ContentKey.TRAIN_TYPE_LIST);
        
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
        trainTypeComboBox.removeAllItems();
        for(TrainType trainType : trainTypeList)
            trainTypeComboBox.addItem(trainType);
        trainTypeComboBox.setSelectedIndex(0);
        seatsTextField.setText("");
        chooseTrainType();
    }    
    
    private void chooseTrainType() {
        trainType = ((TrainType) trainTypeComboBox.getSelectedItem());
    }  

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        trainLabel = new javax.swing.JLabel();
        p_ExistedTrain1 = new javax.swing.JPanel();
        trainTypeLabel = new javax.swing.JLabel();
        trainTypeComboBox = new javax.swing.JComboBox();
        seatsLabel = new javax.swing.JLabel();
        seatsTextField = new javax.swing.JTextField();
        addTrainButton = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        setName("Manage trains"); // NOI18N
        setPreferredSize(new java.awt.Dimension(490, 530));

        trainLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        trainLabel.setText("Add new train:");
        trainLabel.setToolTipText("");
        trainLabel.setName(""); // NOI18N

        p_ExistedTrain1.setBackground(new java.awt.Color(255, 255, 255));

        trainTypeLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        trainTypeLabel.setText("Train type:");
        trainTypeLabel.setToolTipText("");
        trainTypeLabel.setName(""); // NOI18N

        trainTypeComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        trainTypeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trainTypeComboBoxActionPerformed(evt);
            }
        });

        seatsLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        seatsLabel.setText("Seats:");
        seatsLabel.setToolTipText("");
        seatsLabel.setName(""); // NOI18N

        seatsTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout p_ExistedTrain1Layout = new javax.swing.GroupLayout(p_ExistedTrain1);
        p_ExistedTrain1.setLayout(p_ExistedTrain1Layout);
        p_ExistedTrain1Layout.setHorizontalGroup(
            p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p_ExistedTrain1Layout.createSequentialGroup()
                .addContainerGap(99, Short.MAX_VALUE)
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(trainTypeLabel)
                    .addComponent(seatsLabel))
                .addGap(26, 26, 26)
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(seatsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trainTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90))
        );
        p_ExistedTrain1Layout.setVerticalGroup(
            p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trainTypeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(trainTypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seatsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(seatsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        addTrainButton.setBackground(new java.awt.Color(204, 255, 204));
        addTrainButton.setText("Add");
        addTrainButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTrainButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(addTrainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(p_ExistedTrain1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(173, 173, 173)
                        .addComponent(trainLabel)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(trainLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(p_ExistedTrain1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(addTrainButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(273, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    
    private void addTrainButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTrainButtonActionPerformed
        try {
            try {
                maxSeats = Integer.valueOf(seatsTextField.getText());
            } catch(NumberFormatException ex) {
                return;
            }
            
            Train train = new Train();
            train.setMaxSeats(maxSeats);
            train.setTrainType(trainType);
            
            CommandRequest request = new CommandRequest();
            request.setCommand(Command.CREATE_TRAIN);
            request.putContent(ContentKey.TRAIN,train);
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
    }//GEN-LAST:event_addTrainButtonActionPerformed

    private void trainTypeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trainTypeComboBoxActionPerformed
        chooseTrainType();
    }//GEN-LAST:event_trainTypeComboBoxActionPerformed
      
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTrainButton;
    private javax.swing.JPanel p_ExistedTrain1;
    private javax.swing.JLabel seatsLabel;
    private javax.swing.JTextField seatsTextField;
    private javax.swing.JLabel trainLabel;
    private javax.swing.JComboBox trainTypeComboBox;
    private javax.swing.JLabel trainTypeLabel;
    // End of variables declaration//GEN-END:variables
}
