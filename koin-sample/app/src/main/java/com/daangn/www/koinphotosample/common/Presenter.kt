package com.daangn.www.koinphotosample.common

import io.reactivex.disposables.CompositeDisposable

abstract class Presenter<S : Scene> {

    protected var compositeDisposable: CompositeDisposable? = null

    var scene: S? = null
        set(value) {
            if (this.scene !== value) {
                field = value
                compositeDisposable = CompositeDisposable()
            }
        }

    fun dropScene(scene: S?) {
        if (scene == null) {
            throw NullPointerException("dropped scene must not be null")
        }
        if (scene === this.scene) {
            compositeDisposable?.clear()
            this.scene = null
        }
    }

    protected fun hasScene(): Boolean {
        return scene != null
    }
}
