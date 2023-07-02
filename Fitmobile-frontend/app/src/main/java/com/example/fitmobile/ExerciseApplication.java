package com.example.fitmobile;

import android.app.Application;

import androidx.recyclerview.widget.RecyclerView;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Handler;

public class ExerciseApplication extends Application {



    ExecutorService srv = Executors.newCachedThreadPool();

}
