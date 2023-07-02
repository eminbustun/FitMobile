package com.example.fitmobile;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.concurrent.ExecutorService;


public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseAdapter.ExerciseViewHolder> {



    Context context;

    List<Exercise> data;

    public ExerciseAdapter(Context context, List<Exercise> data) {
        this.context = context;
        this.data = data;
    }



    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(context).inflate(R.layout.exercise_row_layout,parent,false);
        ExerciseViewHolder holder = new ExerciseViewHolder(root);

        holder.setIsRecyclable(false);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {


        // changed
        holder.txtName.setText(data.get(position).getName());


        holder.loadImage(data.get(position).getImagePath());


        holder.row.setOnClickListener(v->{

            Intent i = new Intent(context, ExerciseDetails.class);

            String adjust = data.get(position).getName();

            //int a = adjust.indexOf(" ");

            i.putExtra("name",data.get(position).getName());

            ((AppCompatActivity)context).startActivity(i);
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class ExerciseViewHolder extends RecyclerView.ViewHolder{

        ConstraintLayout row;

        TextView txtName;

        ImageView imgEx;

        String path;
        boolean imageDownloaded = false;

        Handler imageHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(@NonNull Message msg) {

                imgEx.setImageBitmap((Bitmap) msg.obj);
                imageDownloaded = true;

                return true;
            }
        });

        public ExerciseViewHolder(@NonNull View itemView) {
            super(itemView);
            this.path = path;
            row = itemView.findViewById(R.id.row_list);
            txtName = itemView.findViewById(R.id.txtListName);
            imgEx = itemView.findViewById(R.id.imgList);
        }

        public void loadImage(String path){

            if(imageDownloaded == false){
                ExerciseRepo repo = new ExerciseRepo();
                repo.downloadImage(((ExerciseApplication)((AppCompatActivity)context).getApplication()).srv, imageHandler,path);
            }

        }


    }

}
