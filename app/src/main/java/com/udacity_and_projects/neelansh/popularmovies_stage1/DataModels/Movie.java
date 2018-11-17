package com.udacity_and_projects.neelansh.popularmovies_stage1.DataModels;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Movie implements Serializable {

    @SerializedName("vote_average") private float vote_average;
    @SerializedName("title") private String title;
    @SerializedName("original_title") private String original_title;
    @SerializedName("poster_path") private String poster_path;
    @SerializedName("overview") private String overview;
    @SerializedName("release_date") private String release_date;

    public Movie(float vote_average, String title, String original_title, String poster_path,
                 String overview, String release_date) {
        this.vote_average = vote_average;
        this.title = title;
        this.original_title = original_title;
        this.poster_path = poster_path;
        this.overview = overview;
        this.release_date = release_date;
    }

    public float getVote_average() { return vote_average; }

    public void setVote_average(float vote_average) { this.vote_average = vote_average; }

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getOriginal_title() { return original_title; }

    public void setOriginal_title(String original_title) { this.original_title = original_title; }

    public String getPoster_path() { return poster_path; }

    public void setPoster_path(String poster_path) { this.poster_path = poster_path; }

    public String getOverview() { return overview; }

    public void setOverview(String overview) { this.overview = overview; }

    public String getRelease_date() { return release_date; }

    public void setRelease_date(String release_date) { this.release_date = release_date; }
}
