package com.daangn.www.koinphotosample

import android.app.Application
import com.daangn.www.koinphotosample.di.appModules
import org.koin.android.ext.android.startKoin

class KoinPhotoApp: Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin(this, appModules)
    }
}