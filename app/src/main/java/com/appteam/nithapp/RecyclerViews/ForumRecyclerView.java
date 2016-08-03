package com.appteam.nithapp.RecyclerViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appteam.nithapp.Model.ForumModel;
import com.appteam.nithapp.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;


/**
 * Created by Ramola on 7/31/2016.
 */
public class ForumRecyclerView extends RecyclerView.Adapter<ForumRecyclerView.viewHolder> {

    private Context context;
    private ArrayList<ForumModel> list = new ArrayList<>();

    public ForumRecyclerView(Context context) {
        this.context = context;
    }

    public void refresh(ArrayList<ForumModel> list) {
        this.list = list;
        notifyItemRangeInserted(0, list.size());
    }

    @Override
    public viewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_forum, parent, false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(viewHolder holder, int position) {
        if (!list.get(position).getUp_vote().isEmpty()) {
            holder.like_forum.setText(list.get(position).getUp_vote());
        }
        if (!list.get(position).getCreated_on().isEmpty()) {
          holder.time_created.setText(list.get(position).getCreated_on());
        }
        if (!list.get(position).getTitle().isEmpty()) {
              holder.content_forum.setText(list.get(position).getTitle());
        }
        if (!list.get(position).getTotal_comment().isEmpty()) {
            holder.comment_forum.setText(list.get(position).getTotal_comment());
        }
        if (list.get(position).getContent_image()!=null&&!list.get(position).getContent_image().isEmpty()) {
            holder.image_content_forum.setVisibility(View.VISIBLE);
            Glide.with(context).load(list.get(position).getContent_image()).diskCacheStrategy(DiskCacheStrategy.SOURCE).into(holder.image_content_forum);
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
        TextView user_name, content_forum, like_forum, comment_forum,time_created;
        ImageView image_content_forum;

        public viewHolder(View itemView) {
            super(itemView);
            user_name = (TextView) itemView.findViewById(R.id.name_user_forum);
            content_forum = (TextView) itemView.findViewById(R.id.text_content_forum);
            like_forum = (TextView) itemView.findViewById(R.id.likes_user_forum);
            comment_forum = (TextView) itemView.findViewById(R.id.comment_user_forum);
            image_content_forum = (ImageView) itemView.findViewById(R.id.image_content_forum);
            time_created= (TextView) itemView.findViewById(R.id.time_created_forum);
        }
    }
}
