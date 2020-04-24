package com.example.GameRecommender.Fragments;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.apache.commons.io.FileUtils;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.GameRecommender.Comment;
import com.example.GameRecommender.Post;
import com.example.GameRecommender.R;
import com.example.GameRecommender.adapters.CommentsAdapter;
import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseFile;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static com.parse.Parse.getApplicationContext;

public class CommentFragment extends Fragment {

    List<String> comments;

    Button button2;
    EditText editText;
    RecyclerView Recycle;
    CommentsAdapter CommentsAdapters;

    public CommentFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_comment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button2 = view.findViewById(R.id.button2);
        editText = view.findViewById(R.id.editText);
        Recycle = view.findViewById(R.id.Recycle);

        loadItems();

        CommentsAdapter.OnLongClickListener onLongClickListener = new CommentsAdapter.OnLongClickListener(){
            @Override
            public void onItemLongClicked(int position) {
                comments.remove(position);
                CommentsAdapters.notifyItemRemoved(position);
                Toast.makeText(getApplicationContext(), "Item was removed", Toast.LENGTH_SHORT).show();
                saveItems();

            }
        };

        CommentsAdapters = new CommentsAdapter(comments, onLongClickListener);
        Recycle.setAdapter(CommentsAdapters);
        Recycle.setLayoutManager(new LinearLayoutManager(getContext()));

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String comment = editText.getText().toString();
                comments.add(comment);
                CommentsAdapters.notifyItemInserted(comments.size() - 1);
                editText.setText("");
                Toast.makeText(getApplicationContext(), "Item was added", Toast.LENGTH_SHORT).show();
                saveItems();
            }
        });/*
        rvPosts = view.findViewById(R.id.rvPosts);
        allComments = new ArrayList<>();
        adapter = new CommentsAdapter(getContext(), allComments);

        rvPosts.setAdapter(adapter);
        rvPosts.setLayoutManager(new LinearLayoutManager(getContext()));
        queryPosts();*/
    }

    private File getDataFile(){
        return new File(getContext().getFilesDir(), "data.txt");
    }

    private void loadItems(){
        try {
            comments = new ArrayList<>(FileUtils.readLines(getDataFile(), Charset.defaultCharset()));
        } catch (IOException e) {
            Log.e("MainActivity", "Error reading items", e);
            comments = new ArrayList<>();
        }

    }
    private void saveItems() {
        try {
            FileUtils.writeLines(getDataFile(), comments);
        } catch (IOException e) {
            Log.e("MainActivity", "Error writing items", e);
        }
    }


}
