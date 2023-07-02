package com.example.fitmobile;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;


public  class ExerciseDetails extends AppCompatActivity{

    ImageView imgExercise;

    TextView txtExerciseName;

    ImageView imgYt;

    String exercisename;
    Button showComments;
    Button backButton;
    Uri uri;
    String video;
    TextView txtExplanation;

    Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {

            Exercise exercise = (Exercise) msg.obj;

            String video = exercise.getVideoUrl();

            uri = Uri.parse(video);

            txtExerciseName.setText(exercise.getName());

            txtExplanation.setText(exercise.getExplanation());

            //imgYt.setImageURI(uri);



            ExerciseRepo repo = new ExerciseRepo();
            repo.downloadImage(((ExerciseApplication)getApplication()).srv, imgHandler, exercise.getImagePath());


            return true;
        }
    });

    Handler imgHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {

            imgExercise.setImageBitmap((Bitmap) msg.obj);



            return true;
        }
    });


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_without_video);

        imgExercise = findViewById(R.id.imgView);
        txtExplanation = findViewById(R.id.txtExplanation);

      //  ytView = findViewById(R.id.ytbView);

        txtExerciseName = findViewById(R.id.txtExercise);
        backButton = findViewById(R.id.btn);

        imgYt = findViewById(R.id.imgYoutube);

        showComments = findViewById(R.id.btnComment);

        imgYt.setOnClickListener(v->{

            startActivity(new Intent(Intent.ACTION_VIEW, uri));

        });

        backButton.setOnClickListener(v->{
            finish();
        });

        String exercisename = getIntent().getExtras().getString("name");
        showComments.setOnClickListener(v->{
            Intent i = new Intent(this, Comments.class);
            i.putExtra("exercisename",exercisename);
            startActivity(i);
        });




        ExerciseRepo repo = new ExerciseRepo();
        repo.getExerciseByName(((ExerciseApplication)getApplication()).srv, handler, exercisename);



    }


}