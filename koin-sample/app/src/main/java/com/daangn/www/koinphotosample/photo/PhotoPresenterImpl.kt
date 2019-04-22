package com.daangn.www.koinphotosample.photo

import com.daangn.www.koinphotosample.api.Api
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class PhotoPresenterImpl(val api: Api): PhotoPresenter() {

    override fun requestPhoto(id: Long) {
        compositeDisposable?.add(api.getPhoto(id)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe ({
                    scene?.onLoadPhoto(it)
                }, {
                    scene?.onLoadFail(it.message)
                })
        )
    }
}