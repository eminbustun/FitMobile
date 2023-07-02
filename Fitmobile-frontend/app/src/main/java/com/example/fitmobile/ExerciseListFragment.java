package com.example.fitmobile;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;
import java.util.concurrent.ExecutorService;

public class ExerciseListFragment extends Fragment {

    private String group;

    RecyclerView recView;

    ExecutorService srv;


    Handler exHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(@NonNull Message msg) {

            List<Exercise> data = (List<Exercise>)msg.obj;

            ExerciseAdapter adapter = new ExerciseAdapter(getActivity(), data);

            recView.setAdapter(adapter);
            recView.setLayoutManager(new LinearLayoutManager(getActivity()));


            return true;
        }
    });

    public ExerciseListFragment(String group, ExecutorService srv) {
        this.group = group;
        this.srv = srv;
    }

   public ExerciseListFragment(){


   }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.activity_exercise_list_fragment,container,false);

        recView = root.findViewById(R.id.recView);

        ExerciseRepo repo = new ExerciseRepo();

        repo.getExercisesByGroup(srv, exHandler, group);

        return root;

    }
}