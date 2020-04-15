package com.example.GameRecommender;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.codepath.asynchttpclient.AsyncHttpClient;
import com.codepath.asynchttpclient.callback.JsonHttpResponseHandler;
import com.example.GameRecommender.Fragments.ComposeFragment;
import com.example.GameRecommender.adapters.VideoGameAdapter;
import com.example.GameRecommender.models.VideoGame;
import com.facebook.stetho.common.ArrayListAccumulator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Headers;

public class GameActivity extends AppCompatActivity {
    public static int page = 1;
    public static String VIDEO_GAME_URL = "https://api.rawg.io/api/games?page=" + page;
    public static final String TAG = "MainActivity";
    Button Next;
    Button Prev;


    List<VideoGame> videoGames;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_posts);
        RecyclerView rvVGames = findViewById(R.id.rvVGames);
        videoGames = new ArrayList<>();

        final VideoGameAdapter videoGameAdapter = new VideoGameAdapter(this, videoGames);
        rvVGames.setAdapter(videoGameAdapter);
        rvVGames.setLayoutManager(new LinearLayoutManager(this));

        final AsyncHttpClient client = new AsyncHttpClient();
        while (page != 0) {
            client.get(VIDEO_GAME_URL, new JsonHttpResponseHandler() {
                @Override
                public void onSuccess(int statusCode, Headers headers, JSON json) {
                    Log.d(TAG, "onSuccess");
                    JSONObject jsonObject = json.jsonObject;
                    try {
                        JSONArray results = jsonObject.getJSONArray("results");
                        Log.i(TAG, "Results: " + results.toString());
                        videoGames.addAll(VideoGame.fromJsonArray(results));
                        videoGameAdapter.notifyDataSetChanged();
                        Log.i(TAG, "Video Games: " + videoGames.size());
                    } catch (JSONException e) {
                        Log.e(TAG, "Hit json exception", e);
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(int statusCode, Headers headers, String response, Throwable throwable) {
                    Log.d(TAG, "onFailure");
                }
            });
            VIDEO_GAME_URL = "https://api.rawg.io/api/games?page=" + page--;}




    }

    private void goFrag() {
        Intent intent = new Intent(this, ComposeFragment.class);
        startActivity(intent);
    }

}

