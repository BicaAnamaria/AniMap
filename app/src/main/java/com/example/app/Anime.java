package com.example.app;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Anime {

    private int id;
    private String name ;
    private String description;
    private float rating ;
    private int nr_episode;
    private String studio;
    private String gen;
    private int img;
    private boolean adaugat;
    private int ep_curent;

    public Anime() {
    }

    public Anime(int id,String name, String description, int nr_episode, String gen , float rating,String studio,int img, boolean a, int ep) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.rating = rating;
        this.nr_episode = nr_episode;
        this.gen= gen;
        this.studio = studio;
        this.img = img;
        this.adaugat = a;
        this.ep_curent = ep;
    }

    public int getEp_curent() {
        return ep_curent;
    }

    public void setEp_curent(int ep_curent) {
        this.ep_curent = ep_curent;
    }

    public boolean isAdaugat() {
        return adaugat;
    }

    public void setAdaugat(boolean adaugat) {
        this.adaugat = adaugat;
    }

    public String getGen() {
        return gen;
    }

    public void setGen(String gen) {
        this.gen = gen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getNr_episode() {
        return nr_episode;
    }

    public void setNr_episode(int nr_episode) {
        this.nr_episode = nr_episode;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getRating() {
        return rating;
    }

    public int getNb_episode() {
        return nr_episode;
    }

    public void modStare(boolean id){
        this.adaugat = id;
    }

    public String getStudio() {
        return studio;
    }


    public void setName(String name) {
        this.name = name;
    }
    public void setEp(int ep) {
        this.ep_curent = ep;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setNb_episode(int nr_episode) {
        this.nr_episode = nr_episode;
    }


    public void setStudio(String studio) {
        this.studio = studio;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", nr_episode=" + nr_episode +
                ", studio='" + studio + '\'' +
                ", gen='" + gen + '\'' +
                ", img=" + img +
                ", adaugat=" + adaugat +
                '}';
    }
}
