package com.example.marvelouscomics.views

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.recyclerview.widget.RecyclerView
import com.example.marvelouscomics.R
import com.example.marvelouscomics.models.Comic
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.comic_item.view.*

class ComicAdapter(private val comicList: ArrayList<Comic>, private val listener: Listener): RecyclerView.Adapter<ComicAdapter.ComicViewHolder>() {
    interface Listener {
        fun onItemClick(comic : Comic)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ComicViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.comic_item, parent, false)
        return ComicViewHolder(view)
    }

    override fun onBindViewHolder(holder: ComicViewHolder, position: Int) {
        val comic: Comic = comicList[position]
        holder.bind(comic, listener)
    }

    override fun getItemCount(): Int = comicList.size

    class ComicViewHolder (view: View) :
        RecyclerView.ViewHolder(view) {


        fun bind(comic: Comic, listener: Listener) {
            itemView.setOnClickListener {
                listener.onItemClick(comic)
            }

            itemView.titleTextView.text = comic.title
            var url = comic.imageUrl
            url = url?.replace("http", "https")
            Picasso.get().load(url).into(itemView.coverImageView)
        }

    }
}