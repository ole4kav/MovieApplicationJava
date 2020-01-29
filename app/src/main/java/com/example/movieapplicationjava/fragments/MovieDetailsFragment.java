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

    public static final String KEY_MOVIE = "movie";

    MovieDetailsInterface.Presenter presenter;

    private ImageView ivMovieImage;
    private TextView tvTitle, tvYear, tvRating, tvGenre;
    private Movie movie;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        presenter = new MovieDetailsPresenter(this);

        if (getArguments() != null) {
            movie = getArguments().getParcelable(KEY_MOVIE);
        }

        initViews(view);
        presenter.setData(movie);
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
        tvGenre.setText(presenter.buildGenreList(movie.getGenreList()));

        loadImage(movie);
    }

    private void loadImage(Movie movie) {

        Glide.with(MovieDetailsFragment.this)
                .load(movie.getImageUrl())
                .override(400, 400)
                .into(ivMovieImage);
    }

}
