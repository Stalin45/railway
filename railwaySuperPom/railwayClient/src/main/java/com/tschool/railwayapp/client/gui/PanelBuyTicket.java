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
import java.util.Vector;
import org.apache.log4j.Logger;

public class PanelBuyTicket extends javax.swing.JPanel implements Refreshable {

    private Logger logInfo;
    private Logger logError;
    
    private FrameClientTerminal outerFrame;
    private ConnectionHandlerClient handler;
    private FrameDestinations fd;
    private List<TimeTable> timetableList = new ArrayList<TimeTable>();
    private String stationFrom;
    private String stationTo;
    private Date date;
    private SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
    private NotEditTableModel tm;
    
    public PanelBuyTicket(FrameClientTerminal outerFrame) {
        logError = LogUtils.getErrorLogger();
        logInfo  = LogUtils.getInfoLogger();
        this.outerFrame = outerFrame;
        initComponents();
        
        String[] columnNames = {"Train", "Path", "Date", "Cost", "Free seats"};
        tm = new NotEditTableModel(columnNames, 0);
        timetableTable.setModel(tm);
    }

    @Override
    public void refreshPanel() {
        defaultVariables();
    }
    
    private void defaultVariables() {
        stationFromTextField.setText("");
        stationToTextField.setText("");
        panelClientInfo.setVisible(false);
        nameTextField.setText("");
        snameTextField.setText("");
        passportTextField.setText("");
        dateTextField.setText("");
        while (tm.getRowCount() != 0)
            tm.removeRow(0);
        variantsComboBox.removeAllItems();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        l_Train1 = new javax.swing.JLabel();
        p_ExistedTrain1 = new javax.swing.JPanel();
        stationToLabel = new javax.swing.JLabel();
        stationToTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        timetableTable = new javax.swing.JTable();
        stationFromLabel = new javax.swing.JLabel();
        dateTextField = new javax.swing.JTextField();
        dateLabel = new javax.swing.JLabel();
        stationFromTextField = new javax.swing.JTextField();
        viewResultsButton = new javax.swing.JButton();
        panelClientInfo = new javax.swing.JPanel();
        nameLabel = new javax.swing.JLabel();
        snameLabel = new javax.swing.JLabel();
        passportLabel = new javax.swing.JLabel();
        snameTextField = new javax.swing.JTextField();
        nameTextField = new javax.swing.JTextField();
        passportTextField = new javax.swing.JTextField();
        addTickerButton = new javax.swing.JButton();
        variantsComboBox = new javax.swing.JComboBox();
        viewDestButton = new javax.swing.JButton();
        availableLinesLabel = new javax.swing.JLabel();

        setName("Buy ticket"); // NOI18N

        l_Train1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        l_Train1.setText("Buy a ticket:");
        l_Train1.setToolTipText("");
        l_Train1.setName(""); // NOI18N

        p_ExistedTrain1.setBackground(new java.awt.Color(255, 255, 255));

        stationToLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stationToLabel.setText("To:");
        stationToLabel.setToolTipText("");
        stationToLabel.setName(""); // NOI18N

        stationToTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        timetableTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Train", "Path", "Date", "Cost", "Free Seats"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        timetableTable.setEnabled(false);
        jScrollPane1.setViewportView(timetableTable);

        stationFromLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        stationFromLabel.setText("From:");
        stationFromLabel.setToolTipText("");
        stationFromLabel.setName(""); // NOI18N

        dateTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        dateLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateLabel.setText("Date:");
        dateLabel.setToolTipText("");
        dateLabel.setName(""); // NOI18N

        stationFromTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        viewResultsButton.setBackground(new java.awt.Color(255, 255, 255));
        viewResultsButton.setText("See results");
        viewResultsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewResultsButtonActionPerformed(evt);
            }
        });

        panelClientInfo.setBackground(new java.awt.Color(255, 255, 204));
        panelClientInfo.setEnabled(false);

        nameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        nameLabel.setText("Name:");
        nameLabel.setToolTipText("");
        nameLabel.setName(""); // NOI18N

        snameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        snameLabel.setText("Second name:");
        snameLabel.setToolTipText("");
        snameLabel.setName(""); // NOI18N

        passportLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        passportLabel.setText("Passport:");
        passportLabel.setToolTipText("");
        passportLabel.setName(""); // NOI18N

        snameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        nameTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        passportTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        addTickerButton.setBackground(new java.awt.Color(204, 255, 204));
        addTickerButton.setText("Buy a ticket");
        addTickerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addTickerButtonActionPerformed(evt);
            }
        });

        variantsComboBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        viewDestButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        viewDestButton.setText("view destinations");
        viewDestButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewDestButtonActionPerformed(evt);
            }
        });

        availableLinesLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        availableLinesLabel.setText("Available variants:");
        availableLinesLabel.setToolTipText("");
        availableLinesLabel.setName(""); // NOI18N

        javax.swing.GroupLayout panelClientInfoLayout = new javax.swing.GroupLayout(panelClientInfo);
        panelClientInfo.setLayout(panelClientInfoLayout);
        panelClientInfoLayout.setHorizontalGroup(
            panelClientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelClientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClientInfoLayout.createSequentialGroup()
                        .addGroup(panelClientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(snameLabel)
                            .addComponent(nameLabel)
                            .addComponent(passportLabel))
                        .addGap(37, 37, 37)
                        .addGroup(panelClientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(snameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passportTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(panelClientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addTickerButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(viewDestButton, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addContainerGap())
                    .addGroup(panelClientInfoLayout.createSequentialGroup()
                        .addComponent(availableLinesLabel)
                        .addGap(18, 18, 18)
                        .addComponent(variantsComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(14, 14, 14))))
        );
        panelClientInfoLayout.setVerticalGroup(
            panelClientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelClientInfoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(panelClientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(availableLinesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(variantsComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelClientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelClientInfoLayout.createSequentialGroup()
                        .addGroup(panelClientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(nameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelClientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(snameLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(snameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(viewDestButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelClientInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passportLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passportTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(addTickerButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout p_ExistedTrain1Layout = new javax.swing.GroupLayout(p_ExistedTrain1);
        p_ExistedTrain1.setLayout(p_ExistedTrain1Layout);
        p_ExistedTrain1Layout.setHorizontalGroup(
            p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 533, Short.MAX_VALUE))
                    .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                                .addComponent(stationFromLabel)
                                .addGap(18, 18, 18)
                                .addComponent(stationFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                                .addComponent(dateLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57)
                        .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                                .addComponent(stationToLabel)
                                .addGap(18, 18, 18)
                                .addComponent(stationToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(viewResultsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelClientInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        p_ExistedTrain1Layout.setVerticalGroup(
            p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p_ExistedTrain1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(stationToLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stationToTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stationFromLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(stationFromTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(p_ExistedTrain1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dateTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewResultsButton, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelClientInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(p_ExistedTrain1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(l_Train1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(l_Train1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(p_ExistedTrain1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void viewResultsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewResultsButtonActionPerformed
        if ((stationFrom = stationFromTextField.getText()) == null) {
            logInfo.warn("Please, fill the \"Stattion from\" field");
            return;
        }
        if ((stationTo = stationToTextField.getText()) == null) {
            logInfo.warn("Please, fill the \"Stattion to\" field");
            return;
        }
        try {
            if ((date = sdf.parse(dateTextField.getText())) == null) {
                logInfo.warn("Please, fill the \"Date\" field");
                return;
            }
        } catch (ParseException ex) {
            logInfo.warn(ex);
        }

        refreshPanel();
        panelClientInfo.setVisible(true);

        List<String> stationsFromTo = new ArrayList<String>();
        stationsFromTo.add(stationFrom);
        stationsFromTo.add(stationTo);

        try {
            handler = ConnectionHandlerClient.getConnectionInstance();
            CommandRequest request = new CommandRequest();
            request.putContent(ContentKey.STRING_LIST,stationsFromTo);
            request.putContent(ContentKey.DATE, date);
            request.setCommand(Command.GET_TIMETABLES_FIT_PATHS_DATE);
            
            CommandResponse response = handler.sendCommand(request);
            Exception ex = response.getException();
            if (ex != null)
                throw ex;
            timetableList = (List<TimeTable>) response.getContent().get(ContentKey.TIMETABLE_LIST);
            
            for (TimeTable timetable : timetableList) {
                Train train = timetable.getTrain();
                Path path = timetable.getPath();
                Integer freeSeats = timetable.getFreeSeats();
                
                Vector rowData = new Vector();
                rowData.add(train);
                rowData.add(path);
                rowData.add(timetable.getDate());
                rowData.add(null);
                rowData.add(freeSeats);
                
                tm.addRow(rowData);
                
                if (freeSeats > 0) {
                    variantsComboBox.addItem(timetable);
                }
            }
            logInfo.info("Found " + timetableList.size() + " result(s). Available to choose: " + variantsComboBox.getItemCount());
        } catch (IOException ex) {
            //Poppup menu
            logError.error("Can't connect to the server");
            outerFrame.logout();
            try {
                ConnectionHandlerClient.closeSocket();
            } catch (IOException exc) {
                logError.error(exc);
            }
        } catch (Exception ex) {
            logError.error(ex);
        }
    }//GEN-LAST:event_viewResultsButtonActionPerformed

    private void addTickerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addTickerButtonActionPerformed
        try {
            if (variantsComboBox.getItemCount() == 0)
                return;
            
            String name = nameTextField.getText();
            String sname = snameTextField.getText();
            Long passport = Long.valueOf(passportTextField.getText());
            
            Passenger passenger = new Passenger();
            passenger.setName(name);
            passenger.setSecondName(sname);
            passenger.setPassport(passport);
            
            Ticket ticket = new Ticket();
            // ticket.setUser(FrameClientTerminal.getUser());
            ticket.setPassenger(passenger);
            ticket.setTimetable((TimeTable) variantsComboBox.getSelectedItem());
            ticket.setTotalCost(null);            
            
            CommandRequest request = new CommandRequest();
            request.setCommand(Command.CREATE_TICKET);
            request.putContent(ContentKey.PASSENGER, passenger);
            request.putContent(ContentKey.TICKET, ticket);
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
            try {
                ConnectionHandlerClient.closeSocket();
            } catch (IOException exc) {
                logError.error(exc);
            }
        } catch (Exception ex) {
            logError.error(ex);
        }
    }//GEN-LAST:event_addTickerButtonActionPerformed

    private void viewDestButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewDestButtonActionPerformed
        if (fd != null)
            fd.dispose();
        TimeTable timetable = (TimeTable) variantsComboBox.getSelectedItem();
        fd = new FrameDestinations(timetable.getPath());
        fd.setVisible(true);
    }//GEN-LAST:event_viewDestButtonActionPerformed

    //                Float totalCost = 0F;
//                Float costMultip = train.getTrainType().getCostMultiplier();
                
//                Boolean isStartStation = false;
                
//                List<Destination> destinationList = path.getDestination();
//                for (Destination destination : destinationList) {
//                    if (isStartStation) {
//                        totalCost += destination.
//                    }
//                        if (stationFrom.equals(destination.getStation().getName())) {
//                            isStartStation = true;
//                            continue;
//                        }
//                    if (isStartStation && stationTo.equals(destination.getStation().getName())) {
//                        break;
//                    }
//                }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addTickerButton;
    private javax.swing.JLabel availableLinesLabel;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JTextField dateTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel l_Train1;
    private javax.swing.JLabel nameLabel;
    private javax.swing.JTextField nameTextField;
    private javax.swing.JPanel p_ExistedTrain1;
    private javax.swing.JPanel panelClientInfo;
    private javax.swing.JLabel passportLabel;
    private javax.swing.JTextField passportTextField;
    private javax.swing.JLabel snameLabel;
    private javax.swing.JTextField snameTextField;
    private javax.swing.JLabel stationFromLabel;
    private javax.swing.JTextField stationFromTextField;
    private javax.swing.JLabel stationToLabel;
    private javax.swing.JTextField stationToTextField;
    private javax.swing.JTable timetableTable;
    private javax.swing.JComboBox variantsComboBox;
    private javax.swing.JButton viewDestButton;
    private javax.swing.JButton viewResultsButton;
    // End of variables declaration//GEN-END:variables
}
