package org.application.util;

import javax.swing.*;
import java.sql.*;

public class Database {

    private static String path = "application.db";

    private static Connection connection = null;

    // create table
    public static void init(){
        try {
            setConnection();
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.

            statement.executeUpdate("drop table if exists records");
            statement.executeUpdate("create table records (record_id STRING, plate_number STRING, start_timestamp STRING, end_timestamp STRING, record_status STRING, spot_id STRING, vehicle_type STRING,  amount DOUBLE)");
            ParkingLot.init();

        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void setConnection(){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection("jdbc:sqlite:" + path);
        }
        catch (SQLException ex){

        }
        Database.connection = conn;
    }

    public static Connection getConnection(){
        if (Database.connection == null){
            Database.setConnection();
        }
        return connection;
    }

}
