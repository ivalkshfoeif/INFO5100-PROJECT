package org.application.util;

import org.application.enums.ParkingSpotType;

import javax.swing.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;

public class ParkingLot {

    private static Map<ParkingSpotType, Integer> capacities;

    private static void init(){
        try{
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            statement.executeUpdate("drop table if exists spots");

        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
