package com.elhazent.education.madev3.base;

public interface BasePresenter<T extends BaseView> {
    void onAttach(T view);
    void onDettach();
}
