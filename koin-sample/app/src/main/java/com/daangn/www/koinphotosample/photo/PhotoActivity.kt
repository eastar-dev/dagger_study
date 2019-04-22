package com.daangn.www.koinphotosample.photo

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.daangn.www.koinphotosample.R
import com.daangn.www.koinphotosample.model.Photo
import org.koin.android.ext.android.inject

class PhotoActivity : AppCompatActivity(), PhotoScene {

    private val presenter: PhotoPresenter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)

        presenter.scene = this
        presenter.requestPhoto(1)
    }

    override fun onLoadPhoto(photo: Photo) {
        val photoView = findViewById<ImageView>(R.id.thumbnail_url)
        val title = findViewById<TextView>(R.id.title)

        title.text = photo.title
        Glide.with(this)
            .load(photo.thumbnailUrl)
            .into(photoView)
    }

    override fun onLoadFail(error: String?) {
        Toast.makeText(this, "load failed: $error", Toast.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.dropScene(this)
    }
}

