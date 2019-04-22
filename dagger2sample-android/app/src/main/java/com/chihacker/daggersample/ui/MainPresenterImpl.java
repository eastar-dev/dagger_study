package com.chihacker.daggersample.ui;

import com.chihacker.daggersample.data.DataSource;

import javax.inject.Inject;

/**
 * Created by chihacker on 2017. 8. 13..
 */

public class MainPresenterImpl implements MainActivityContract.Presenter {

    MainActivityContract.View view;
    DataSource dataSource;

    @Inject
    public MainPresenterImpl(MainActivityContract.View view, DataSource dataSource){
        this.view = view;
        this.dataSource = dataSource;
    }

    @Override
    public void loadCategory() {
        view.setViewPager(dataSource.getCategory());
    }
}
