package com.chihacker.daggersample.di;

import androidx.fragment.app.Fragment;

import com.chihacker.daggersample.ui.MainActivity;
import com.chihacker.daggersample.ui.MainActivityContract;
import com.chihacker.daggersample.ui.MainPresenterImpl;
import com.chihacker.daggersample.ui.MoviesFragment;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjector;
import dagger.android.support.FragmentKey;
import dagger.multibindings.IntoMap;

/**
 * Created by chihacker on 2017. 8. 14..
 */

@Module(subcomponents = MovieFragmentComponent.class)
abstract class MainModule {

    @ActivityScope
    @Binds
    abstract MainActivityContract.View bindView(MainActivity activity);

    @ActivityScope
    @Binds
    abstract MainActivityContract.Presenter bindPresenter(MainPresenterImpl mainPresenter);

    @Binds
    @IntoMap
    @FragmentKey(MoviesFragment.class)
    abstract AndroidInjector.Factory<? extends Fragment>
    bindMoviesFragment(MovieFragmentComponent.Builder builder);
}
