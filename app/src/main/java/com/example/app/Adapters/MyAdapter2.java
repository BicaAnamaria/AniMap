package com.example.app.Adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.app.Anime;
import com.example.app.Cautare.RezultateCautare;
import com.example.app.R;

import java.util.List;

public class MyAdapter2 extends RecyclerView.Adapter<MyAdapter2.MyAdapterViewHolder> {

    private Anime anime;
    Activity activity;
    private MyAdapter.onAnimeListener onAnimeListener;


    public MyAdapter2(Anime anime){
        this.onAnimeListener = onAnimeListener;
        this.anime = anime;
    }


    @NonNull

    @Override
    public MyAdapter2.MyAdapterViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.anime,parent,false);
        return new MyAdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter2.MyAdapterViewHolder holder, int position) {

        holder.myText1.setText(anime.getName());
        holder.myimg.setImageResource(anime.getImg());
        holder.myText2.setText(anime.getDescription());
        holder.myText3.setText(anime.getGen());
        holder.myText4.setText(anime.getStudio());
    }

    @Override
    public int getItemCount() {
        return 1;
    }
    public static class MyAdapterViewHolder extends RecyclerView.ViewHolder {

        TextView myText1, myText2, myText3, myText4;
        ImageView myimg;

        public MyAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
            this.myText1 = itemView.findViewById(R.id.textView2);
            this.myimg = itemView.findViewById(R.id.imageView2);
            this.myText2 = itemView.findViewById(R.id.textView3);
            this.myText3 = itemView.findViewById(R.id.textView4);
            this.myText4 = itemView.findViewById(R.id.textView5);

        }

    }


}
