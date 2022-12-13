package org.application.view;

import org.application.enums.RecordStatus;
import org.application.enums.SpotStatus;
import org.application.enums.SpotType;
import org.application.enums.VehicleType;
import org.application.model.Record;
import org.application.model.Spot;
import org.application.util.ParkingLot;
import org.application.util.UserSession;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.RemoteRef;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class EntrancePanel extends JFrame {
    private JButton enterTheParkingLotButton;
    private JButton goBackToTheButton;
    private JTextField textField1;
    private JPanel MainPanel;

    public EntrancePanel(){
        setContentPane(MainPanel);
        setTitle("Welcome");
        setSize(900, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        // go to the home page
        goBackToTheButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                HomePanel homePanel = new HomePanel();
            }
        });
        enterTheParkingLotButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pn = textField1.getText();
                UserSession.setPlateNumber(pn);
                System.out.println(UserSession.getPlateNumber());

                List<Record> list = Record.foundActiveRecordsByPlateNumber(pn);
                if (list.size() == 0){
                    // no active record
                    VehicleType vt = ParkingLot.getStringVehicleTypeMap().get(UserSession.getEnteredVehicleType());
                    SpotType sp = ParkingLot.getVehicleTypeSpotTypeMap().get(vt);
                    int leftSpot = Spot.countFreeSpotBtSpotType(sp);
                    if (leftSpot > 0){
                        // spot available
                        Spot spot = Spot.findFreeSpotByType(sp);
                        Record r = generateNewRecord(pn, vt, spot.getSpotId());

                        UserSession.setRecord(r);
                        System.out.println(UserSession.getRecord());
                        UserSession.setSystemMessage("Welcome to the parking lot, here is your new ticket");
                        System.out.println(UserSession.getSystemMessage());

                        Spot.updateSpotStatusToSpotStatus(spot.getSpotId(), SpotStatus.OCCUPIED);
                        Record.insertRecord(r);

                        dispose();
                        TicketPanel ticketPanel = new TicketPanel();
                    }else {
                        // spot not available
                        JOptionPane.showMessageDialog(null, "There are no enough spot for the type: " + vt.value, "Invalid", JOptionPane.INFORMATION_MESSAGE);
                    }

                }else {
                    Record r = list.get(0);
                    if (!r.getVehicleType().equals(UserSession.getEnteredVehicleType())){
                        // wrong type
                        JOptionPane.showMessageDialog(null, "There are one active record with the plate number, but with different vehicle type", "Invalid", JOptionPane.INFORMATION_MESSAGE);
                    }else {
                        // correct type

                        UserSession.setSystemMessage("Welcome back, we find a active parking record for you, please check your current status");
                        System.out.println(UserSession.getSystemMessage());
                        UserSession.setRecord(r);
                        System.out.println(UserSession.getRecord());

                        dispose();
                        TicketPanel ticketPanel = new TicketPanel();
                    }
                }


            }
        });
    }


    public static void main(String[] args) {
        EntrancePanel entrancePanel = new EntrancePanel();

    }

    private Record generateNewRecord(String plateNumber, VehicleType vt, String spotId){
        Record r = new Record();
        Date date = new Date();
        Timestamp timestamp = new Timestamp(date.getTime());
        r.setPlateNumber(plateNumber);
        r.setSpotId(UUID.randomUUID().toString());
        r.setVehicleType(vt.value);
        r.setSpotId(spotId);
        r.setRecordStatus(RecordStatus.ACTIVE.value);
        r.setStartTimeStamp(timestamp.toString());
        r.setAmount(0.0);
        return r;
    }

}
