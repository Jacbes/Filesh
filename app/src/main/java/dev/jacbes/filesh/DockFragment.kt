package dev.jacbes.filesh

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding
import dev.jacbes.filesh.databinding.FragmentDockBinding
import dev.jacbes.filesh.ui.historytab.HistoryFragment
import dev.jacbes.filesh.ui.infotab.InfoFragment
import dev.jacbes.filesh.ui.sendtab.SendFragment

class DockFragment : Fragment(R.layout.fragment_dock) {

    private val binding by viewBinding(FragmentDockBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSend.setOnClickListener {
            parentFragmentManager.commit {
                replace<SendFragment>(R.id.fragment_base)
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }

        binding.buttonHistory.setOnClickListener {
            parentFragmentManager.commit {
                replace<HistoryFragment>(R.id.fragment_base)
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }

        binding.buttonInfo.setOnClickListener {
            parentFragmentManager.commit {
                replace<InfoFragment>(R.id.fragment_base)
                setReorderingAllowed(true)
                addToBackStack(null)
            }
        }
    }
}
