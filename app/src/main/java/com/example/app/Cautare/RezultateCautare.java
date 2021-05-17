package com.example.app.Cautare;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

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

public class RezultateCautare extends AppCompatActivity implements MyAdapter.onAnimeListener{


    EditText editText;
    ImageButton imageButton;
    RecyclerView recyclerView;
    DB db ;
    MyAdapter adapter;
    List<Anime> anime ;
    FloatingActionButton floatingActionButton;
    static int pos;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rezultate);

        BottomNavigationView bnv = findViewById(R.id.nav_view);
        bnv.setSelectedItemId(R.id.navigation_cautare);
        recyclerView= findViewById(R.id.main_recycler2);
        floatingActionButton =findViewById(R.id.floatingActionButton3);

        db = new DB(RezultateCautare.this);
        anime = new ArrayList<>();

        anime =db.getCautareAnime(Cautare.getCautare());

        adapter = new MyAdapter( anime,this);//l,l1,l6,l2,l3,l4,l5,l7,l8,this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));

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

    @Override
    public void onAnimeClick(int position) {
        pos = anime.get(position).getId();
        adapter.notifyItemChanged(position);
        Intent intent = new Intent(this, AS2.class);
        startActivity(intent);
        finish();
        overridePendingTransition(0, 0);
        position =anime.get(position).getId();
    }
    public static int getPos(){
        return pos;
    }
}


