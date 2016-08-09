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
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_comment, parent, false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {

        if (!list.get(position).getA_answer().isEmpty()) {
            holder.comment.setText(list.get(position).getA_answer());
        }
        holder.detail.setText("By " + list.get(position).getA_name() + " / " + list.get(position).getTime());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {

        TextView detail, comment;

        public viewHolder(View itemView) {
            super(itemView);
            detail = (TextView) itemView.findViewById(R.id.detail_comment);
            comment = (TextView) itemView.findViewById(R.id.text_comment_forum);
        }
    }
}
