package dev.jacbes.filesh.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "pictures")
data class Picture(
    @PrimaryKey
    val objectID: Int,
    val primaryImage: String,
    val primaryImageSmall: String,
    val title: String,
    val artistDisplayName: String,
    val objectDate: String,
    val objectURL: String
)