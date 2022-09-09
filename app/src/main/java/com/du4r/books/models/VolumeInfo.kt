package com.du4r.books.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class VolumeInfo(
    val id: String?,
    val title: String?,
    val description: String?,
    val authors: List<String>?,
    val publisher: String?,
    val publishDate: String?,
    val pageCount: String?,
    val imageLinks: ImageLinks?
): Parcelable
