package com.du4r.books.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat.startActivity
import com.bumptech.glide.Glide
import com.du4r.books.R
import com.du4r.books.databinding.ActivityBookDetailBinding
import com.du4r.books.databinding.ItemBookBinding
import com.du4r.books.models.Volume

class BookDetailActivity : AppCompatActivity() {

    private lateinit var bookDetailBinding: ActivityBookDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_detail)

        val volume =  intent.getParcelableExtra<Volume>(EXTRA_BOOK)
        if(volume != null){

            bookDetailBinding.txtTitle.text = volume.volumeInfo.title
            bookDetailBinding.txtAuthor.text = volume.volumeInfo.authors?.joinToString() ?: " "
            bookDetailBinding.txtPages.text = volume.volumeInfo.pageCount?.toString() ?: "-"
            bookDetailBinding.txtDescription.text = volume.volumeInfo.description
            bookDetailBinding.txtPublisher.text = volume.volumeInfo.publisher
            if (volume.volumeInfo.imageLinks?.smallThumbnail != null){
                Glide.with(this)
                    .load(volume.volumeInfo.imageLinks.smallThumbnail)
                    .into(bookDetailBinding.imageCover)
            }else{
                bookDetailBinding.imageCover.setImageResource(R.drawable.ic_baseline_broken_image_24) }
        }else{
            finish()}
    }

    companion object{
        private const val EXTRA_BOOK = "book"
        fun open(context: Context, volume: Volume){
            val detailIntent = Intent(context, BookDetailActivity::class.java)
            detailIntent.putExtra(EXTRA_BOOK,volume)
            context.startActivity(detailIntent)
        }
    }
}