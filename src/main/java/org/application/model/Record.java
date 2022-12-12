package org.application.model;

import org.application.util.Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Record {

    private String recordId;

    private String plateNumber;

    private String startTimeStamp;

    private String endTimeStamp;

    private String recordStatus;

    private String spotId;

    private String vehicleType;

    private Double amount;

    private static Connection connection = Database.getConnection();

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public String getStartTimeStamp() {
        return startTimeStamp;
    }

    public void setStartTimeStamp(String startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    public String getEndTimeStamp() {
        return endTimeStamp;
    }

    public void setEndTimeStamp(String endTimeStamp) {
        this.endTimeStamp = endTimeStamp;
    }

    public String getRecordStatus() {
        return recordStatus;
    }

    public void setRecordStatus(String recordStatus) {
        this.recordStatus = recordStatus;
    }

    public String getSpotId() {
        return spotId;
    }

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Record(){
        recordId = null;
        plateNumber = null;
        startTimeStamp = null;
        endTimeStamp = null;
        recordStatus = null;
        spotId = null;
        vehicleType = null;
        amount = null;
    }


    public static void insertRecord(Record record){
        try{
            PreparedStatement ps = connection.prepareStatement("INSERT INTO records values(?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, record.getRecordId());
            ps.setString(2, record.getPlateNumber());
            ps.setString(3, record.getStartTimeStamp());
            ps.setString(4, record.getEndTimeStamp());
            ps.setString(5, record.getRecordStatus());
            ps.setString(6, record.getSpotId());
            ps.setString(7, record.getVehicleType());
            ps.setDouble(8, record.getAmount());
            System.out.println(ps);
            ps.execute();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static List<Record> foundActiveRecordsByPlateNumber(String plateNumber){
        List<Record> res = new ArrayList<>();
        try{
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM records WHERE record_status = 'ACTIVE' AND plate_number = ?");
            ps.setString(1, plateNumber);
            System.out.println(ps);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Record record = new Record();
                record.setRecordId(rs.getString("record_id"));
                record.setPlateNumber(rs.getString("plate_number"));
                record.setStartTimeStamp(rs.getString("start_timestamp"));
                record.setEndTimeStamp(rs.getString("end_timestamp"));
                record.setRecordStatus(rs.getString("record_status"));
                record.setSpotId(rs.getString("spot_id"));
                record.setVehicleType(rs.getString("vehicle_type"));
                record.setAmount(rs.getDouble("amount"));
                System.out.println(record);
                res.add(record);
            }
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return res;
    }

    public static void updateRecord(Record record){
        try{
            PreparedStatement ps = connection.prepareStatement("update records SET end_timestamp = ?, record_status = ?, amount = ? WHERE record_id = ?");
            ps.setString(1, record.getEndTimeStamp());
            ps.setString(2, record.getRecordStatus());
            ps.setDouble(3, record.getAmount());
            ps.setString(4, record.getRecordId());
            System.out.println(ps);
            ps.execute();
        }catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public String toString(){
        return "record_id = " + recordId + ", plate_number = " + plateNumber + ", start_timestamp = " + startTimeStamp + ", end_timestamp = " + endTimeStamp + ", record_status = " + recordStatus + ", spot_id = " + spotId + ", vehicle_type = " + vehicleType + ", amount = " + amount;
    }







}
