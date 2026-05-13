package com.example.lab8

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lab8.R
import com.example.lab8.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {

    private lateinit var binding: FragmentFirstBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.goToSecondFragmentBtn.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        binding.goToThirdFragmentBtn.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }

        binding.goToActionsActivityBtn.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_actionsActivity)
        }
    }
}