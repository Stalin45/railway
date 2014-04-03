package com.tschool.railwayapp.client.gui;

import com.tschool.railwayapp.client.ConnectionHandlerClient;
import com.tschool.railwayapp.client.FrameAuthentication;
import com.tschool.railwayapp.commons.entities.Specialist;
import com.tschool.railwayapp.commons.entities.SuperUser;
import com.tschool.railwayapp.commons.entities.User;
import com.tschool.railwayapp.commons.logger.LogUtils;
import java.io.IOException;
import org.apache.log4j.Logger;

public class FrameClientTerminal extends javax.swing.JFrame {

    private Logger logInfo;
    private Logger logError;
    private static SuperUser user;
    
    public FrameClientTerminal() {
        logError = LogUtils.getErrorLogger();
        logInfo  = LogUtils.getInfoLogger();
        initComponents();
        initPane();
    }
    
    private void initPane() {
        if (user instanceof Specialist) {
            PanelTrain p_train = new PanelTrain(this);
            PanelStation p_station = new PanelStation(this);
            PanelPath p_path = new PanelPath(this);
            PanelTimetable p_timetable = new PanelTimetable(this);

            terminalPane.addTab(p_train.getName(), p_train);
            terminalPane.addTab(p_station.getName(), p_station);
            terminalPane.addTab(p_path.getName(), p_path);
            terminalPane.addTab(p_timetable.getName(), p_timetable);
        } else {
            PanelFindPaths p_findPaths = new PanelFindPaths(this);
            PanelBuyTicket p_buyTicket = new PanelBuyTicket(this);

            terminalPane.addTab(p_findPaths.getName(), p_findPaths);
            terminalPane.addTab(p_buyTicket.getName(), p_buyTicket);
        }
    }

    public static SuperUser getUser() {
        return user;
    }

    public static void setUser(SuperUser user) {
        FrameClientTerminal.user = user;
    }
    
    public void logout() {
        logInfo.info("Logout");
        try {
            ConnectionHandlerClient.closeSocket();
        } catch (IOException exc) {
            logError.error(exc);
        }
        user = null;
        new FrameAuthentication().setVisible(true);
        this.dispose();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        terminalPane = new javax.swing.JTabbedPane();
        logoutButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setName("terminal"); // NOI18N
        setPreferredSize(new java.awt.Dimension(500, 675));

        terminalPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                terminalPaneStateChanged(evt);
            }
        });

        logoutButton.setBackground(new java.awt.Color(255, 204, 204));
        logoutButton.setText("Logout");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(terminalPane, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(terminalPane, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void terminalPaneStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_terminalPaneStateChanged
        Refreshable selectedPanel = (Refreshable) terminalPane.getSelectedComponent();
        selectedPanel.refreshPanel();
    }//GEN-LAST:event_terminalPaneStateChanged

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        logout();
    }//GEN-LAST:event_logoutButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton logoutButton;
    private javax.swing.JTabbedPane terminalPane;
    // End of variables declaration//GEN-END:variables
}
