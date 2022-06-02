package dev.jacbes.filesh.ui.sendtab

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dev.jacbes.filesh.model.Picture
import dev.jacbes.filesh.utils.NetworkUtils
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class SendViewModel : ViewModel() {

    private val _picture = MutableLiveData<Picture>()
    val picture: LiveData<Picture> = _picture

    private fun setPicture(picture: Picture) {
        _picture.postValue(picture)
    }

    fun loadPicture() {
        NetworkUtils().getPictureList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .flatMap {
                val id = it.objectIDs.random()
                NetworkUtils().getPictureById(id)
            }
            .subscribe(
                {
                    Log.i("Hello", it.toString())
                    setPicture(it)
                },
                {
                    Log.i("Hello", it.message.toString())
                }
            )
    }
}