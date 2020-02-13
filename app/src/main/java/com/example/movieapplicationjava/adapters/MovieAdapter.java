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
import com.example.movieapplicationjava.interfaces.MoviesFragmentInterface;
import com.example.movieapplicationjava.models.Movie;

import java.util.ArrayList;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.ViewHolder> {

    private ArrayList<Movie> movieArrayList;
    private Context context; // // TODO: 2020-02-13 DO NOT SAVE CONTEXT AS PROPERTY (Do everything to avoid it)
    private MoviesFragmentInterface.Presenter presenter;

    public MovieAdapter(ArrayList<Movie> movieArrayList, MoviesFragmentInterface.Presenter presenter) {
        // TODO: 2020-02-13 the data should be in the presenter
        // this.movieArrayList = presenter.getSortedMovieList();

        this.movieArrayList = movieArrayList;
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        context = parent.getContext();

        // TODO: 2020-02-13 to avoid using context, you could use this
        //  View moviesView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_movies, parent, false);
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
        // TODO: 2020-02-13 this is the 'logic' of the Movie item. so this should be in the Movie object
        //  and use it like this:
        // holder.tvGenre.setText(movie.getGenreListAsString());
        holder.tvGenre.setText(genreList.toString());

        loadImage(movie.getImageUrl(), holder);

        holder.itemView.setOnClickListener(v -> presenter.openNextFragment(movie));

    }

    private void loadImage(String imageUrl, @NonNull MovieAdapter.ViewHolder holder) {

        // TODO: 2020-02-13 to avoid using context, you could use this
        //  Glide.with(holder.ivMovieImage.getContext()).load(imageUrl).override(200, 200).into(holder.ivMovieImage);
        Glide.with(context)
                .load(imageUrl)
                .override(200, 200)
                .into(holder.ivMovieImage);
    }


    @Override
    public int getItemCount() {
        return movieArrayList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {

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
