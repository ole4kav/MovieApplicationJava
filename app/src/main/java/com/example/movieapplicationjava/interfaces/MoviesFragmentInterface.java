package com.example.movieapplicationjava.interfaces;

import com.example.movieapplicationjava.models.Movie;

import java.util.ArrayList;

public interface MoviesFragmentInterface {

    interface View {

        void openNextFragment(Movie movie);
    }

    interface Presenter {

        void setMovieList(ArrayList<Movie> movieArrayList);

        ArrayList<Movie> getSortedMovieList();

        void openNextFragment(Movie movie);

    }

}
