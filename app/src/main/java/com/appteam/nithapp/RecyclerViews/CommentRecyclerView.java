package com.appteam.nithapp.RecyclerViews;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appteam.nithapp.Model.Comment;
import com.appteam.nithapp.R;

import java.util.ArrayList;

/**
 * Created by Ramola on 8/2/2016.
 */
public class CommentRecyclerView extends RecyclerView.Adapter<CommentRecyclerView.viewHolder> {
    private ArrayList<Comment> list = new ArrayList<>();

    public void refresh(ArrayList<Comment> list) {
        this.list = list;
        notifyItemRangeChanged(0, list.size());
    }


    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {

        if(!list.get(position).getA_answer().isEmpty()){
            holder.comment.setText(list.get(position).getA_answer());
        }
        if(!list.get(position).getA_name().isEmpty()){
            holder.username.setText(list.get(position).getA_name());
        }
        if(!list.get(position).getTime().isEmpty()){
            holder.time.setText(list.get(position).getTime());
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        TextView username,time,comment;

        public viewHolder(View itemView) {
            super(itemView);
            username= (TextView) itemView.findViewById(R.id.name_user_forum);
            time= (TextView) itemView.findViewById(R.id.time_created_forum);
            comment= (TextView) itemView.findViewById(R.id.text_content_forum);
        }
    }
}
