package org.application.enums;

public enum VehicleType {
    MOTORBIKE("MOTORBIKE"),
    CAR("CAR"),
    VAN("VAN");

    public final String value;

    private VehicleType(String value){
        this.value = value;
    }
}
