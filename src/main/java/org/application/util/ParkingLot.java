package org.application.util;

import org.application.enums.SpotType;
import org.application.enums.SpotStatus;
import org.application.enums.VehicleType;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ParkingLot {

    private static Map<SpotType, Integer> capacities;

    private static Map<VehicleType, SpotType> vehicleTypeSpotTypeMap;

    public static void init(){

        capacities = new HashMap<>();

        capacities.put(SpotType.SMALL, 10);
        capacities.put(SpotType.MEDIUM, 5);
        capacities.put(SpotType.LARGE, 1);

        try{
            Connection connection = Database.getConnection();
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);

            statement.executeUpdate("drop table if exists spots");
            statement.executeUpdate("create table spots (spot_id STRING, spot_type STRING, spot_status STRING)");

            // small
            for (int i = 0; i < capacities.get(SpotType.SMALL); i++){
                String spot_id = UUID.randomUUID().toString();
                String sqlQuery = "insert into spots values('" +
                        spot_id + "','" +
                        SpotType.SMALL.value + "','" +
                        SpotStatus.FREE.value + "')";
                statement.executeUpdate(sqlQuery);
            }

            for (int i = 0; i < capacities.get(SpotType.MEDIUM); i++){
                String spot_id = UUID.randomUUID().toString();
                String sqlQuery = "insert into spots values('" +
                        spot_id + "','" +
                        SpotType.MEDIUM.value + "','" +
                        SpotStatus.FREE.value + "')";
                statement.executeUpdate(sqlQuery);
            }

            for (int i = 0; i < capacities.get(SpotType.LARGE); i++){
                String spot_id = UUID.randomUUID().toString();
                String sqlQuery = "insert into spots values('" +
                        spot_id + "','" +
                        SpotType.LARGE.value + "','" +
                        SpotStatus.FREE.value + "')";
                statement.executeUpdate(sqlQuery);
            }

            ResultSet rs = statement.executeQuery("select * from spots");
            while(rs.next())
            {
                // read the result set
                System.out.println("spot_id = " + rs.getString("spot_id"));
                System.out.println("spot_type = " + rs.getString("spot_type"));
            }

        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
