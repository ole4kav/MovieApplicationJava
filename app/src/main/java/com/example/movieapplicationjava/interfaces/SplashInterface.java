package com.example.movieapplicationjava.interfaces;

import com.example.movieapplicationjava.models.Movie;

import java.util.List;

public interface SplashInterface {

    interface View {
        void openNextActivity(List<Movie> movieArrayList);
    }

    interface Presenter {

        void downloadJson();

    }

    interface Model {

        void getMovieList(OnFinishedListener onFinishedListener);

        interface OnFinishedListener {

            void onFinished(List<Movie> movieArrayList);

            void onFailure(Throwable t);
        }
    }

}
