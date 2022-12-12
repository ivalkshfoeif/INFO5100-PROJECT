package org.application.enums;

public enum RecordStatus {
    ACTIVE("ACTIVE"),
    ARCHIVED("ARCHIVED");

    public final String value;

    private RecordStatus(String value){
        this.value = value;
    }
}
