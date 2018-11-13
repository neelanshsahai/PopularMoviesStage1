package com.udacity_and_projects.neelansh.popularmovies_stage1.API;

import com.udacity_and_projects.neelansh.popularmovies_stage1.DataModels.MoviesResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("popular")
    Call<MoviesResult> getPopularMovies(@Query("api_key") String key);

    @GET("top_rated")
    Call<MoviesResult> getTopRatedMovies(@Query("api_key") String key);
}
