package org.application.view;

import org.application.enums.RecordStatus;
import org.application.enums.SpotStatus;
import org.application.enums.VehicleType;
import org.application.model.Record;
import org.application.model.Spot;
import org.application.util.ParkingLot;
import org.application.util.UserSession;
import org.application.util.Vehicle;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TicketPanel extends JFrame {
    private JButton exitTheParkingLotButton;
    private JButton goBackToHomeButton;
    private JTextField textField1;
    private JPanel MainPanel;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JTextField textField7;

    public TicketPanel(){
        setContentPane(MainPanel);
        setTitle("Welcome");
        setSize(900, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        Record r = UserSession.getRecord();
        textField2.setText(r.getSpotId());
        textField3.setText(r.getPlateNumber());
        textField4.setText(r.getStartTimeStamp());
        textField5.setText(r.getVehicleType());
        textField6.setText(r.getSpotId());
        textField7.setText(Vehicle.getRateByVehicleType(ParkingLot.getStringVehicleTypeMap().get(r.getVehicleType())) + "$");

        textField1.setText(UserSession.getSystemMessage());
        goBackToHomeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                HomePanel homePanel = new HomePanel();
            }
        });
        exitTheParkingLotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String start = r.getStartTimeStamp();


                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
                Date startDate = null;
                try {
                    startDate = dateFormat.parse(start);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
                }
                Date date = new Date();
                long endTime = date.getTime();
                Timestamp endTimestamp = new Timestamp(endTime);
                long seconds = (endTime - startDate.getTime()) / 1000;

                Double amount = Vehicle.getRateByVehicleType(ParkingLot.getStringVehicleTypeMap().get(r.getVehicleType())) * seconds;
                r.setAmount(amount);
                r.setEndTimeStamp(endTimestamp.toString());
                r.setRecordStatus(RecordStatus.ARCHIVED.value);

                String spotId = r.getSpotId();

                Spot.updateSpotStatusToSpotStatus(spotId, SpotStatus.FREE);

                Record.updateRecord(r);



                dispose();
                ExitPanel panel = new ExitPanel();
            }
        });
    }

    public static void main(String[] args) {
        TicketPanel ticketPanel = new TicketPanel();
    }
}
