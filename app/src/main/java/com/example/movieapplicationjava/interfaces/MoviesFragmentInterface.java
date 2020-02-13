package com.example.movieapplicationjava.interfaces;

import com.example.movieapplicationjava.models.Movie;

import java.util.ArrayList;

public interface MoviesFragmentInterface {

    interface View {

        void openNextFragment(Movie movie);
    }

    interface Presenter {

        // TODO: 2020-02-13 you need to split this method to two different methods
        //  first for saving the data list ->  void setMovieList(ArrayList<Movie> movieArrayList)
        //  Second for retrieving the data list ->  ArrayList<Movie> getSortedMovieList()
        ArrayList<Movie> sortMovieList(ArrayList<Movie> movieArrayList);

        void openNextFragment(Movie movie);

    }

}
