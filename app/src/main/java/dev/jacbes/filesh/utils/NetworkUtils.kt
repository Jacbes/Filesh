package dev.jacbes.filesh.utils

import android.util.Log
import com.squareup.moshi.Moshi
import dev.jacbes.filesh.model.Picture
import dev.jacbes.filesh.model.Pictures
import io.reactivex.rxjava3.core.Single
import okhttp3.*
import java.io.IOException

class NetworkUtils {

    private val client = OkHttpClient()
    private val moshi = Moshi.Builder().build()
    private val pictureListJsonAdapter = moshi.adapter(Pictures::class.java)
    private val pictureJsonAdapter = moshi.adapter(Picture::class.java)

    fun createRequestAllObjects(): Request {
        return Request.Builder()
            .url("https://collectionapi.metmuseum.org/public/collection/v1/search?hasImages=true&medium=Paintings&q=art")
            .build()
    }

    fun createRequestById(id: Int): Request {
        return Request.Builder()
            .url("https://collectionapi.metmuseum.org/public/collection/v1/objects/$id")
            .build()
    }

    fun sendRequest(request: Request): Single<Response> {
        return Single.create { emitter ->
            client.newCall(request).enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    Log.i("Hello", "Error in newCall ${e.message.toString()}")
                    emitter.onError(e)
                }

                override fun onResponse(call: Call, response: Response) {
                    response.use {
                        Log.i("Hello", "onResponse in newCall ${it.body!!.string()}")
                        emitter.onSuccess(it)
                    }
                }
            })
        }
    }
}