package com.elhazent.education.madev3.ui.tvshow;

import com.elhazent.education.madev3.base.BaseView;
import com.elhazent.education.madev3.model.ResponseMovies;

public interface TvshowContract {
    interface Presenter{
        void getTvshow();
    }

    interface View extends BaseView {
        void showTvshow(ResponseMovies dataTvshow);
        void showMessage(String message);
        void showLoading();
        void hideLoading();
    }
}
