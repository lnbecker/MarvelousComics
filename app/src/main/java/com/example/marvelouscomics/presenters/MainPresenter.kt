package com.example.marvelouscomics.presenters

import android.util.Log
import com.example.marvelouscomics.ComicApiServiceInjector
import com.example.marvelouscomics.MainContract
import com.example.marvelouscomics.models.Comic
import com.example.marvelouscomics.retrofit.ComicsApiInterface
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainPresenter (view: MainContract.View,
                     dependencyInjector: ComicApiServiceInjector): MainContract.Presenter {

    private var compositeDisposable: CompositeDisposable? = null
    private val apiService: ComicsApiInterface
            = dependencyInjector.apiService()
    private var view: MainContract.View? = view

    override fun loadComics() {
        compositeDisposable = CompositeDisposable()
        compositeDisposable?.add(apiService.getComics()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe(this::handleResponse, this::handleError)
        )
    }

    override fun onDestroy() {
        compositeDisposable?.clear()
        this.view = null
    }

    private fun handleResponse(comics: List<Comic>) {
        view?.displayComics(comics)
    }

    private fun handleError(error: Throwable) {
        view?.displayComics(null)
        Log.d("error", error.localizedMessage)

    }

}