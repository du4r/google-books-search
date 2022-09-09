package com.du4r.books.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.du4r.books.databinding.ActivityMainBinding
import com.du4r.books.models.BookHttp
import com.du4r.books.models.Volume
import com.du4r.books.ui.adapters.BookListAdapter
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private val binding by lazy{ ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvBooks.layoutManager = LinearLayoutManager(this )

        lifecycleScope.launch{
            val result = withContext(Dispatchers.IO){
                BookHttp.searchBook("dominando o android")}
            result?.items?.let { bookList ->
                binding.rvBooks.adapter = BookListAdapter(bookList, this@MainActivity::openBookDetail)
            }
        }
    }

    private fun openBookDetail(volume: Volume){
       BookDetailActivity.open(this, volume)
    }

}