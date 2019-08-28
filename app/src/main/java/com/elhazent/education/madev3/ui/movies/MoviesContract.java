package com.elhazent.education.madev3.ui.movies;

import com.elhazent.education.madev3.base.BaseView;
import com.elhazent.education.madev3.model.ResponseMovies;

public interface MoviesContract {
    interface Presenter{
        void getMovies();
    }

    interface View extends BaseView {
        void showMovies(ResponseMovies responseMovies);
        void showMessage(String message);
        void showLoading();
        void hideLoading();
    }
}
