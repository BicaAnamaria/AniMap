package com.example.app.Lista;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app.Anime;
import com.example.app.Cautare.AS3;
import com.example.app.Cautare.Cautare;
import com.example.app.Cautare.GEN;
import com.example.app.DB.DB;
import com.example.app.Principal.MainActivity;
import com.example.app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class Lista extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        BottomNavigationView bnv = findViewById(R.id.nav_view);
        bnv.setSelectedItemId(R.id.navigation_lista);

        Button log = findViewById(R.id.button);
        Button sing = findViewById(R.id.button1);




        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Informatii.class);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);

            }

        });

        sing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ListaMea.class);
                startActivity(intent);
                finish();
                overridePendingTransition(0, 0);

            }

        });






        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){
                    case R.id.navigation_lista:{
                        return true;



                    }


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
                }}
                return false;

            }
        });
}

}
