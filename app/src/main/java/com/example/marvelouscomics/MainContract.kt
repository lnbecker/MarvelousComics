package com.example.marvelouscomics

import com.example.marvelouscomics.models.Comic
import com.example.marvelouscomics.presenters.BasePresenter
import com.example.marvelouscomics.views.BaseView

interface MainContract {
    interface Presenter: BasePresenter {
        fun loadComics()
    }

    interface View: BaseView<Presenter> {
        fun displayComics(comics: List<Comic>?)
    }
}