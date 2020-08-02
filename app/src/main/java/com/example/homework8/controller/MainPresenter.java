package com.example.homework8.controller;

import com.example.homework8.services.MainContract;

public class MainPresenter implements MainContract.Presenter {
    MainContract.View view;

    public MainPresenter(MainContract.View view){
        this.view = view;
    }

    @Override
    public void onClickAddNodeButton() {

    }
}
