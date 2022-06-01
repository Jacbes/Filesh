package dev.jacbes.filesh.sendtab

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dev.jacbes.filesh.R
import dev.jacbes.filesh.databinding.FragmentSendBinding

class SendFragment : Fragment(R.layout.fragment_send) {

    private val binding by viewBinding(FragmentSendBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}