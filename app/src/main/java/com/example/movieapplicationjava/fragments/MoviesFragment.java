package com.example.movieapplicationjava.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movieapplicationjava.R;
import com.example.movieapplicationjava.adapters.MovieAdapter;
import com.example.movieapplicationjava.interfaces.MoviesFragmentInterface;
import com.example.movieapplicationjava.models.Movie;
import com.example.movieapplicationjava.presenters.MoviesFragmentPresenter;

import java.util.ArrayList;

public class MoviesFragment extends Fragment implements MoviesFragmentInterface.View {

    public static final String KEY_MOVIES_LIST = "movieList";

    private RecyclerView rvMoviesData;
    private MoviesFragmentInterface.Presenter presenter;

    public static Fragment newInstance(ArrayList<Movie> movieArrayList) {

        MoviesFragment moviesFragment = new MoviesFragment();
        Bundle args = new Bundle();
        args.putSerializable(KEY_MOVIES_LIST, movieArrayList);
        moviesFragment.setArguments(args);
        return moviesFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        presenter = new MoviesFragmentPresenter(this);

        if (getArguments() != null) {
            presenter.setMovieList((ArrayList<Movie>) getArguments().getSerializable(KEY_MOVIES_LIST));
        }

        initViews(view);
        initAdapters();
    }


    private void initViews(View view) {
        rvMoviesData = view.findViewById(R.id.rvMoviesData);
    }


    private void initAdapters() {
        MovieAdapter adapter = new MovieAdapter(presenter);
        rvMoviesData.setAdapter(adapter);
        rvMoviesData.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMoviesData.addItemDecoration(new DividerItemDecoration(rvMoviesData.getContext(), DividerItemDecoration.VERTICAL));
    }


    @Override
    public void openNextFragment (Movie movie) {
        FragmentTransaction ft = getFragmentManager() != null ? getFragmentManager().beginTransaction() : null;
        if (ft != null) {
            ft.replace(R.id.flMoviesFragment, getMovieDetailFragment(movie));
            ft.commit();
        }
    }

    private Fragment getMovieDetailFragment(Movie movie) {
         return MovieDetailsFragment.newInstance(movie);
    }


}
