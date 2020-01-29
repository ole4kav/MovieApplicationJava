package com.example.movieapplicationjava.presenters;

import com.example.movieapplicationjava.interfaces.MovieInterface;

public class MoviePresenter implements MovieInterface.Presenter {

    private MovieInterface.View view;

    public MoviePresenter(MovieInterface.View view) {
        this.view = view;
    }


    @Override
    public void startActivity() {
        view.openFragment();
    }

}
