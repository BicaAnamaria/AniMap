package com.example.app.Cautare;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.app.Anime;
import com.example.app.DB.DB;
import com.example.app.Lista.Lista;
import com.example.app.Principal.MainActivity;
import com.example.app.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AS2 extends AppCompatActivity {


    DB db;
    Anime anime = null;
    TextView myText1, myText2, myText3, myText4;
    ImageView myimg;
    RatingBar ratingBar;
    TextView listView;
    EditText editText;
    FloatingActionButton floatingActionButton;
    Button button, button1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.anime);

        BottomNavigationView bnv = findViewById(R.id.nav_view);

        bnv.setSelectedItemId(R.id.navigation_cautare);
        db = new DB(AS2.this);

        anime = db.getAnimeSpecific(RezultateCautare.getPos());


        this.myText1 = findViewById(R.id.textView2);
        this.myimg = findViewById(R.id.imageView2);
        this.myText2 = findViewById(R.id.textView3);
        this.myText3 = findViewById(R.id.textView4);
        this.myText4 = findViewById(R.id.textView5);

        this.listView = findViewById(R.id.textView6);
        this.ratingBar = findViewById(R.id.simpleRatingBar);
        this.editText = findViewById(R.id.editTextTextPersonName5);
        floatingActionButton = findViewById(R.id.floatingActionButton7);
        this.button1 = findViewById(R.id.button7);
        button = findViewById(R.id.button2);
        if(!anime.isAdaugat()){
            button.setText(R.string.Adauga);
        }
        else{
            button.setText(R.string.Adaugat);
        }
        button.setOnClickListener(v -> {
            if(!anime.isAdaugat()) {
                button.setText(R.string.Adaugat);
                db.setAdaugat(anime.getName());
            }
            else{
                button.setText(R.string.Adauga);
                db.setNeAdaugat(anime.getName());
            }

        });

        button1.setOnClickListener(v -> {
            float r = ratingBar.getRating() ;
            db.setRating(r,anime.getName(),anime.getRating());


        });

        floatingActionButton.setOnClickListener(v -> {

            Intent i1 = new Intent(getApplicationContext(), RezultateCautare.class);
            startActivity(i1);
            finish();
            overridePendingTransition(0, 0);

        });



        myText1.setText(String.format("%s%s", "Nume : ", anime.getName()));
        myimg.setImageResource( anime.getImg());
        myText2.setText(String.format("Descriere : %s", anime.getDescription()));
        myText3.setText(String.format("Gen : %s", anime.getGen()));
        myText4.setText(String.format("Studio : %s", anime.getStudio()));
        listView.setText(String.format("/%s", anime.getNb_episode()));
        if(anime.getNb_episode()!=0) {
            listView.setText(String.format("/%s", anime.getNb_episode()));
        }
        else{
            listView.setText(String.format("/%s", "?"));
        }
        ratingBar.setRating(anime.getRating());

        bnv.setOnNavigationItemSelectedListener(item -> {

            switch (item.getItemId()) {

                case R.id.navigation_home: {
                    Intent i1 = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i1);
                    finish();
                    overridePendingTransition(0, 0);
                    return true;


                }


                case R.id.navigation_cautare: {
                    Intent i1 = new Intent(getApplicationContext(), Cautare.class);
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

                }
            }
            return false;

        });

    }



}
