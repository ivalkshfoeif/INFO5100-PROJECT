package org.application.enums;

public enum SpotStatus {
    OCCUPIED("OCCUPIED"),
    FREE("FREE");

    public final String value;

    private SpotStatus(String value){
        this.value = value;
    }
}
