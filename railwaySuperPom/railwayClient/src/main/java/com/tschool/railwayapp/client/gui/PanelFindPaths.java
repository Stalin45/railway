package com.tschool.railwayapp.client.gui;

import com.tschool.railwayapp.client.ConnectionHandlerClient;
import com.tschool.railwayapp.commons.commands.*;
import com.tschool.railwayapp.commons.entities.*;
import com.tschool.railwayapp.commons.logger.LogUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;

public class PanelFindPaths extends javax.swing.JPanel implements Refreshable {

    private Logger logInfo;
    private Logger logError;
    
    private FrameClientTerminal outerFrame;
    private ConnectionHandlerClient handler;
    private FrameDestinations fd;
    private String stationFrom;
    private String stationTo;
    private Path path;
    private List<Path> pathList;
    private List<Destination> destinationList = new ArrayList<Destination>();
    
    public PanelFindPaths(FrameClientTerminal outerFrame) {
        logError = LogUtils.getErrorLogger();
        logInfo  = LogUtils.getInfoLogger();
        this.outerFrame = outerFrame;
        initComponents();
    }

    @Override
    public void refreshPanel() {
        defaultVariables();
    }
    
    private void defaultVariables() {
        stationFromTextField.setText("");
        stationToTextField.setText("");
        pathComboBox.removeAllItems();
        panelFitPaths.setVisible(false);
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
        stationFromTextField = new javax.swing.JTextField();
        stationFromLabel = new javax.swing.JLabel();
        stationToTextField = new javax.swing.JTextField();
        stationToLabel = new javax.swing.JLabel();
        viewResultsButton = new javax.swing.JButton();
        panelFitPaths = new javax.swing.JPanel();
        pathLabel = new javax.swing.JLabel();
        pathComboBox = new javax.swing.JComboBox();
        viewDestButton = new javax.swing.JButton();
        findPathLabel = new javax.swing.JLabel();

        setName("Find path"); // NOI18N
        setPreferredSize(new java.awt.Dimension(491, 497));

        p_ExistedTrain1.setBackground(new java.awt.Color(255, 255, 255));

        stationFromTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        stationFromLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stationFromLabel.setText("From:");
        stationFromLabel.setToolTipText("");
        stationFromLabel.setName(""); // NOI18N

        stationToTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        stationToLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stationToLabel.setText("To:");
        stationToLabel.setToolTipText("");
        stationToLabel.setName(""); // NOI18N

        viewResultsButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        viewResultsButton.setText("view results");
        viewResultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResultsButtonActionPerformed(evt);
            }
        });

        panelFitPaths.setBackground(new java.awt.Color(255, 255, 204));

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

        viewDestButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        viewDestButton.setText("view destinations");
        viewDestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDestButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFitPathsLayout = new javax.swing.GroupLayout(panelFitPaths);
        panelFitPaths.setLayout(panelFitPathsLayout);
        panelFitPathsLayout.setHorizontalGroup(
            panelFitPathsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFitPathsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pathLabel)
                .addGap(18, 18, 18)
                .addComponent(pathComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(viewDestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        panelFitPathsLayout.setVerticalGroup(
            panelFitPathsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFitPathsLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(panelFitPathsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pathComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewDestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(35, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout p_ExistedTrain1Layout = new javax.swing.GroupLayout(p_ExistedTrain1);
        p_ExistedTrain1.setLayout(p_ExistedTrain1Layout);
        p_ExistedTrain1Layout.setHorizontalGroup(
            p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(panelFitPaths, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                        .addComponent(stationFromLabel)
                        .addGap(42, 42, 42)
                        .addComponent(stationFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(stationToLabel)
                        .addGap(18, 18, 18)
                        .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(viewResultsButton, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                            .addComponent(stationToTextField))))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        p_ExistedTrain1Layout.setVerticalGroup(
            p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stationFromLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stationFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stationToLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stationToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(viewResultsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(panelFitPaths, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(78, Short.MAX_VALUE))
        );

        findPathLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        findPathLabel.setText("Find path:");
        findPathLabel.setToolTipText("");
        findPathLabel.setName(""); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(p_ExistedTrain1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(findPathLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(findPathLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(p_ExistedTrain1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(15, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void pathComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pathComboBoxActionPerformed
        choosePath();
    }//GEN-LAST:event_pathComboBoxActionPerformed

    private void viewDestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDestButtonActionPerformed
        if (fd != null)
        fd.dispose();
        fd = new FrameDestinations(path);
        fd.setVisible(true);
    }//GEN-LAST:event_viewDestButtonActionPerformed

    private void viewResultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewResultsButtonActionPerformed
        if ((stationFrom = stationFromTextField.getText()) == null)
            return;
        if ((stationTo = stationToTextField.getText()) == null)
            return;
        refreshPanel();
        List<String> stationsFromTo = new ArrayList<String>();
        stationsFromTo.add(stationFrom);
        stationsFromTo.add(stationTo);
        
        panelFitPaths.setVisible(true);
        
        try {
            handler = ConnectionHandlerClient.getConnectionInstance();
            CommandRequest request = new CommandRequest();
            request.putContent(ContentKey.STRING_LIST,stationsFromTo);
            request.setCommand(Command.GET_PATHS_FIT_STATIONS);
        
            CommandResponse response = handler.sendCommand(request);
            Exception ex = response.getException();
            if (ex != null)
                throw ex;
            
            pathList = (List<Path>) response.getContent().get(ContentKey.PATH_LIST);
            
            for (Path path : pathList) {
                pathComboBox.addItem(path);
            }
            logInfo.info("Found " + pathList.size() + " result(s)");
        } catch (IOException ex) {
            //Poppup menu
            logError.error("Can't connect to the server");
            outerFrame.logout();
        } catch (Exception ex) {
            logError.error(ex);
        }
    }//GEN-LAST:event_viewResultsButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel findPathLabel;
    private javax.swing.JPanel p_ExistedTrain1;
    private javax.swing.JPanel panelFitPaths;
    private javax.swing.JComboBox pathComboBox;
    private javax.swing.JLabel pathLabel;
    private javax.swing.JLabel stationFromLabel;
    private javax.swing.JTextField stationFromTextField;
    private javax.swing.JLabel stationToLabel;
    private javax.swing.JTextField stationToTextField;
    private javax.swing.JButton viewDestButton;
    private javax.swing.JButton viewResultsButton;
    // End of variables declaration//GEN-END:variables
}
