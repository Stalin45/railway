package com.tschool.railwayapp.client;

import com.tschool.railwayapp.client.ConnectionHandlerClient;
import com.tschool.railwayapp.client.gui.FrameClientTerminal;
import com.tschool.railwayapp.commons.commands.Command;
import com.tschool.railwayapp.commons.commands.CommandRequest;
import com.tschool.railwayapp.commons.commands.CommandResponse;
import com.tschool.railwayapp.commons.commands.ContentKey;
import com.tschool.railwayapp.commons.entities.Specialist;
import com.tschool.railwayapp.commons.exceptions.*;
import com.tschool.railwayapp.commons.entities.SuperUser;
import com.tschool.railwayapp.commons.entities.User;
import java.io.IOException;
import java.net.ConnectException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import com.tschool.railwayapp.commons.logger.LogUtils;
import org.apache.log4j.Logger;

public class FrameAuthentication extends javax.swing.JFrame {

    ConnectionHandlerClient handler;

    private Logger logInfo;
    private Logger logError;

    public FrameAuthentication() {
        logError = LogUtils.getErrorLogger();
        logInfo  = LogUtils.getInfoLogger();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        signInButton = new javax.swing.JButton();
        authLabel = new javax.swing.JLabel();
        userPanel = new javax.swing.JPanel();
        userLabel = new javax.swing.JLabel();
        passLabel = new javax.swing.JLabel();
        userTextField = new javax.swing.JTextField();
        passTextField = new javax.swing.JPasswordField();
        signUpButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        signInButton.setBackground(new java.awt.Color(204, 255, 204));
        signInButton.setText("Sign in");
        signInButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signInButtonActionPerformed(evt);
            }
        });

        authLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        authLabel.setText("Authentication:");
        authLabel.setToolTipText("");
        authLabel.setName(""); // NOI18N

        userPanel.setBackground(new java.awt.Color(255, 255, 255));
        userPanel.setToolTipText("");

        userLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userLabel.setText("Username:");
        userLabel.setToolTipText("");
        userLabel.setName(""); // NOI18N

        passLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passLabel.setText("Password:");
        passLabel.setToolTipText("");
        passLabel.setName(""); // NOI18N

        userTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        javax.swing.GroupLayout userPanelLayout = new javax.swing.GroupLayout(userPanel);
        userPanel.setLayout(userPanelLayout);
        userPanelLayout.setHorizontalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passLabel)
                    .addComponent(userLabel))
                .addGap(46, 46, 46)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                    .addComponent(passTextField))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        userPanelLayout.setVerticalGroup(
            userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(userPanelLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(userLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(userPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57))
        );

        signUpButton.setBackground(new java.awt.Color(204, 255, 204));
        signUpButton.setText("Sign up");
        signUpButton.setToolTipText("");
        signUpButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 3, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(authLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(authLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addComponent(userPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signInButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(signUpButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public static void main(String args[]) {
        new FrameAuthentication().setVisible(true);
    }
    
    private void signInButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signInButtonActionPerformed
        String username = userTextField.getText();
        String password = passTextField.getText();

        SuperUser specialist = new Specialist();
        specialist.setLogin(username);
        specialist.setPassword(password);
        
        SuperUser user = new User();
        user.setLogin(username);
        user.setPassword(password);
        try {
            handler = ConnectionHandlerClient.getConnectionInstance();
            CommandRequest request = new CommandRequest();
            CommandResponse response;

            request.setCommand(Command.IS_SIGNED_UP);
            request.putContent(ContentKey.USER, user);
            response = handler.sendCommand(request);
            Exception ex = response.getException();
            if (ex != null) {
                throw ex;
            }
            if (response.getResultCode() == 1) {
                logInfo.info("Successfuly authenticated as User");
                this.dispose();
                FrameClientTerminal.setUser(user);
                new FrameClientTerminal().setVisible(true);
            } else if (response.getResultCode() == 2) {
                logInfo.info("Successfuly authenticated as Specialist");
                this.dispose();
                FrameClientTerminal.setUser(specialist);
                new FrameClientTerminal().setVisible(true);
            } else {
                //Poppup menu
                logInfo.info("Incorrect password");
            }
        } catch (IOException ex) {
            //Poppup menu
            logError.error("Can't connect to the server");
        } catch (Exception ex) {
            logError.error(ex);
        }
    }//GEN-LAST:event_signInButtonActionPerformed

    private void signUpButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpButtonActionPerformed
        String username = userTextField.getText();
        String password = passTextField.getText();

        User user = new User();
        user.setLogin(username);
        user.setPassword(password);
        try {
            handler = ConnectionHandlerClient.getConnectionInstance();
            CommandRequest request = new CommandRequest();
            CommandResponse response = new CommandResponse();

            request.setCommand(Command.CREATE_USER);
            request.putContent(ContentKey.USER, user);
            response = handler.sendCommand(request);
            Exception ex = response.getException();
            if (ex != null)
                throw ex;
            if (response.getResultCode() == 1) {
                //Poppup
                this.dispose();
                FrameClientTerminal.setUser(user);
                new FrameClientTerminal().setVisible(true);
            }
        } catch (IOException ex) {
            //Poppup menu
            logError.error("Can't connect to the server");
        } catch (Exception ex) {
            logError.error(ex);
        }
    }//GEN-LAST:event_signUpButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authLabel;
    private javax.swing.JLabel passLabel;
    private javax.swing.JPasswordField passTextField;
    private javax.swing.JButton signInButton;
    private javax.swing.JButton signUpButton;
    private javax.swing.JLabel userLabel;
    private javax.swing.JPanel userPanel;
    private javax.swing.JTextField userTextField;
    // End of variables declaration//GEN-END:variables
}
