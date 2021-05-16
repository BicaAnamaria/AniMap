package com.example.app.Lista;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.Cautare.Cautare;
import com.example.app.DB.DB;
import com.example.app.Principal.MainActivity;
import com.example.app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Informatii extends AppCompatActivity {

    DB db;

    TextView e1,e2;
    FloatingActionButton fbutton;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.informatii);
        BottomNavigationView bnv = findViewById(R.id.nav_view6);
        bnv.setSelectedItemId(R.id.navigation_lista);

        db = new DB(Informatii.this);
        int i = db.getNrAnime();
        System.out.println(i);
        int s=0;
        List<Integer> j = db.getNrEp();
        for(Integer k: j){
            s = s + k;
        }
        System.out.println(j);

        e1 = findViewById(R.id.editTextTextPersonName4);
        e1.setText(String.format("%s", db.getNrAnime()));
        e2 = findViewById(R.id.editTextTextPersonName2);
        e2.setText(String.format("%s",s));



        fbutton = findViewById(R.id.floatingActionButton6);
        fbutton.setOnClickListener(v -> {

            Intent i1 = new Intent(getApplicationContext(), Lista.class);
            startActivity(i1);
            finish();
            overridePendingTransition(0, 0);

        });

        bnv.setOnNavigationItemSelectedListener(item -> {

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

        });

    }


}
