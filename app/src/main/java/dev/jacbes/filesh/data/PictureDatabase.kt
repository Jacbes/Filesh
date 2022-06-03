package dev.jacbes.filesh.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import dev.jacbes.filesh.model.Picture

@Database(entities = [Picture::class], version = 2, exportSchema = false)
abstract class PictureDatabase: RoomDatabase() {
    abstract fun pictureDao(): PictureDao

    companion object {

        @Volatile private var instance: PictureDatabase? = null

        fun getInstance(context: Context): PictureDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context). also { instance = it }
            }
        }

        private fun buildDatabase(context: Context): PictureDatabase {
            return Room.databaseBuilder(context, PictureDatabase::class.java, "picture-db")
                .build()
        }
    }
}