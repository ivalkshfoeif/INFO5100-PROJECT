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
    }

    public static double getRateByVehicleType(VehicleType vehicleType){
        if (vehicleType == null) init();
        return vehicleRates.get(vehicleType);
    }
}
