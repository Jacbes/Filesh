package dev.jacbes.filesh.data

import dev.jacbes.filesh.model.Picture

class PictureRepository(private val pictureDao: PictureDao) {

    fun insertPicture(picture: Picture) = pictureDao.insertPicture(picture)

    fun deletePicture(picture: Picture) = pictureDao.deletePicture(picture)

    fun getPictures(picture: Picture) = pictureDao.getPictures()
}