package com.example.taskone.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.navigation.fragment.findNavController
import com.example.taskone.R
import com.example.taskone.databinding.FragmentExpencesBinding

class ExpensesFragment : Fragment() {

    private lateinit var binding : FragmentExpencesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExpencesBinding.inflate(layoutInflater)

        changeStatusBarColor()

        onBackIconPressed()
        binding.cvPersonalExpense.setOnClickListener{findNavController().navigate(R.id.action_expencesFragment_to_personalExpensesFragment)}
        binding.cvGroupExpense.setOnClickListener{findNavController().navigate(R.id.action_expencesFragment_to_groupFragment)}

        return binding.root
    }

    private fun onBackIconPressed() {
        binding.tbExpense.setNavigationOnClickListener {
            findNavController().navigate(R.id.action_expencesFragment_to_homeFragment)
        }
    }

    private fun changeStatusBarColor() {
        val window = activity?.window
        window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.status_bar)

        if (window != null) {
            WindowCompat.getInsetsController(window, window.decorView).apply { isAppearanceLightStatusBars = true }
        }
    }



}