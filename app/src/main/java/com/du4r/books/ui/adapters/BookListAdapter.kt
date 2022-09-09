package com.du4r.books.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.du4r.books.R
import com.du4r.books.databinding.ItemBookBinding
import com.du4r.books.models.Volume


class BookListAdapter(
    private val items: List<Volume>,
    private val onItemClick: (Volume) -> Unit
    ): RecyclerView.Adapter<BookListAdapter.BookHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookHolder {
        return BookHolder(
            ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        )
    }

    override fun onBindViewHolder(holder: BookHolder, position: Int) {

        val context: Context = holder.itemView.context
        val books = items[position]
        holder.txtTitle.text = books.volumeInfo.title
        holder.txtAuthor.text = books.volumeInfo.authors?.joinToString() ?: " "
        holder.txtPages.text = books.volumeInfo.pageCount ?: "-"
        if (books.volumeInfo.imageLinks?.smallThumbnail != null){
            Glide.with(context)
                .load(books.volumeInfo.imageLinks.smallThumbnail)
                .into(holder.imgCover)
        }else{
            holder.imgCover.setImageResource(R.drawable.ic_baseline_broken_image_24)
        }
        holder.itemView.setOnClickListener{
            onItemClick(books)
        }
    }

    override fun getItemCount(): Int = items.size ?: 0

    class BookHolder(binding: ItemBookBinding): RecyclerView.ViewHolder(binding.root){
        val imgCover: ImageView = binding.imageCover
        val txtTitle: TextView = binding.txtTitle
        val txtAuthor: TextView = binding.txtAuthor
        val txtPages: TextView = binding.txtPages
    }

}
