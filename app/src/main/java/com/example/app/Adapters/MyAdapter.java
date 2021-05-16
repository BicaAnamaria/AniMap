package com.example.app.Adapters;
import com.example.app.Anime;
import com.example.app.Cautare.RezultateCautare;
import com.example.app.R;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public  class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {


    Context context;
    private List<Anime> anime;
    private onAnimeListener onAnimeListener;

    public MyAdapter(List<Anime> anime, onAnimeListener onAnimeListener) {//List<String> s1, List<String> s2, List<Integer> img, List<Integer> i, List<String> s3, List<String> s4,List<Float> s5,List<Integer> ad, List<Integer> ep, onAnimeListener onAnimeListener){
       /* this.context=ct;
        this.data1 = s1;
        this.data2=s2;
        this.data3=s3;
        this.data4=s4;
        this.images=img;
        this.f=s5;
        this.nr=i;
        this.ad = ad;
        this.ep = ep;*/
        this.anime = anime;
        this.onAnimeListener = onAnimeListener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.anime_list,parent,false);
        return new MyViewHolder(view, onAnimeListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(anime.get(position).getName());
        holder.myimg.setImageResource(anime.get(position).getImg());


    }

    @Override
    public int getItemCount() {

        return anime.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {



        TextView myText1;
        ImageView myimg;
        ConstraintLayout constraintLayout;
        Context context;
        onAnimeListener onAnimeListener;


        public MyViewHolder(View itemView, onAnimeListener onAnimeListener) {
            super(itemView);
            this.myText1 = itemView.findViewById(R.id.nume_anime);
            this.myimg = itemView.findViewById(R.id.imageView);
            //constraintLayout = itemView.findViewById(R.id.layout1);
            this.onAnimeListener = onAnimeListener;
            myimg.setOnClickListener(this);
            myText1.setOnClickListener(this);
            itemView.setOnClickListener(this);/*new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    if(pos!= RecyclerView.NO_POSITION){
                        data1 = Collections.singletonList(data1.get(pos));
                        Intent intent = new Intent(context,AnimeSpecific.class);
                        intent.putExtra(String.valueOf(R.id.imageView2), images.get(pos));
                        context.startActivity(intent);


                    }
                }
            });*/

        }

        @Override
        public void onClick(View v) {
            int pos = getAdapterPosition();
            onAnimeListener.onAnimeClick(pos);
        }
    }
    public interface  onAnimeListener{
        void onAnimeClick(int position);
    }
}
