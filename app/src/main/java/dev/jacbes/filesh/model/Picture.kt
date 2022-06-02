package dev.jacbes.filesh.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Picture(
    val objectID: Int,
    val primaryImage: String,
    val primaryImageSmall: String,
    val title: String,
    val artistDisplayName: String,
    val objectDate: String,
    val objectURL: String
)