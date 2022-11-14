package com.example.uberapp_tim26.tools;

import com.example.uberapp_tim26.R;
import com.example.uberapp_tim26.model.DriverPlaceholder;
import com.example.uberapp_tim26.model.RideHistoryPlaceholder;

import java.util.ArrayList;
import java.util.List;

public class MokapRideHistory {

    public static List<RideHistoryPlaceholder> getRideHistory(){
        ArrayList<RideHistoryPlaceholder> rides = new ArrayList<RideHistoryPlaceholder>();
        RideHistoryPlaceholder r1 = new RideHistoryPlaceholder("Solidna vozja","Bulevar A - Bulevar B","20.11.2022 20:42",3);
        RideHistoryPlaceholder r2 = new RideHistoryPlaceholder("Katastrofa","Bulevar D - Bulevar A","20.11.2022 21:42",1);
        RideHistoryPlaceholder r3 = new RideHistoryPlaceholder("Jako lose","Bulevar A - Bulevar C","20.11.2022 22:42",2);

        rides.add(r1);
        rides.add(r2);
        rides.add(r3);

        return rides;
    }
}
