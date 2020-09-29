package com.example.marvelouscomics.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelouscomics.ComicApiServiceInjector
import com.example.marvelouscomics.MainContract
import com.example.marvelouscomics.R
import com.example.marvelouscomics.models.Comic
import com.example.marvelouscomics.presenters.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MainContract.View, ComicAdapter.Listener {
    private lateinit var recyclerView: RecyclerView
    private lateinit var comicAdapter: ComicAdapter
    private lateinit var layoutManager: RecyclerView.LayoutManager
    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setPresenter(MainPresenter(this, ComicApiServiceInjector()))
        presenter.loadComics()

        layoutManager = LinearLayoutManager(this)
        recyclerView = findViewById<RecyclerView>(R.id.rv_comic_list)
        recyclerView.layoutManager = layoutManager
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }

    override fun setPresenter(presenter: MainContract.Presenter) {
        this.presenter = presenter
    }

    override fun displayComics(comics: List<Comic>?) {
        if(comics.isNullOrEmpty()){
            recyclerView.visibility = GONE
            emptyView.visibility = VISIBLE

        }
        else {
            emptyView.visibility = GONE
            comicAdapter = ComicAdapter(ArrayList(comics), this)
            recyclerView.adapter = comicAdapter

        }
    }

    override fun onItemClick(comic: Comic) {
        val intent = Intent(this, ComicDetailsActivity::class.java).apply {
            putExtra("title", comic.title)
            putExtra("description", comic.description)
            putExtra("imageUrl", comic.imageUrl)
            putExtra("detailsUrl", comic.detailsUrl)
        }
        startActivity(intent)
    }

}