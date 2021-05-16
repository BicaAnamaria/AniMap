package com.example.app.Principal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.app.Adapters.MyAdapter;
import com.example.app.Adapters.MyAdapter2;
import com.example.app.Anime;
import com.example.app.Cautare.Cautare;
import com.example.app.DB.DB;
import com.example.app.Lista.Lista;
import com.example.app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MyAdapter.onAnimeListener {

    RecyclerView recyclerView;
    DB db ;
    MyAdapter adapter;
    List<Anime> anime ;
    static int pos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bnv = findViewById(R.id.nav_view);

        bnv.setSelectedItemId(R.id.navigation_home);

        recyclerView= findViewById(R.id.main_recycler);

        db = new DB(MainActivity.this);
        db.createTableAnime();
        anime = new ArrayList<>();
        //db.update1();


        anime = db.getAnime();

        adapter = new MyAdapter( anime,this);//l,l1,l6,l2,l3,l4,l5,l7,l8,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));


        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.navigation_home:{
                        return true;


                }


                    case R.id.navigation_cautare:{
                    Intent i1 = new Intent(getApplicationContext(), Cautare.class);
                    startActivity(i1);
                    finish();
                    overridePendingTransition(0, 0);
                    return true;

                }
                    case R.id.navigation_lista :{
                    Intent i1 = new Intent(getApplicationContext(), Lista.class);
                    startActivity(i1);
                    finish();
                    overridePendingTransition(0, 0);
                    return true;

                }}
                return false;

            }
        });


    }


    @Override
    public void onAnimeClick(int position) {
        pos = anime.get(position).getId();
        adapter.notifyItemChanged(position);
        Intent intent = new Intent(this, AnimeSpecific.class);
        startActivity(intent);
        position =anime.get(position).getId();
    }
    public static int getPos(){
        return pos;
    }


}