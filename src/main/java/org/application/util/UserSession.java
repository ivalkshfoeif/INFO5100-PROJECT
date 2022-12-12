package org.application.util;

public class UserSession {

    private static String plateNumber = "N/A";

    public static String getPlateNumber() {
        return plateNumber;
    }

    public static void setPlateNumber(String plateNumber) {
        UserSession.plateNumber = plateNumber;
    }
}
