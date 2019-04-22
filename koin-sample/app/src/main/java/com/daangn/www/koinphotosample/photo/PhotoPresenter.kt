package com.daangn.www.koinphotosample.photo

import com.daangn.www.koinphotosample.common.Presenter

abstract class PhotoPresenter: Presenter<PhotoScene>() {
    abstract fun requestPhoto(id: Long)
}