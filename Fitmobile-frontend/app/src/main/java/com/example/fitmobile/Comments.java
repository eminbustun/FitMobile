package com.example.fitmobile;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class Comments extends AppCompatActivity {

    RecyclerView recView;

    List<CommentItem> data = new ArrayList<>();

    Button btnBack;

    Button btnSave;

    String exerciseName;

    ExerciseRepo repo = new ExerciseRepo();

    Handler uiHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {

            data = (List<CommentItem>) msg.obj;

            CommentsRecViewAdapter adp = new CommentsRecViewAdapter(data, Comments.this);
            recView.setLayoutManager(new LinearLayoutManager(Comments.this));
            recView.setAdapter(adp);



            return true;
        }
    });


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.yedek_activity_comments);
        exerciseName = getIntent().getStringExtra("exercisename");
        recView = findViewById(R.id.recView);
        btnBack = findViewById(R.id.btnBvk);

        btnSave = findViewById(R.id.btnAddComment);

        btnSave.setOnClickListener(v->{

            Intent i = new Intent(this, SaveCommentActivity.class);
            i.putExtra("exercisename",exerciseName);
            startActivity(i);

        });

        btnBack.setOnClickListener(v->{

            finish();

        });
        repo.commentsByExerciseName(((ExerciseApplication)getApplication()).srv, uiHandler, exerciseName);
    }

    @Override
    protected void onResume() {
        super.onResume();
        repo.commentsByExerciseName(((ExerciseApplication)getApplication()).srv, uiHandler, exerciseName);
    }
}
