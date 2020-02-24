package com.example.movieapplicationjava.presenters;

import com.example.movieapplicationjava.interfaces.SplashInterface;
import com.example.movieapplicationjava.models.Movie;
import com.example.movieapplicationjava.models.SplashModel;

import java.util.List;

public class SplashPresenter implements SplashInterface.Presenter, SplashInterface.Model.OnFinishedListener {

    private SplashInterface.View view;
    private SplashInterface.Model model;

    public SplashPresenter(SplashInterface.View view) {
        this.view = view;
        model = new SplashModel();
    }

    @Override
    public void downloadJson() {
        model.getMovieList(this);
    }

    @Override
    public void onFinished(List<Movie> movieArrayList) {
        view.openNextActivity(movieArrayList);
    }

    @Override
    public void onFailure(Throwable t) {
        t.getMessage();
    }
}
