package org.application.util;

import org.application.enums.VehicleType;

import javax.swing.*;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Vehicle {

    private static Map<VehicleType, Double> vehicleRates;

    private static void init(){
        vehicleRates = new HashMap<>();
        vehicleRates.put(VehicleType.VAN, 10.0);
        vehicleRates.put(VehicleType.CAR, 5.0);
        vehicleRates.put(VehicleType.MOTORBIKE, 1.0);
    }

    public static double getRateByVehicleType(VehicleType vehicleType){
        if (vehicleRates == null) init();
        return vehicleRates.get(vehicleType);
    }
}
