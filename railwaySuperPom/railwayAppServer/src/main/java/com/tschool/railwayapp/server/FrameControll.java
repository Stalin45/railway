package com.tschool.railwayapp.server;

import com.tschool.railwayapp.commons.logger.LogUtils;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import org.apache.log4j.Logger;

public class FrameControll extends javax.swing.JFrame {

    private RailwayServer serverThread;
    private Logger logInfo;
    private Logger logError;
    
    public FrameControll() {
        initComponents();
        logError = LogUtils.getErrorLogger();
        logInfo  = LogUtils.getInfoLogger();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        startServerButton = new javax.swing.JButton();
        serverLabel = new javax.swing.JLabel();
        serverSwitchLabel = new javax.swing.JLabel();
        quitButton = new javax.swing.JButton();
        stopServerButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Railway server");

        startServerButton.setBackground(new java.awt.Color(204, 255, 204));
        startServerButton.setText("Start server");
        startServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startServerButtonActionPerformed(evt);
            }
        });

        serverLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        serverLabel.setText("Server is:");

        serverSwitchLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        serverSwitchLabel.setText("OFF");

        quitButton.setBackground(new java.awt.Color(255, 204, 204));
        quitButton.setText("Quit");
        quitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quitButtonActionPerformed(evt);
            }
        });

        stopServerButton.setBackground(new java.awt.Color(255, 204, 204));
        stopServerButton.setText("Stop server");
        stopServerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopServerButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(stopServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(startServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51)
                .addComponent(serverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(serverSwitchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(49, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(startServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serverLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(serverSwitchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(stopServerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(quitButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        new FrameControll().setVisible(true);
    }
    
    private void stopServer() throws IOException {
        if (serverThread != null) {
            RailwayServer.setKeepRunning(false);
            Socket connectToClose = new Socket("localhost", 7777);
            BufferedOutputStream out = new BufferedOutputStream(connectToClose.getOutputStream());
            out.write(1);
            serverThread = null;
            serverSwitchLabel.setText("OFF");
        } else {
            logInfo.info("Server has already been stopped");
        }
    }
    private void startServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startServerButtonActionPerformed
        if (serverThread == null) {
            RailwayServer.setKeepRunning(true);
            try {
                serverThread = new RailwayServer();
                serverThread.start();
                serverSwitchLabel.setText("ON");
            } catch (Exception ex) {
                logError.error(ex);
            }
        } else {
            logInfo.info("Server has already been started");
        }
    }//GEN-LAST:event_startServerButtonActionPerformed

    private void quitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quitButtonActionPerformed
        try {
            stopServer();
        } catch (IOException ex) {
            logError.error(ex);
        }
        System.exit(0);
    }//GEN-LAST:event_quitButtonActionPerformed

    private void stopServerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopServerButtonActionPerformed
        try {
            stopServer();
        } catch (IOException ex) {
            logError.error(ex);
        }
    }//GEN-LAST:event_stopServerButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton quitButton;
    private javax.swing.JLabel serverLabel;
    private javax.swing.JLabel serverSwitchLabel;
    private javax.swing.JButton startServerButton;
    private javax.swing.JButton stopServerButton;
    // End of variables declaration//GEN-END:variables
}
