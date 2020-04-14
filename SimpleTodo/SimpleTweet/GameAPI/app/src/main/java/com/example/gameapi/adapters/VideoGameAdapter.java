package com.example.gameapi.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gameapi.R;
import com.example.gameapi.model.VideoGame;

import java.util.List;

public class VideoGameAdapter extends RecyclerView.Adapter<VideoGameAdapter.ViewHolder>{

    Context context;
    List<VideoGame> videoGames;
    RatingBar ratingBar;

    public VideoGameAdapter(Context context, List<VideoGame> videoGames) {
        this.context = context;
        this.videoGames = videoGames;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View gameView = LayoutInflater.from(context).inflate(R.layout.item_game, parent, false);
        return new ViewHolder(gameView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        VideoGame videoGame = videoGames.get(position);
        holder.bind(videoGame);
    }

    @Override
    public int getItemCount() {
        return videoGames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView vgName;
        TextView vgDescription;
        ImageView ivPicture;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vgName = itemView.findViewById(R.id.vgName);
            ratingBar = itemView.findViewById(R.id.ratingBar);
            ivPicture = itemView.findViewById(R.id.ivPicture);
        }

        public void bind(VideoGame videoGame) {
            vgName.setText(videoGame.getName());
            ratingBar.setRating((float) videoGame.getRating());
            Glide.with(context).load(videoGame.getBackground_image()).into(ivPicture);

        }
    }
}
