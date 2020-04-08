package com.example.GameRecommender;

import android.app.Application;

import com.parse.Parse;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("vgr-app") // should correspond to APP_ID env variable
                .clientKey("VideoGameReccomendation")  // set explicitly unless clientKey is explicitly configured on Parse server
                .server("https://vgr-app.herokuapp.com/parse/").build());
    }
}
