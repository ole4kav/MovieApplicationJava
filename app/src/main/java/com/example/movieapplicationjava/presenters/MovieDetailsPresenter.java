package com.example.movieapplicationjava.presenters;

import com.example.movieapplicationjava.interfaces.MovieDetailsInterface;
import com.example.movieapplicationjava.models.Movie;

import java.util.List;

public class MovieDetailsPresenter implements MovieDetailsInterface.Presenter {


    private MovieDetailsInterface.View view;


    public MovieDetailsPresenter(MovieDetailsInterface.View view) {
        this.view = view;
    }


    @Override
    public void setData(Movie movie) {
        view.setData(movie);
    }

    @Override
    public String buildGenreList(List<String> movieGenreList) {

        StringBuilder genreList = new StringBuilder();

        for (String genre : movieGenreList) {
            genreList.append(genre).append(", ");
        }

        return genreList.toString();
    }


}
