package com.elhazent.education.madev3.ui.movies;

import com.elhazent.education.madev3.base.BasePresenter;
import com.elhazent.education.madev3.model.ResponseMovies;
import com.elhazent.education.madev3.network.InitRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviesPresenter implements BasePresenter<MoviesContract.View>, MoviesContract.Presenter {

    MoviesContract.View view;

    public MoviesPresenter(MoviesContract.View view) {
        this.view = view;
    }

    @Override
    public void onAttach(MoviesContract.View view) {
        this.view = view;
    }

    @Override
    public void onDettach() {
        this.view = null;
    }

    @Override
    public void getMovies() {
        view.showLoading();
        InitRetrofit.getService().getMovies("242346b956cd13fbd0d7e3b0b782c6ce","en-US")
                .enqueue(new Callback<ResponseMovies>() {
                    @Override
                    public void onResponse(Call<ResponseMovies> call, Response<ResponseMovies> response) {
                        if (response.isSuccessful()) {
                            view.hideLoading();
                            view.showMovies(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseMovies> call, Throwable t) {
                        view.showMessage("onFailure : "+ t.getLocalizedMessage());
                        view.hideLoading();
                    }
                });
    }
}
