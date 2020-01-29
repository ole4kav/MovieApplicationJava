package com.example.movieapplicationjava.interfaces;

import android.os.Bundle;

import com.example.movieapplicationjava.models.Movie;

public interface MovieDetailsInterface {

    interface View {

        void setData(Movie movie);
    }

    interface Presenter {

        void getMovie(Bundle args);
        void setData();
    }

}
