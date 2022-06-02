package dev.jacbes.filesh.ui.sendtab

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.squareup.moshi.Moshi
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dev.jacbes.filesh.R
import dev.jacbes.filesh.databinding.FragmentSendBinding
import dev.jacbes.filesh.model.Picture
import dev.jacbes.filesh.model.Pictures
import dev.jacbes.filesh.utils.NetworkUtils
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.*
import java.io.IOException

class SendFragment : Fragment(R.layout.fragment_send) {

    private val binding by viewBinding(FragmentSendBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val request = NetworkUtils().createRequestAllObjects()
        NetworkUtils().sendRequest(request)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    Log.i("Hello", "onSuccess in subscribe ${it.body!!.string()}")
                },
                {
                    Log.i("Hello", "onError in subscribe ${it.message.toString()}")
                }
            )
    }
}