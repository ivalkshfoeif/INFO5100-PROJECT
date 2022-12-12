package org.application.enums;

public enum SpotType {
    SMALL("SMALL"),
    MEDIUM("MEDIUM"),
    LARGE("LARGE");

    public final String value;

    private SpotType(String value){
        this.value = value;
    }
}
