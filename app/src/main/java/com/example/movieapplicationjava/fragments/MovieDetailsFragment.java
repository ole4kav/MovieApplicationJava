package com.example.movieapplicationjava.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.movieapplicationjava.R;
import com.example.movieapplicationjava.interfaces.MovieDetailsInterface;
import com.example.movieapplicationjava.models.Movie;
import com.example.movieapplicationjava.presenters.MovieDetailsPresenter;

public class MovieDetailsFragment extends Fragment implements MovieDetailsInterface.View {

    private ImageView ivMovieImage;
    private TextView tvTitle, tvYear, tvRating, tvGenre;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        MovieDetailsInterface.Presenter presenter = new MovieDetailsPresenter(this);

        if (getArguments() != null) {
            presenter.getMovie(getArguments());
        }

        initViews(view);
        presenter.setData();
    }


    private void initViews(View view) {
        ivMovieImage = view.findViewById(R.id.ivMovieImage);
        tvTitle = view.findViewById(R.id.tvTitle);
        tvYear = view.findViewById(R.id.tvYear);
        tvRating = view.findViewById(R.id.tvRating);
        tvGenre = view.findViewById(R.id.tvGenre);
    }

    @Override
    public void setData(Movie movie) {
        tvTitle.setText(movie.getTitle());
        tvYear.setText(String.valueOf(movie.getReleaseYear()));
        tvRating.setText(String.valueOf(movie.getRating()));


        StringBuilder genreList = new StringBuilder();

        for (String genre : movie.getGenreList()) {
            genreList.append(genre).append(", ");
        }

        tvGenre.setText(genreList.toString());

        loadImage(movie);
    }

    private void loadImage(Movie movie) {

        Glide.with(MovieDetailsFragment.this)
                .load(movie.getImageUrl())
                .override(400, 400)
                .into(ivMovieImage);
    }

}
