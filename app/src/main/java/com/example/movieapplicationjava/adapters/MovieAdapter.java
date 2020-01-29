package com.example.movieapplicationjava.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.movieapplicationjava.R;
import com.example.movieapplicationjava.models.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private ArrayList<Movie> movieArrayList;
    private Context context;

    public MovieAdapter(ArrayList<Movie> movieArrayList) {
        this.movieArrayList = movieArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();

        View moviesView = LayoutInflater.from(context).inflate(R.layout.row_movies, parent, false);


        return new ViewHolder(moviesView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Movie movie = movieArrayList.get(position);

        // holder.tvRowNum.setText(String.valueOf(position+1));
        holder.tvTitle.setText(movie.getTitle());
        holder.tvRating.setText(String.valueOf(movie.getRating()));
        holder.tvYear.setText(String.valueOf(movie.getReleaseYear()));

        StringBuilder genreList = new StringBuilder();

        for (String genre : movie.getGenreList()) {
            genreList.append(genre).append(", ");
        }

        holder.tvGenre.setText(genreList.toString());

        loadImage(movie.getImageUrl(), holder);

        //holder.itemView.setOnClickListener(v -> view.openNextFragment(movie));

    }

    private void loadImage(String imageUrl, @NonNull MovieAdapter.ViewHolder holder) {

        Glide.with(context)
                .load(imageUrl)
                .override(200, 200)
                .into(holder.ivMovieImage);
    }


    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivMovieImage;
        private TextView tvTitle, tvYear, tvRating, tvGenre, tvRowNum;


        ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRowNum = itemView.findViewById(R.id.tvRowNum);
            ivMovieImage = itemView.findViewById(R.id.ivMovieImage);
            tvTitle = itemView.findViewById(R.id.tvTitle);
            tvYear = itemView.findViewById(R.id.tvYear);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvGenre = itemView.findViewById(R.id.tvGenre);
        }

    }

}
