package dev.jacbes.filesh

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import dev.jacbes.filesh.databinding.FragmentDockBinding
import dev.jacbes.filesh.historytab.HistoryFragment
import dev.jacbes.filesh.infotab.InfoFragment
import dev.jacbes.filesh.sendtab.SendFragment

class DockFragment : Fragment(R.layout.fragment_dock) {

    private var _binding: FragmentDockBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDockBinding.inflate(inflater, container, false)

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

        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
