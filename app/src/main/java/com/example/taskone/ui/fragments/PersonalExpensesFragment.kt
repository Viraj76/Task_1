package com.example.taskone.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import com.example.taskone.R
import com.example.taskone.adapters.AdapterPersonalExpense
import com.example.taskone.databinding.FragmentPersonalExpensesBinding
import com.example.taskone.model.PersonalExpense

class PersonalExpensesFragment : Fragment() {
    private lateinit var binding : FragmentPersonalExpensesBinding
    private lateinit var adapterPersonalExpense: AdapterPersonalExpense
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonalExpensesBinding.inflate(layoutInflater)
        changeStatusBarColor()
        showSomeDummyDataInRv()
        return binding.root
    }

    private fun showSomeDummyDataInRv() {
        adapterPersonalExpense = AdapterPersonalExpense()
        binding.rvPersonalExpense.adapter = adapterPersonalExpense
        val expenseList = arrayListOf<PersonalExpense>()
        expenseList.add(PersonalExpense(expenseName = "Soap bars" , expenseAmount = 45, expenseDateAndTime = "11-03-2024 11:56"))
        expenseList.add(PersonalExpense(expenseName = "Ice cream" , expenseAmount = 85, expenseDateAndTime = "10-03-2024 9:56"))
        expenseList.add(PersonalExpense(expenseName = "Cold Drink", expenseAmount = 100, expenseDateAndTime = "09-03-2024 14:56"))
        expenseList.add(PersonalExpense(expenseName = "Copy and pen" , expenseAmount = 200, expenseDateAndTime = "08-03-2024 10:56"))
        expenseList.add(PersonalExpense(expenseName = "Ice cream" , expenseAmount = 85, expenseDateAndTime = "10-03-2024 9:56"))

        expenseList.add(PersonalExpense(expenseName = "Cold Drink", expenseAmount = 100, expenseDateAndTime = "09-03-2024 14:56"))
        expenseList.add(PersonalExpense(expenseName = "Soap bars" , expenseAmount = 45, expenseDateAndTime = "11-03-2024 11:56"))

        var sum = 0
        for(i in expenseList){
            sum += i.expenseAmount!!
        }
        binding.totalMoney.text = sum.toString()
        adapterPersonalExpense.differ.submitList(expenseList)
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