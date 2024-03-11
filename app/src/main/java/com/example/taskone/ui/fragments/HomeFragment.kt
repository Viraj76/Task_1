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
import com.example.taskone.databinding.FragmentHomeBinding
import com.example.taskone.utils.Constant


class HomeFragment : Fragment() {
    private lateinit var binding:FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        changeStatusBarColor()
        showToasts()
        binding.cvShow.setOnClickListener { findNavController().navigate(R.id.action_homeFragment_to_expencesFragment) }
        return binding.root
    }

    private fun showToasts() {
        binding.apply {
            ivMenu.setOnClickListener { Constant.showToast(requireContext() , "Going to implement it soon!\n\nPlease click on Show Expenses") }
            fabAdd.setOnClickListener { Constant.showToast(requireContext() , "Going to implement it soon!\n" +
                    "\n" +
                    "Please click on Show Expenses") }
        }
    }


    private fun changeStatusBarColor() {
        val window = activity?.window
        window?.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.status_bar)
        if (window != null) {
            WindowCompat.getInsetsController(window, window.decorView).apply {
                isAppearanceLightStatusBars = true
            }
        }
    }

}