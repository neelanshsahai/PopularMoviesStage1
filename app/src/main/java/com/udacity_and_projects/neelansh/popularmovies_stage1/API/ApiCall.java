package com.udacity_and_projects.neelansh.popularmovies_stage1.API;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.udacity_and_projects.neelansh.popularmovies_stage1.API_KEY;
import com.udacity_and_projects.neelansh.popularmovies_stage1.DataModels.Movie;
import com.udacity_and_projects.neelansh.popularmovies_stage1.DataModels.MoviesResult;
import com.udacity_and_projects.neelansh.popularmovies_stage1.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiCall {

    private Context mContext;
    private List<Movie> popularMovies;
    private List<Movie> topRatedMovies;
    private String key = API_KEY.SECRET_API_KEY;

    public ApiCall(Context context) {
        this.mContext = context;
        Log.e("dlirfboik", "constructor");
    }

    public List<Movie> getPopularMoviesResponses() {

        Log.e("idufb", "popular");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mContext.getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<MoviesResult> popularMoviesCall = api.getPopularMovies(key);

        popularMoviesCall.enqueue(new Callback<MoviesResult>() {
            @Override
            public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {
                popularMovies = response.body().getResults();
                Log.e("skebfn", "onResponse");
            }

            @Override
            public void onFailure(Call<MoviesResult> call, Throwable t) {
                // Show error
//                Toast.makeText(mContext, mContext.getString(R.string.error_msg), Toast.LENGTH_SHORT).show();
                Log.e("sldnvn", t.toString());
            }
        });

        return popularMovies;
    }

    public List<Movie> getTopRatedMoviesResponses() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mContext.getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);

        Call<MoviesResult> topRatedMoviesCall = api.getTopRatedMovies(key);

        topRatedMoviesCall.enqueue(new Callback<MoviesResult>() {
            @Override
            public void onResponse(Call<MoviesResult> call, Response<MoviesResult> response) {
                topRatedMovies = response.body().getResults();
            }

            @Override
            public void onFailure(Call<MoviesResult> call, Throwable t) {
                // Show error
                Toast.makeText(mContext, mContext.getString(R.string.error_msg), Toast.LENGTH_SHORT).show();
            }
        });

        return topRatedMovies;
    }
}
