package com.example.movieapplicationjava.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.movieapplicationjava.R;
import com.example.movieapplicationjava.presenters.SplashPresenter;
import com.example.movieapplicationjava.interfaces.SplashInterface;
import com.example.movieapplicationjava.models.Movie;

import java.io.Serializable;
import java.util.List;

import static com.example.movieapplicationjava.fragments.MoviesFragment.KEY_MOVIES_LIST;


public class SplashActivity extends AppCompatActivity implements SplashInterface.View {

    private ProgressBar progressBar;
    private int progressStatus = 0;
    private TextView tvPercent;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        SplashInterface.Presenter presenter = new SplashPresenter(this);

        initViews();

        updateProgressBar();

        presenter.downloadJson();
    }

    private void updateProgressBar() {
        new Thread(() -> {
            while (progressStatus < 100) {
                progressStatus += 10;
                handler.post(() -> {
                    progressBar.setProgress(progressStatus);
                    tvPercent.setText(new StringBuilder().append(progressStatus).append(" %"));
                });
                try {
                    Thread.sleep(200); // Sleep for 200 milliseconds.
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void initViews() {
        tvPercent = findViewById(R.id.tvPercent);
        progressBar = findViewById(R.id.progressBar);
    }

    @Override
    public void openNextActivity(List<Movie> movieArrayList) {
        Intent intent = new Intent(this, MoviesActivity.class);
        intent.putExtra(KEY_MOVIES_LIST, (Serializable) movieArrayList);
        startActivity(intent);
        this.finish();
    }
}
