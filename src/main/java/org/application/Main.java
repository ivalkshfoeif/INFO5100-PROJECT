package org.application;

import org.application.enums.SpotStatus;
import org.application.enums.SpotType;
import org.application.model.Record;
import org.application.model.Spot;
import org.application.util.Database;
import org.application.util.ParkingLot;
import org.application.view.HomePanel;

public class Main {

    public static void main(String[] args) {
        System.out.println( "Hello World!" );
        Database.init();
        HomePanel homePanel = new HomePanel();
    }

}
