package com.example.movieapplicationjava.activities;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.movieapplicationjava.R;
import com.example.movieapplicationjava.fragments.MoviesFragment;
import com.example.movieapplicationjava.interfaces.MovieInterface;
import com.example.movieapplicationjava.presenters.MoviePresenter;

public class MoviesActivity extends FragmentActivity implements MovieInterface.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        MovieInterface.Presenter presenter = new MoviePresenter(this);
        presenter.startActivity();

    }

    @Override
    public void openFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flMoviesFragment, MoviesFragment.newInstance());
        ft.commit();
    }
}
