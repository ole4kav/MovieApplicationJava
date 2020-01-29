package com.example.movieapplicationjava.interfaces;

import com.example.movieapplicationjava.models.Movie;

import java.util.ArrayList;

public interface MoviesFragmentInterface {

    interface View {

        void openNextFragment(Movie movie);
    }

    interface Presenter {

        ArrayList<Movie> sortMovieList(ArrayList<Movie> movieArrayList);

        void openNextFragment(Movie movie);

    }

}
