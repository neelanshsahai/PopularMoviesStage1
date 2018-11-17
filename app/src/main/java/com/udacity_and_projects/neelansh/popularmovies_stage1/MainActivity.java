package com.udacity_and_projects.neelansh.popularmovies_stage1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.udacity_and_projects.neelansh.popularmovies_stage1.API.Api;
import com.udacity_and_projects.neelansh.popularmovies_stage1.Adapters.GridAdapter;
import com.udacity_and_projects.neelansh.popularmovies_stage1.DataModels.Movie;
import com.udacity_and_projects.neelansh.popularmovies_stage1.DataModels.MoviesResult;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private List<Movie> movies;
    private String key = API_KEY.SECRET_API_KEY;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.mainPageGridView);
        updateGrid("POPULAR");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.top_rated:
                //Update the View
                updateGrid("TOP RATED");
                break;
            case R.id.most_popular:
                //Update the View
                updateGrid("POPULAR");
                break;
        }
        return true;
    }

    public void updateGrid(String s) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        if (s.equals("POPULAR")) {
            Call<MoviesResult> call = api.getPopularMovies(key);
            call.enqueue(new Callback<MoviesResult>() {
                @Override
                public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {
                    movies = response.body().getResults();
                    GridAdapter mGridAdapter = new GridAdapter(MainActivity.this, movies);
                    recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                    recyclerView.setAdapter(mGridAdapter);
                }

                @Override
                public void onFailure(Call<MoviesResult> call, Throwable t) { }
            });
        } else if (s.equals("TOP RATED")) {
            Call<MoviesResult> call = api.getTopRatedMovies(key);
            call.enqueue(new Callback<MoviesResult>() {
                @Override
                public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {
                    movies = response.body().getResults();
                    GridAdapter mGridAdapter = new GridAdapter(MainActivity.this, movies);
                    recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                    recyclerView.setAdapter(mGridAdapter);
                }

                @Override
                public void onFailure(Call<MoviesResult> call, Throwable t) {
                }
            });
        }
    }

/*

    public List<Movie> getMovies(String s) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        Call<MoviesResult> call = api.getPopularMovies(key);
        if (s.equals("POPULAR")) {
            call = api.getPopularMovies(key);
        } else if(s.equals("TOP RATED")) {
            call = api.getTopRatedMovies(key);
        }

        call.enqueue(new Callback<MoviesResult>() {
            @Override
            public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {
                movies = response.body().getResults();
            }

            @Override
            public void onFailure(Call<MoviesResult> call, Throwable t) { }
        });

        return movies;
    }

    public void updateGrid(List<Movie> movieList) {
        GridAdapter mGridAdapter = new GridAdapter(MainActivity.this, movieList);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        recyclerView.setAdapter(mGridAdapter);
    }
*/
}
