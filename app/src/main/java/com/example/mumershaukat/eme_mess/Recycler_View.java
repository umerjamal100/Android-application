package com.example.mumershaukat.eme_mess;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.mumershaukat.eme_mess.MyLoginActivity;


import java.util.ArrayList;
import java.util.List;
public class Recycler_View extends AppCompatActivity {
    private List<Movie> movieList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MoviesAdapter mAdapter;
    private String record;

    Value_Recycler_View data=new Value_Recycler_View();

    Data result=Data.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler__view);


        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);

        mAdapter = new MoviesAdapter(movieList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);


        prepareMovieData(result.record);

    }


    private void prepareMovieData(String result) {
        String[] s_data= Value_Recycler_View.splitter(result);
        String[] yes=s_data[0].split(",");
        String[] date=s_data[1].split(",");
        int size=date.length;
        //List<Movie> move = new ArrayList<Movie>();
        for(int i=0;i<size;i++)
        {
            Movie movie=new Movie(date[i],yes[i]);
            movieList.add(movie);
        }

        mAdapter.notifyDataSetChanged();
    }
}
