package com.example.app.Cautare;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.app.Anime;
import com.example.app.DB.DB;
import com.example.app.Lista.Lista;
import com.example.app.Principal.MainActivity;
import com.example.app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Cautare extends AppCompatActivity {

    static String gen;
    EditText editText;
    ImageButton imageButton;
    static List<Anime> anime = new ArrayList<>();
    static String cautare;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cautare);

        BottomNavigationView bnv = findViewById(R.id.nav_view);
        bnv.setSelectedItemId(R.id.navigation_cautare);

        Button btn = (Button)findViewById(R.id.button6);
        Button btn1 = (Button)findViewById(R.id.button5);
        Button btn2= (Button)findViewById(R.id.button4);
        Button btn3 = (Button)findViewById(R.id.button3);

        editText = findViewById(R.id.search_field);
        //String cautare = editText.getText().toString();
        System.out.println(cautare+ editText.getText().toString() +"++++++++++++++++++");
        imageButton =findViewById(R.id.imageButton);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                cautare = editText.getText().toString();
                setAnime(cautare);
                Intent i1 = new Intent(getApplicationContext(), RezultateCautare.class);
                startActivity(i1);
                finish();
                overridePendingTransition(0, 0);

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Intent i1 = new Intent(getApplicationContext(), GEN.class);
                startActivity(i1);
                setGen("a");
                finish();
                overridePendingTransition(0, 0);

            }
        });

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Intent i1 = new Intent(getApplicationContext(), GEN.class);
                startActivity(i1);
                setGen("av");
                finish();
                overridePendingTransition(0, 0);

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Intent i1 = new Intent(getApplicationContext(), GEN.class);
                startActivity(i1);
                setGen("d");
                finish();
                overridePendingTransition(0, 0);

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                Intent i1 = new Intent(getApplicationContext(), GEN.class);
                startActivity(i1);
                setGen("s");
                finish();
                overridePendingTransition(0, 0);

            }
        });

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()){

                    case R.id.navigation_cautare:{
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
    public static String setGen(String gen1){
        gen = gen1;
        return gen;
    }
    public static String getGen(){
        return gen;
    }

    public List<Anime> setAnime(String gen1){
        DB db = new DB(Cautare.this);
        List<Anime> anime = new ArrayList<>();
        anime = db.getCautareAnime(gen1);
        return anime;
    }
    public static List<Anime> getAnime(){
        return anime;
    }

    public static String setCautare(String c){
        cautare = c;
        return gen;
    }
    public static String getCautare(){
        return cautare;
    }

}
