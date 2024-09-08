package com.boreal.ultimatetest.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: String
): Parcelable