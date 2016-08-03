package com.appteam.nithapp.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appteam.nithapp.Model.topicResponse;
import com.appteam.nithapp.Network.RetroCreator;
import com.appteam.nithapp.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Content_Forum extends Fragment {

    private static final String ID_TOPIC ="id" ;
    private TextView name,title,time;
    public Content_Forum() {
        // Required empty public constructor
    }

    public  static Content_Forum newInstance(int id){
        Log.d("ok","ok");
        Content_Forum f=new Content_Forum();
        Bundle b=new Bundle();
        b.putInt(ID_TOPIC,id);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_content__forum, container, false);
        name= (TextView) v.findViewById(R.id.name_user_forum);
        title= (TextView) v.findViewById(R.id.text_content_forum);
        time= (TextView) v.findViewById(R.id.time_created_forum);


        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Call<topicResponse> call= RetroCreator.getService().getTopic(1);
        call.enqueue(new Callback<topicResponse>() {
            @Override
            public void onResponse(Call<topicResponse> call, Response<topicResponse> response) {
                topicResponse t=response.body();
                name.setText(t.getName());
                title.setText(t.getTitle());
                time.setText(t.getTime());
            }

            @Override
            public void onFailure(Call<topicResponse> call, Throwable t) {

            }
        });
    }
}
