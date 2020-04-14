package com.example.GameRecommender.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class VideoGame {
    String background_image;
    String name;
    double rating;
    String next;
    URL url;

    public VideoGame(JSONObject jsonObject) throws JSONException {
        name = jsonObject.getString("name");
        background_image = jsonObject.getString("background_image");
        rating = jsonObject.getDouble("rating");

        //description = jsonObject.getString("description");
    }

    public static List<VideoGame> fromJsonArray(JSONArray videogameJsonArray) throws JSONException {
        List<VideoGame> videoGames = new ArrayList<>();
        for(int i=0; i<videogameJsonArray.length(); i++)
        {
            videoGames.add(new VideoGame(videogameJsonArray.getJSONObject(i)));
        }
        return videoGames;
    }

    public String getBackground_image() {
        return background_image;
    }

    public String getName() {
        return name;
    }

    public double getRating() {
        return rating;
    }
    public String getNext() {return next;}

   /* public String getDescription() {
        return description;
    }*/
}
