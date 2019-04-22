package com.chihacker.daggersample.di;

import com.chihacker.daggersample.ui.MoviesFragment;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by chihacker on 2017. 8. 14..
 */

@FragmentScope
@Subcomponent(modules = MovieModule.class)
public interface MovieFragmentComponent extends AndroidInjector<MoviesFragment> {
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MoviesFragment> {}
}
