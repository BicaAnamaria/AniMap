package com.example.app.Lista;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.Adapters.MyAdapter;
import com.example.app.Anime;
import com.example.app.Cautare.AS3;
import com.example.app.Cautare.Cautare;
import com.example.app.DB.DB;
import com.example.app.Principal.MainActivity;
import com.example.app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class ListaMea extends AppCompatActivity implements MyAdapter.onAnimeListener {

        MyAdapter adapter;
        RecyclerView recyclerView;
        DB db;
        List<Anime> anime1 ;
        FloatingActionButton bt;
        static  int pos;
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_lista_mea);

            BottomNavigationView bnv = findViewById(R.id.nav_view);

            bnv.setSelectedItemId(R.id.navigation_lista);
            recyclerView= findViewById(R.id.main_recycler1);
            bt = findViewById(R.id.floatingActionButton1);

            db = new DB(ListaMea.this);
            anime1 = new ArrayList<>();

            anime1 = db.getListaAnime();


            adapter = new MyAdapter( anime1,this);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new GridLayoutManager(this,2));

            bt.setOnClickListener(new View.OnClickListener() {
                @Override

                public void onClick(View v) {

                    Intent i1 = new Intent(getApplicationContext(), Lista.class);
                    startActivity(i1);
                    finish();
                    overridePendingTransition(0, 0);

                }
            });

            bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    switch (item.getItemId()){

                        case R.id.navigation_cautare:{
                            Intent i1 = new Intent(getApplicationContext(), Cautare.class);
                            startActivity(i1);
                            finish();
                            overridePendingTransition(0, 0);
                            return true;

                        }

                        case R.id.navigation_home:{
                            Intent i1 = new Intent(getApplicationContext(), MainActivity.class);
                            startActivity(i1);
                            finish();
                            overridePendingTransition(0, 0);
                            return true;

                        }
                        case R.id.navigation_lista: {
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

    public void onAnimeClick(int position) {
        pos = anime1.get(position).getId();
        //adapter.notifyItemChanged(position);
        Intent intent = new Intent(this, AS4.class);
        startActivity(intent);
        finish();
        overridePendingTransition(0, 0);


    }

    public static int getPos(){
        return pos;
    }
}

