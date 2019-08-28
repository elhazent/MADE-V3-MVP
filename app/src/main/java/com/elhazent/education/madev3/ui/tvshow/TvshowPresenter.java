package com.elhazent.education.madev3.ui.tvshow;

import com.elhazent.education.madev3.base.BasePresenter;
import com.elhazent.education.madev3.model.ResponseMovies;
import com.elhazent.education.madev3.network.InitRetrofit;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TvshowPresenter implements BasePresenter<TvshowContract.View>,TvshowContract.Presenter {

    TvshowContract.View view;

    public TvshowPresenter(TvshowContract.View view) {
        this.view = view;
    }

    @Override
    public void onAttach(TvshowContract.View view) {
        this.view = view;
    }

    @Override
    public void onDettach() {
        this.view = null;
    }

    @Override
    public void getTvshow() {
        view.showLoading();
        InitRetrofit.getService().getTvshow("242346b956cd13fbd0d7e3b0b782c6ce","en-US")
                .enqueue(new Callback<ResponseMovies>() {
                    @Override
                    public void onResponse(Call<ResponseMovies> call, Response<ResponseMovies> response) {
                        if (response.isSuccessful()){
                            view.hideLoading();
                            view.showTvshow(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseMovies> call, Throwable t) {
                        view.hideLoading();
                        view.showMessage("onFailure : " + t.getLocalizedMessage());
                    }
                });
    }
}
