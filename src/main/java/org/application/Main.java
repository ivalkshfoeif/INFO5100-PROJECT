package org.application;

import org.application.enums.SpotStatus;
import org.application.enums.SpotType;
import org.application.model.Record;
import org.application.model.Spot;
import org.application.util.Database;
import org.application.util.ParkingLot;

public class Main {

    public static void main(String[] args) {
        System.out.println( "Hello World!" );
        Database.init();
        Spot spot = Spot.findFreeSpotByType(SpotType.SMALL);
        Spot.updateSpotStatusToSpotStatus(spot, SpotStatus.OCCUPIED);
        Spot.countFreeSpotBtSpotType(SpotType.SMALL);
        Spot.countFreeSpotBtSpotType(SpotType.MEDIUM);
        Spot.countFreeSpotBtSpotType(SpotType.LARGE);
        Record record = new Record();
        record.setRecordId("1");
        record.setPlateNumber("2");
        record.setRecordStatus("ACTIVE");
        record.setAmount(1.1);
        Record.insertRecord(record);
        Record.foundActiveRecordsByPlateNumber("2");
        record.setAmount(90.1);
        record.setRecordStatus("ARCHIVED");
        record.setEndTimeStamp("23");
        Record.updateRecord(record);
    }

}
