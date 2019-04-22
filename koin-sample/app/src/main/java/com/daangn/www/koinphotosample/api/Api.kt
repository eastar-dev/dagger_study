package com.daangn.www.koinphotosample.api

import com.daangn.www.koinphotosample.model.Photo
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface Api {
    @GET("photos/{id}")
    fun getPhoto(@Path("id") id: Long): Single<Photo>
}