package com.example.uberapp_tim26.tools;

import android.app.Application;
import android.content.Context;

public class GariGo extends Application {
    private static GariGo instance;

    public static GariGo getInstance() {
        return instance;
    }

    public static Context getContext() {
        return instance;
    }

    @Override
    public void onCreate() {
        instance = this;
        super.onCreate();
    }
}
