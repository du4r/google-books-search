package com.du4r.books

import com.du4r.books.models.BookHttp
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class SearchRequestUnitTest {
    @Test
    fun googleBooksApiTest() {
        val searchResult = BookHttp.searchBook("android")

        searchResult?.items?.forEach { volume ->
           println(volume)
        }

    }
}