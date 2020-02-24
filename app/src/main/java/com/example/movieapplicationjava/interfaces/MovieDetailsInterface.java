package com.example.movieapplicationjava.interfaces;

import com.example.movieapplicationjava.models.Movie;

public interface MovieDetailsInterface {

    interface View {

        void setData(Movie movie);
    }

    interface Presenter {

        void setData(Movie movie);
    }

}
