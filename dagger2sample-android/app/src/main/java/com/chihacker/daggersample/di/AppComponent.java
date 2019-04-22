package com.chihacker.daggersample.di;

import com.chihacker.daggersample.DaggerSampleApp;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

/**
 * Created by chihacker on 2017. 8. 14..
 */

@Singleton
@Component(modules = {
        AndroidInjectionModule.class,
        AppModule.class
})
public interface AppComponent {

    void inject(DaggerSampleApp daggerSampleApp);

}
