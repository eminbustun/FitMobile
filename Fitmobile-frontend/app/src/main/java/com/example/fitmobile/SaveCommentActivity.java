package com.example.fitmobile;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;



public class SaveCommentActivity extends AppCompatActivity {

    EditText txtComment;

    Button btnSave;

    Button btnBack;


    ExerciseRepo repo = new ExerciseRepo();

    String exerciseName;

    Handler uiHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {

            finish();
            return true;
        }
    });

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.save_comment_activity);
        exerciseName = getIntent().getStringExtra("exercisename");
        txtComment = findViewById(R.id.txtSaveComment);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(v->{

            repo.postComment(((ExerciseApplication)getApplication()).srv, uiHandler, exerciseName, txtComment.getText().toString());


        });

        btnBack = findViewById(R.id.btnBc);

        btnBack.setOnClickListener(v->{

            finish();

        });



    }
}
