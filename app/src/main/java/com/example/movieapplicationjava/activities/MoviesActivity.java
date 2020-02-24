package com.example.movieapplicationjava.activities;

import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.movieapplicationjava.R;
import com.example.movieapplicationjava.fragments.MoviesFragment;
import com.example.movieapplicationjava.interfaces.MovieInterface;
import com.example.movieapplicationjava.models.Movie;
import com.example.movieapplicationjava.presenters.MoviePresenter;

import java.util.ArrayList;

import static com.example.movieapplicationjava.fragments.MoviesFragment.KEY_MOVIES_LIST;

public class MoviesActivity extends FragmentActivity implements MovieInterface.View {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        MovieInterface.Presenter presenter = new MoviePresenter(this);
        presenter.startActivity();

    }

    @SuppressWarnings("unchecked")
    @Override
    public void openFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flMoviesFragment,
                MoviesFragment.newInstance((ArrayList<Movie>) getIntent().getSerializableExtra(KEY_MOVIES_LIST)));
        ft.commit();
    }
}
