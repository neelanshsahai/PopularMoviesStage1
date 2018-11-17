package com.udacity_and_projects.neelansh.popularmovies_stage1.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.udacity_and_projects.neelansh.popularmovies_stage1.DataModels.Movie;
import com.udacity_and_projects.neelansh.popularmovies_stage1.DetailActivity;
import com.udacity_and_projects.neelansh.popularmovies_stage1.R;

import java.util.List;

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.GridViewHolder> {

    private Context mContext;
    private List<Movie> movies;
//    private OnGridItemClickListener mListener;

    public GridAdapter(Context mContext, List<Movie> movies) {
        this.mContext = mContext;
        this.movies = movies;
//        this.mListener = listener;
    }

    @Override

    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.card_item, parent, false);
        return new GridViewHolder(v);
    }

    @Override
    public void onBindViewHolder(GridViewHolder holder, final int position) {
        holder.title.setText(movies.get(position).getTitle());
        Glide.with(mContext)
                .load(mContext.getString(R.string.base_poster_url)+movies.get(position).getPoster_path())
                .into(holder.posterThumb);
        holder.cv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(mContext, DetailActivity.class);
                i.putExtra(mContext.getString(R.string.movIntentExtraKey), movies.get(position));
                mContext.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class GridViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        ImageView posterThumb;
        CardView cv;
//        private OnGridItemClickListener mListener;

        public GridViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.grid_item_tv);
            posterThumb = (ImageView) itemView.findViewById(R.id.grid_item_iv);
            cv = (CardView) itemView.findViewById(R.id.cv);
        }
//
//        @Override
//        public void onClick(View v) {
//            mListener.onClick(v, getAdapterPosition());
//        }
    }
}
