package dev.jacbes.filesh.ui.sendtab

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dev.jacbes.filesh.R
import dev.jacbes.filesh.databinding.FragmentSendBinding

class SendFragment : Fragment(R.layout.fragment_send) {

    private val binding by viewBinding(FragmentSendBinding::bind)
    private lateinit var viewModel: SendViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(SendViewModel::class.java)

        binding.progressBar.visibility = View.VISIBLE
        binding.title.visibility = View.GONE
        binding.primaryImage.visibility = View.GONE
        binding.updateButton.visibility = View.GONE
        viewModel.loadPicture()

        binding.updateButton.setOnClickListener {
            binding.progressBar.visibility = View.VISIBLE
            binding.title.visibility = View.GONE
            binding.primaryImage.visibility = View.GONE
            binding.updateButton.visibility = View.GONE
            viewModel.loadPicture()
        }

        viewModel.picture.observe(viewLifecycleOwner) {
            binding.progressBar.visibility = View.GONE
            binding.title.visibility = View.VISIBLE
            binding.primaryImage.visibility = View.VISIBLE
            binding.updateButton.visibility = View.VISIBLE

            binding.title.text = it.title

            Glide.with(binding.primaryImage.context)
                .load(it.primaryImage)
                .placeholder(R.drawable.ic_baseline_image_search_24)
                .error(Glide.with(binding.primaryImage.context)
                    .load(R.drawable.ic_baseline_image_not_supported_24))
                .override(1920, 1080)
                .into(binding.primaryImage)
        }
    }
}