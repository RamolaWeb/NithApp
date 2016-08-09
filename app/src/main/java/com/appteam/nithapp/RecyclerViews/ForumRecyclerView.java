package com.appteam.nithapp.RecyclerViews;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appteam.nithapp.Model.ForumModel;
import com.appteam.nithapp.R;

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
       if(!list.get(position).getTitle().isEmpty()){
           holder.title.setText(list.get(position).getTitle());
       }
       holder.detail.setText("by Username / "+list.get(position).getCreated_on()+" / "+" "+list.get(position).getTotal_comment()+" comment");
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class viewHolder extends RecyclerView.ViewHolder {
       TextView title,detail;

        public viewHolder(View itemView) {
            super(itemView);
           title= (TextView) itemView.findViewById(R.id.text_title_forum);
            detail= (TextView) itemView.findViewById(R.id.detail_forum);
        }
    }
}
