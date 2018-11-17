package com.udacity_and_projects.neelansh.popularmovies_stage1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.udacity_and_projects.neelansh.popularmovies_stage1.DataModels.Movie;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Movie movie = (Movie) getIntent().getSerializableExtra(getString(R.string.movIntentExtraKey));

        ImageView posterIv = (ImageView) findViewById(R.id.detail_poster);
        TextView releaseDateTv = (TextView) findViewById(R.id.detail_date);
        TextView ratingsTv = (TextView) findViewById(R.id.detail_ratings);
        TextView synopsisTv = (TextView) findViewById(R.id.detail_synopsis);

        Glide.with(this).load(getString(R.string.base_poster_url)+movie.getPoster_path()).into(posterIv);
        releaseDateTv.setText(movie.getRelease_date());
        ratingsTv.setText(movie.getVote_average()+"/10");
        synopsisTv.setText(movie.getOverview());

        DetailActivity.this.setTitle(movie.getTitle());
    }
}
