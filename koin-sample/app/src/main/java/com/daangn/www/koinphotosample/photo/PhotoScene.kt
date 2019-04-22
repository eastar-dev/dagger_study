package com.daangn.www.koinphotosample.photo

import com.daangn.www.koinphotosample.common.Scene
import com.daangn.www.koinphotosample.model.Photo


interface PhotoScene: Scene {
    fun onLoadPhoto(photo: Photo)
    fun onLoadFail(error: String?)
}