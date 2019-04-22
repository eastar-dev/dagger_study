package com.chihacker.daggersample.di;

import com.chihacker.daggersample.ui.MoviesFragment;
import com.chihacker.daggersample.ui.MoviesFragmentContract;
import com.chihacker.daggersample.ui.MoviesPresenterImpl;

import dagger.Binds;
import dagger.Module;

/**
 * Created by chihacker on 2017. 8. 14..
 */

@Module
abstract class MovieModule {

    @FragmentScope
    @Binds
    abstract MoviesFragmentContract.Presenter bindPresenter(MoviesPresenterImpl presenter);

    @FragmentScope
    @Binds
    abstract MoviesFragmentContract.View bindView(MoviesFragment fragment);

}
