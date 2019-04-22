package com.chihacker.daggersample.di;

import android.app.Activity;

import com.chihacker.daggersample.data.DataSource;
import com.chihacker.daggersample.data.DataSourceImpl;
import com.chihacker.daggersample.ui.MainActivity;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

/**
 * Created by chihacker on 2017. 8. 14..
 */

@Module(subcomponents = MainComponent.class)
abstract class AppModule {

    @Singleton
    @Binds
    abstract DataSource bindDataSource(DataSourceImpl dataSource);

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindMainActivity(MainComponent.Builder builder);

}
