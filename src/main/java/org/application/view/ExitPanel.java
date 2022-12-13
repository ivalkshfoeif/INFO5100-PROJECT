package org.application.view;

import org.application.model.Record;
import org.application.util.UserSession;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitPanel extends JFrame {
    private JButton checkOutAndGoButton;
    private JPanel MainPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;

    public ExitPanel(){
        setContentPane(MainPanel);
        setTitle("Welcome");
        setSize(900, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

        Record r = UserSession.getRecord();
        textField1.setText(r.getPlateNumber());
        textField2.setText(r.getStartTimeStamp());
        textField3.setText(r.getEndTimeStamp());
        textField4.setText(r.getAmount() + "$");
        textField5.setText(r.getVehicleType());
        checkOutAndGoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                HomePanel homePanel = new HomePanel();
            }
        });
    }

    public static void main(String[] args) {
        ExitPanel exitPanel = new ExitPanel();
    }
}
