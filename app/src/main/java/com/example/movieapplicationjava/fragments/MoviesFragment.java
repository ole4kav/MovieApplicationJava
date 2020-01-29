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
import com.example.movieapplicationjava.activities.MoviesActivity;
import com.example.movieapplicationjava.adapters.MovieAdapter;
import com.example.movieapplicationjava.interfaces.MoviesFragmentInterface;
import com.example.movieapplicationjava.models.Movie;
import com.example.movieapplicationjava.presenters.MoviesFragmentPresenter;

import java.util.ArrayList;

import static com.example.movieapplicationjava.presenters.MovieDetailsPresenter.KEY_MOVIE;

public class MoviesFragment extends Fragment implements MoviesFragmentInterface.View {

    private RecyclerView rvMoviesData;

    public static final String KEY_MOVIES_LIST = "movieList";
    private ArrayList<Movie> movieArrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_movies, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        MoviesFragmentInterface.Presenter presenter = new MoviesFragmentPresenter(this);

        MoviesActivity activity = (MoviesActivity) getActivity();

        movieArrayList = (ArrayList<Movie>) activity.getIntent().getSerializableExtra(KEY_MOVIES_LIST);

        movieArrayList = presenter.sortMovieList(movieArrayList);

        initViews(view);
        initAdapters();
    }


    private void initViews(View view) {
        rvMoviesData = view.findViewById(R.id.rvMoviesData);
    }


    private void initAdapters() {
        MovieAdapter adapter = new MovieAdapter(movieArrayList);
        rvMoviesData.setAdapter(adapter);
        rvMoviesData.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMoviesData.addItemDecoration(new DividerItemDecoration(rvMoviesData.getContext(), DividerItemDecoration.VERTICAL));
    }


    @Override
    public void openNextFragment (Movie movie) {
        FragmentTransaction ft = getFragmentManager() != null ? getFragmentManager().beginTransaction() : null;
        if (ft != null) {
            ft.replace(R.id.flMoviesFragment, setArguments(movie));
            ft.addToBackStack(null);
            ft.commit();
        }
    }

    private Fragment setArguments(Movie movie) {
        MovieDetailsFragment movieDetailsFragment = new MovieDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(KEY_MOVIE, movie);
        movieDetailsFragment.setArguments(args);
        return movieDetailsFragment;
    }




}
