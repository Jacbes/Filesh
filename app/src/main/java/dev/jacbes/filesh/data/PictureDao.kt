package dev.jacbes.filesh.data

import androidx.room.*
import dev.jacbes.filesh.model.Picture
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@Dao
interface PictureDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertPicture(picture: Picture): Completable

    @Delete
    fun deletePicture(picture: Picture): Completable

    @Query("SELECT * FROM pictures")
    fun getPictures(): Single<List<Picture>>
}