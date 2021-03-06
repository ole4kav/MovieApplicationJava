package com.example.movieapplicationjava.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.movieapplicationjava.R;
import com.example.movieapplicationjava.interfaces.MovieDetailsInterface;
import com.example.movieapplicationjava.models.Movie;
import com.example.movieapplicationjava.presenters.MovieDetailsPresenter;

public class MovieDetailsFragment extends Fragment implements MovieDetailsInterface.View {

    private static final String KEY_MOVIE = "movie";

    private ImageView ivMovieImage;
    private TextView tvTitle, tvYear, tvRating, tvGenre, tvTitleDescription, tvYearDescription, tvGenreDescription;


    static Fragment newInstance(Movie movie) {
        MovieDetailsFragment movieDetailsFragment = new MovieDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(KEY_MOVIE, movie);
        movieDetailsFragment.setArguments(args);
        return movieDetailsFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        MovieDetailsInterface.Presenter presenter = new MovieDetailsPresenter(this);

        initViews(view);

        if (getArguments() != null) {
            presenter.setData(getArguments().getParcelable(KEY_MOVIE));
        }
    }


    private void initViews(View view) {
        ivMovieImage = view.findViewById(R.id.ivMovieImage);
        tvRating = view.findViewById(R.id.tvRating);

        LinearLayout llTitle = view.findViewById(R.id.llTitle);
        tvTitle = llTitle.findViewById(R.id.tvTitle);
        tvTitleDescription = llTitle.findViewById(R.id.tvDescription);

        LinearLayout llYear = view.findViewById(R.id.llYear);
        tvYear = llYear.findViewById(R.id.tvTitle);
        tvYearDescription = llYear.findViewById(R.id.tvDescription);

        LinearLayout llGenre = view.findViewById(R.id.llGenre);
        tvGenre = llGenre.findViewById(R.id.tvTitle);
        tvGenreDescription = llGenre.findViewById(R.id.tvDescription);
    }

    @Override
    public void setData(Movie movie) {
        tvTitle.setText(getString(R.string.movie_name_title));
        tvTitleDescription.setText(movie.getTitle());
        tvYear.setText(getString(R.string.movie_release_year_title));
        tvYearDescription.setText(String.valueOf(movie.getReleaseYear()));
        tvGenre.setText(getString(R.string.movie_genre_title));
        tvGenreDescription.setText(movie.getGenreListAsString());

        tvRating.setText(String.valueOf(movie.getRating()));

        loadImage(movie);
    }

    private void loadImage(Movie movie) {

        Glide.with(MovieDetailsFragment.this)
                .load(movie.getImageUrl())
                .into(ivMovieImage);
    }

}
