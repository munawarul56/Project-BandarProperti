package com.bandarproperti;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ListFavoriteActivity extends AppCompatActivity {

    private RecyclerView listfavorite_recyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_favorite);

        listfavorite_recyclerview = (RecyclerView)findViewById(R.id.listfavorite_recyclerview);
        listfavorite_recyclerview.setLayoutManager(new LinearLayoutManager(this));
    }
}
