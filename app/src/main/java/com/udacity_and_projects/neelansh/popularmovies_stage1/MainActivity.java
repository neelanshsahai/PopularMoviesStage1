package com.udacity_and_projects.neelansh.popularmovies_stage1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.mainPageGridView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(getResources().getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<MoviesResult> popularMoviesCall = api.getPopularMovies(key);

        popularMoviesCall.enqueue(new Callback<MoviesResult>() {
            @Override
            public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {
                movies = response.body().getResults();
//                OnGridItemClickListener listener = new OnGridItemClickListener() {
//                    @Override
//                    public void onClick(View v, int position) {
//                        Log.e("skdbf", ""+position);
//                    }
//                };
                GridAdapter mGridAdapter = new GridAdapter(MainActivity.this, movies);
                recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
                recyclerView.setAdapter(mGridAdapter);
            }

            @Override
            public void onFailure(Call<MoviesResult> call, Throwable t) { }
        });
    }
}
