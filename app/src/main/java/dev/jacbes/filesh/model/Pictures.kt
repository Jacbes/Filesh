package dev.jacbes.filesh.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Pictures(
    val total: Int,
    val objectIDs: List<Int>
)