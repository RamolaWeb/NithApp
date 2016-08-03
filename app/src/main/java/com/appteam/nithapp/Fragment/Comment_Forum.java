package com.appteam.nithapp.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appteam.nithapp.Model.CommentResponse;
import com.appteam.nithapp.Network.RetroCreator;
import com.appteam.nithapp.R;
import com.appteam.nithapp.RecyclerViews.CommentRecyclerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Comment_Forum extends Fragment {
    private static final java.lang.String ID_TOPIC = "id";
    private RecyclerView list;
    private CommentRecyclerView adapter;

    public Comment_Forum() {
        // Required empty public constructor
    }

    public static Comment_Forum newInstance(int id) {
        Log.d("ok","ok1");
        Comment_Forum f = new Comment_Forum();
        Bundle b = new Bundle();
        b.putInt(ID_TOPIC, id);
        f.setArguments(b);
        return f;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_comment__forum, container, false);
        list = (RecyclerView) v.findViewById(R.id.list_comment);
        adapter = new CommentRecyclerView();
        list.setLayoutManager(new LinearLayoutManager(getActivity()));
        list.setAdapter(adapter);


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Call<CommentResponse> call = RetroCreator.getService().getAllComment(1);
        call.enqueue(new Callback<CommentResponse>() {
            @Override
            public void onResponse(Call<CommentResponse> call, Response<CommentResponse> response) {
                adapter.refresh(response.body().getList());
            }

            @Override
            public void onFailure(Call<CommentResponse> call, Throwable t) {

            }
        });
    }
}
