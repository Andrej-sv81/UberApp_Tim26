package com.example.uberapp_tim26.tools;

import com.example.uberapp_tim26.R;
import com.example.uberapp_tim26.model.DriverPlaceholder;
import com.example.uberapp_tim26.model.Message;
import com.example.uberapp_tim26.model.PassengerPlaceholder;

import java.util.ArrayList;
import java.util.List;

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

    public static List<Message> getMessage(){
        ArrayList<Message> list = new ArrayList<Message>();
        Message m1 = new Message("PeraP", "Voznja#2422", "Jedno vozilo stize an vasu adresu,\nbroj vozila: 2322 ");
        Message m2 = new Message("MarkoM", "Voznja#2321", "Jedno vozilo stize an vasu adresu,\nbroj vozila: 42223 ");
        Message m3 = new Message("PeraP", "Voznja#12112", "Jedno vozilo stize an vasu adresu,\nbroj vozila: 2322 ");
        Message m4 = new Message("MarkoM", "Voznja#74642", "Jedno vozilo stize an vasu adresu,\nbroj vozila: 42422 ");

        list.add(m1);
        list.add(m2);
        list.add(m3);
        list.add(m4);

        return  list;
    }
}
