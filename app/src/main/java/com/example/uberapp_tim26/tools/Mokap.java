package com.example.uberapp_tim26.tools;

import com.example.uberapp_tim26.R;
import com.example.uberapp_tim26.model.DriverPlaceholder;

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
}
