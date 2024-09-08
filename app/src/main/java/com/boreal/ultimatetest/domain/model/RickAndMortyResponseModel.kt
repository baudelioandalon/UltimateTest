package com.boreal.ultimatetest.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class RickAndMortyResponseModel(
    val info: Info,
    val results: List<CharacterModel>
) : Parcelable