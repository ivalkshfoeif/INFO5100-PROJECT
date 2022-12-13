package org.application.view;

import org.application.enums.SpotType;
import org.application.enums.VehicleType;
import org.application.model.Spot;
import org.application.util.UserSession;
import org.application.util.Vehicle;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.server.RemoteRef;
import java.util.HashMap;
import java.util.Map;

public class HomePanel extends JFrame {
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JComboBox comboBox1;
    private JButton goToTheEntranceButton;
    private JPanel MainPanel;
    private JButton exitTheApplicationButton;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;

    public HomePanel(){
        Map<Integer, String> indexVehicleType = new HashMap<>();
        indexVehicleType.put(0, "MOTORBIKE");
        indexVehicleType.put(1, "CAR");
        indexVehicleType.put(2, "VAN");


        int spotLeft1 = Spot.countFreeSpotBtSpotType(SpotType.SMALL);
        spotLeft1 = spotLeft1 == -1 ? 0 : spotLeft1;
        textField1.setText(spotLeft1 + " Spots Left");


        int spotLeft2 = Spot.countFreeSpotBtSpotType(SpotType.MEDIUM);
        spotLeft2 = spotLeft2 == -1 ? 0 : spotLeft2;
        textField2.setText(spotLeft2 + " Spots Left");


        int spotLeft3 = Spot.countFreeSpotBtSpotType(SpotType.LARGE);
        spotLeft3 = spotLeft3 == -1 ? 0 : spotLeft3;
        textField3.setText(spotLeft3 + " Spots Left");

        String u = "0$ / second";

        textField4.setText(Vehicle.getRateByVehicleType(VehicleType.VAN) + u);
        textField5.setText(Vehicle.getRateByVehicleType(VehicleType.CAR) + u);
        textField6.setText(Vehicle.getRateByVehicleType(VehicleType.MOTORBIKE) + u);



        setContentPane(MainPanel);
        setTitle("Welcome");
        setSize(900, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        goToTheEntranceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserSession.setEnteredVehicleType(indexVehicleType.get(comboBox1.getSelectedIndex()));
                System.out.println(UserSession.getEnteredVehicleType());
                dispose();
                EntrancePanel entrancePanel = new EntrancePanel();
            }
        });
        exitTheApplicationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        HomePanel homePanel = new HomePanel();
    }
}
