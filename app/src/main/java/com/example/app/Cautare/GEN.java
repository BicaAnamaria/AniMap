package com.example.app.Cautare;

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
import com.example.app.DB.DB;
import com.example.app.Lista.Lista;
import com.example.app.Principal.MainActivity;
import com.example.app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class GEN extends AppCompatActivity implements MyAdapter.onAnimeListener {
    DB db = new DB(GEN.this);
    MyAdapter adapter1;
    RecyclerView recyclerView;
    Button bt;
    FloatingActionButton floatingActionButton;
    List<Anime> anime;
    static int pos;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activitate_cautare1);
        BottomNavigationView bnv = findViewById(R.id.nav_view);
        bnv.setSelectedItemId(R.id.navigation_cautare);

        recyclerView= findViewById(R.id.main_recycler1);

        db = new DB(GEN.this);

        anime = new ArrayList<>();

        String gen = Cautare.getGen();
        anime = db.getGenuri(gen);

        adapter1 = new MyAdapter(anime,this);//l,l1,l6,l2,l3,l4,l5,l7,l8,this);
        recyclerView.setAdapter(adapter1);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));



        floatingActionButton = findViewById(R.id.floatingActionButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Intent i1 = new Intent(getApplicationContext(), Cautare.class);
                startActivity(i1);
                finish();
                overridePendingTransition(0, 0);

            }
        });

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.navigation_home:{
                        Intent i1 = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i1);
                        finish();
                        overridePendingTransition(0, 0);
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
    public void onAnimeClick(int position) {
         anime.get(position);
        Intent intent = new Intent(this, AS3.class);
        startActivity(intent);
        finish();
        overridePendingTransition(0, 0);
        pos =anime.get(position).getId();

    }

    public static int getPos(){
        return pos;
    }

}
