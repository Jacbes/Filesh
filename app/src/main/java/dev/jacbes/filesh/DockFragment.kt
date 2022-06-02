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
            val findFragment = parentFragmentManager.findFragmentByTag("SEND_FRAGMENT")
            parentFragmentManager.commit {
                addToBackStack(null)
                if (findFragment != null) {
                    replace(R.id.fragment_base, findFragment, "SEND_FRAGMENT")
                } else {
                    replace<SendFragment>(R.id.fragment_base, "SEND_FRAGMENT")
                }
                setReorderingAllowed(true)
            }
        }

        binding.buttonHistory.setOnClickListener {
            val findFragment = parentFragmentManager.findFragmentByTag("HISTORY_FRAGMENT")
            parentFragmentManager.commit {
                addToBackStack(null)
                if (findFragment != null) {
                    replace(R.id.fragment_base, findFragment, "HISTORY_FRAGMENT")
                } else {
                    replace<HistoryFragment>(R.id.fragment_base, "HISTORY_FRAGMENT")
                }
                setReorderingAllowed(true)
            }
        }

        binding.buttonInfo.setOnClickListener {
            val findFragment = parentFragmentManager.findFragmentByTag("INFO_FRAGMENT")
            parentFragmentManager.commit {
                addToBackStack(null)
                if (findFragment != null) {
                    replace(R.id.fragment_base, findFragment, "INFO_FRAGMENT")
                } else {
                    replace<InfoFragment>(R.id.fragment_base, "INFO_FRAGMENT")
                }
                setReorderingAllowed(true)
            }
        }
    }
}