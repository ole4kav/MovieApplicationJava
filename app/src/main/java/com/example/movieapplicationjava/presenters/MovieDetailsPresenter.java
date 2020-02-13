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


        // TODO: 2020-02-14 DO NOT COPY AND PASTE CODE!
        //  These 5 lines of code also exist in onBindViewHolder method of the MovieAdapter (Read the note I wrote there about what to do)
        StringBuilder genreList = new StringBuilder();

        for (String genre : movieGenreList) {
            genreList.append(genre).append(", ");
        }

        return genreList.toString();
    }


}
