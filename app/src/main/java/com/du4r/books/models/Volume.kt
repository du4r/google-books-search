package com.du4r.books.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Volume(
    val id: String,
    val selfLink: String,
    val volumeInfo: VolumeInfo
): Parcelable
