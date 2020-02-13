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

import static com.example.movieapplicationjava.fragments.MovieDetailsFragment.KEY_MOVIE;

public class MoviesFragment extends Fragment implements MoviesFragmentInterface.View {

    private RecyclerView rvMoviesData;
    private MoviesFragmentInterface.Presenter presenter;

    public static final String KEY_MOVIES_LIST = "movieList";
    private ArrayList<Movie> movieArrayList; // TODO: 2020-02-13 you don't need this if you don't use it in the fragment (could be in the presenter)


    // TODO: 2020-02-13 ->  BEST PRACTICE:
    //  Creating all of the instances of each fragment inside the fragment.
    //  So, only within the Fragment you call 'new Fragment()'
    //  you can use this:
    /*
    public static Fragment newInstance() {
        return new MoviesFragment();
    }
     */
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movies, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        presenter = new MoviesFragmentPresenter(this);

        // TODO: 2020-02-13 You should get the data from the Bundle of the current Fragment and not from the Bundle of the Activity.
        //  One of the Fragments advantage is the Fragment can be reuse in different activities.
        //  That's why you don't want to call the Activity explicitly in the fragment (in this case MoviesActivity)
        MoviesActivity activity = (MoviesActivity) getActivity();

        // TODO: 2020-02-13 You should save the data in the presenter
        //  presenter.setMovieList((ArrayList<Movie>) activity.getIntent().getSerializableExtra(KEY_MOVIES_LIST));
        movieArrayList =
                presenter.sortMovieList((ArrayList<Movie>) activity.getIntent().getSerializableExtra(KEY_MOVIES_LIST));


        initViews(view);
        initAdapters();
    }


    private void initViews(View view) {
        rvMoviesData = view.findViewById(R.id.rvMoviesData);
    }


    private void initAdapters() {
        MovieAdapter adapter = new MovieAdapter(movieArrayList, presenter);
        rvMoviesData.setAdapter(adapter);
        rvMoviesData.setLayoutManager(new LinearLayoutManager(getContext()));
        rvMoviesData.addItemDecoration(new DividerItemDecoration(rvMoviesData.getContext(), DividerItemDecoration.VERTICAL));
    }


    @Override
    public void openNextFragment (Movie movie) {
        FragmentTransaction ft = getFragmentManager() != null ? getFragmentManager().beginTransaction() : null;
        if (ft != null) {
            ft.replace(R.id.flMoviesFragment, setArguments(movie)); // TODO: 2020-02-13 Here, its not clear what the 'setArgument()' method do
            ft.addToBackStack(null);
            ft.commit();
        }
    }

    /* TODO: 2020-02-13 check this 
     *  The name of the Method should explain what the method does.
     *  So I suggest to call it 'getMovieDetailFragment(Movie movie)'
     */
    private Fragment setArguments(Movie movie) {
        // TODO: 2020-02-13 use static function in the fragment to create instance of the fragment (see example in the fragment)
        //  you can use this:
        /*
         * Fragment fragment = MovieDetailsFragment.newInstance(movie);
         * return fragment;
         */

        MovieDetailsFragment movieDetailsFragment = new MovieDetailsFragment();
        Bundle args = new Bundle();
        args.putParcelable(KEY_MOVIE, movie);
        movieDetailsFragment.setArguments(args);
        return movieDetailsFragment;
    }


}
