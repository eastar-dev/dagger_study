package com.chihacker.daggersample.ui;

import com.chihacker.daggersample.data.DataSource;

import javax.inject.Inject;

/**
 * Created by chihacker on 2017. 8. 13..
 */

public class MoviesPresenterImpl implements MoviesFragmentContract.Presenter {

    MoviesFragmentContract.View view;
    DataSource dataSource;

    @Inject
    public MoviesPresenterImpl(MoviesFragmentContract.View view, DataSource dataSource){
        this.view = view;
        this.dataSource = dataSource;
    }

    @Override
    public void loadMovies(String category) {
        view.setList(dataSource.getMovies(category));
    }
}
