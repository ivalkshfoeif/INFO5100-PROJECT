package org.application.util;

import org.application.model.Record;

public class UserSession {

    private static String plateNumber = "N/A";

    private static String enteredVehicleType = "N/A";

    private static Record record = null;

    public static String getSystemMessage() {
        return systemMessage;
    }

    public static void setSystemMessage(String systemMessage) {
        UserSession.systemMessage = systemMessage;
    }

    private static String systemMessage = "N/A";

    public static String getEnteredVehicleType() {
        return enteredVehicleType;
    }

    public static void setEnteredVehicleType(String enteredVehicleType) {
        UserSession.enteredVehicleType = enteredVehicleType;
    }

    public static Record getRecord() {
        return record;
    }

    public static void setRecord(Record record) {
        UserSession.record = record;
    }

    public static String getPlateNumber() {
        return plateNumber;
    }

    public static void setPlateNumber(String plateNumber) {
        UserSession.plateNumber = plateNumber;
    }

    public static void readVehicleType(String vehicleType){

    }
}
