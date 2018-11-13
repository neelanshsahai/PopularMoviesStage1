package com.udacity_and_projects.neelansh.popularmovies_stage1.Adapters;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.udacity_and_projects.neelansh.popularmovies_stage1.DataModels.Movie;
import com.udacity_and_projects.neelansh.popularmovies_stage1.R;

import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {

    private List<Movie> movies;
    private Context mContext;

    public GridAdapter(List<Movie> list, Context context) {
        this.movies = list;
        this.mContext = context;
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent,  false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, int position) {
        Movie movie = movies.get(position);
        holder.movieTitle.setText(movie.getTitle());
//        Glide.with(mContext).fromUri(movie.getPoster_path()).into(holder.posterThumb);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class GridViewHolder extends RecyclerView.ViewHolder {
        private ImageView posterThumb;
        private TextView movieTitle;
        public GridViewHolder(View itemView) {
            super(itemView);
            posterThumb = (ImageView) itemView.findViewById(R.id.grid_item_iv);
            movieTitle = (TextView) itemView.findViewById(R.id.grid_item_tv);
        }
    }
}
