package com.example.commentsection;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.apache.commons.io.FileUtils;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> comments;

    Button button2;
    EditText editText;
    RecyclerView Recycle;
    CommentsAdapter CommentsAdapters;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button2 = findViewById(R.id.button2);
        editText = findViewById(R.id.editText);
        Recycle = findViewById(R.id.Recycle);

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
        Recycle.setLayoutManager(new LinearLayoutManager(this));

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
        });


    }
    private File getDataFile(){
        return new File(getFilesDir(), "data.txt");
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
