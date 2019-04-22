package com.daangn.www.koinphotosample.photo

import org.koin.dsl.module.Module
import org.koin.dsl.module.module

val photoListModule: Module = module {
    factory {
        PhotoPresenterImpl(get()) as PhotoPresenter
    }
}