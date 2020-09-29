package com.example.marvelouscomics.views

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.marvelouscomics.R
import com.squareup.picasso.Picasso
import jp.wasabeef.picasso.transformations.BlurTransformation
import kotlinx.android.synthetic.main.activity_comic_details.*

class ComicDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_comic_details)

        supportActionBar?.setDisplayHomeAsUpEnabled(true);


        val title = intent.getStringExtra("title")
        val description = intent.getStringExtra("description")
        val imageUrl = intent.getStringExtra("imageUrl")
        val detailsUrl = intent.getStringExtra("detailsUrl")

        titleTextView.text = title
        if(description.isNullOrEmpty())
            descriptionTextView.text = "No description available. Click 'View Online for details'"
        else
            descriptionTextView.text = description

        val url = imageUrl?.replace("http", "https")
        Picasso.get()
            .load(url)
            .transform(BlurTransformation(this, 25, 1))
            .into(backgroundImageView)
        Picasso.get().load(url).into(comicImageView)

        viewOnlineButton.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(detailsUrl)
            startActivity(i)
        }

    }
    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}