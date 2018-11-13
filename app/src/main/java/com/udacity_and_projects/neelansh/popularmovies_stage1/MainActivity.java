package com.udacity_and_projects.neelansh.popularmovies_stage1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.udacity_and_projects.neelansh.popularmovies_stage1.API.ApiCall;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, (new ApiCall(this)).getPopularMoviesResponses().get(0).getTitle(), Toast.LENGTH_SHORT).show();
    }
}
