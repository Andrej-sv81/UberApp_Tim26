package com.example.uberapp_tim26.tools;

import com.example.uberapp_tim26.R;
import com.example.uberapp_tim26.model.DriverPlaceholder;
import com.example.uberapp_tim26.model.PassengerPlaceholder;

public class Mokap {

    public static DriverPlaceholder getDriver() {
        DriverPlaceholder driver = new DriverPlaceholder(
                "Marko",
                "Markovic",
                "0232J232",
                "066/2322223",
                "markom@uns.ac.rs",
                R.mipmap.ic_driver_avatar);

        return driver;
    }

    public static PassengerPlaceholder getPassenger() {
        PassengerPlaceholder driver = new PassengerPlaceholder(
                "Pera",
                "Peric",
                "242DF2",
                "066/2112224",
                "ppera@uns.ac.rs",
                R.mipmap.ic_driver_avatar);

        return driver;
    }
}
