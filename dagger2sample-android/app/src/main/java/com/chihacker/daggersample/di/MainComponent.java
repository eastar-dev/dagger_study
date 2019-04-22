package com.chihacker.daggersample.di;

import com.chihacker.daggersample.ui.MainActivity;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;

/**
 * Created by chihacker on 2017. 8. 14..
 */

@ActivityScope
@Subcomponent(modules = MainModule.class)
public interface MainComponent extends AndroidInjector<MainActivity>{
    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{}
}
