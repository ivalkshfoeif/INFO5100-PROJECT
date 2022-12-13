package org.application.model;

import org.application.enums.SpotStatus;
import org.application.enums.SpotType;
import org.application.util.Database;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Spot {

    private String spotId;

    private String spotType;

    public void setSpotId(String spotId) {
        this.spotId = spotId;
    }

    public void setSpotType(String spotType) {
        this.spotType = spotType;
    }

    public void setSpotStatus(String spotStatus) {
        this.spotStatus = spotStatus;
    }

    private String spotStatus;

    public String getSpotId() {
        return spotId;
    }

    public String getSpotType() {
        return spotType;
    }

    public String getSpotStatus() {
        return spotStatus;
    }

    private static Connection connection = Database.getConnection();

    public static Spot findFreeSpotByType(SpotType spotType){
        Spot spot = new Spot();
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT * FROM spots WHERE spot_type = ? AND spot_status = 'FREE' limit 1");
            ps.setString(1, spotType.value);
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                spot.setSpotId(rs.getString("spot_id"));
                spot.setSpotType(rs.getString("spot_type"));
                spot.setSpotStatus(rs.getString("spot_status"));
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println(spot.toString());
        return spot;
    }

    public static void updateSpotStatusToSpotStatus(String spotId, SpotStatus spotStatus){
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE spots SET spot_status = ? WHERE spot_id = ?");
            ps.setString(1, spotStatus.value);
            ps.setString(2, spotId);
            ps.executeUpdate();
            System.out.println(ps.toString());
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static int countFreeSpotBtSpotType(SpotType spotType){
        int count = -1;
        try {
            PreparedStatement ps = connection.prepareStatement("SELECT spot_type, count(*) AS cnt FROM spots WHERE spot_status = 'FREE' GROUP BY spot_type");
            System.out.println(ps.toString());
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                if (rs.getString("spot_type").equals(spotType.value)) count = rs.getInt("cnt");
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        System.out.println(spotType.value + " = " + count);
        return count;
    }




    public Spot(String spotId, String spotType, String spotStatus){
        this.spotId = spotId;
        this.spotType = spotType;
        this.spotStatus = spotStatus;
    }

    public Spot(){};

    public String toString(){
        return "spotId = " + spotId + ", spotType = " + spotType + ", spotStatus = " + spotStatus;
    }
}
