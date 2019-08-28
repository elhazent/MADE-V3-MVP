package com.elhazent.education.madev3.ui.detail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.elhazent.education.madev3.BuildConfig;
import com.elhazent.education.madev3.R;
import com.elhazent.education.madev3.model.ResultsItem;

public class DetailActivity extends AppCompatActivity {

    public static String EXTRA_DETAIL = "detail";
    ProgressBar progressBar;
    private TextView textTitle;
    private TextView textVote;
    private TextView textPop;
    private TextView textOverView;
    private TextView textDate;
    private ImageView poster;
    private ImageView posterBack;
    ResultsItem movieData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        progressBar = findViewById(R.id.progress_bar);
        textTitle = findViewById(R.id.title_detail);
        textVote = findViewById(R.id.vote_detail);
        textPop = findViewById(R.id.pop_detail);
        textOverView = findViewById(R.id.overview_detial);
        textDate = findViewById(R.id.date_detail);
        poster = findViewById(R.id.imageView2);
        posterBack = findViewById(R.id.imageView);


        progressBar.setVisibility(View.GONE);
        movieData = getIntent().getParcelableExtra(EXTRA_DETAIL);

        if (movieData.getOriginalName() == null) {
            textTitle.setText(movieData.getOriginalTitle());
            textDate.setText(movieData.getReleaseDate());
        } else {
            textTitle.setText(movieData.getOriginalName());
            textDate.setText(movieData.getFirstAirDate());
        }
        textOverView.setText(movieData.getOverview());
        textPop.setText(String.valueOf(movieData.getPopularity()));
        textVote.setText(String.valueOf(movieData.getVoteAverage()));

        Glide.with(getApplicationContext())
                .load(BuildConfig.BASE_URL_IMAGE + movieData.getPosterPath())
                .override(600, 200)
                .into(poster);

        Glide.with(getApplicationContext())
                .load(BuildConfig.BASE_URL_IMAGE_BACK + movieData.getBackdropPath())
                .override(600, 200)
                .into(posterBack);

    }
}
