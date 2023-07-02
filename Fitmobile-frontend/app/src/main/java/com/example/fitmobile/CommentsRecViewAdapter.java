package com.example.fitmobile;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommentsRecViewAdapter extends RecyclerView.Adapter<CommentsRecViewAdapter.CommentViewHolder>{

    List<CommentItem> data;

    Context context;


    public CommentsRecViewAdapter(List<CommentItem> data, Context context) {
        this.data = data;
        this.context = context;

    }

    public CommentsRecViewAdapter() {
    }


    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View root = LayoutInflater.from(context).inflate(R.layout.comments_row,parent,false);
        CommentViewHolder holder = new CommentViewHolder(root);

        return holder;
    }


    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {

        holder.txtComment.setText(data.get(position).getComment());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class CommentViewHolder extends RecyclerView.ViewHolder{

        TextView txtComment;


        public CommentViewHolder(@NonNull View itemView) {
            super(itemView);
            txtComment = itemView.findViewById(R.id.txtComment);
        }
    }

}
