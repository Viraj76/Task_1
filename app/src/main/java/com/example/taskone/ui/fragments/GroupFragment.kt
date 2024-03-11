package com.example.taskone.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.taskone.adapters.AdapterGroupExpense
import com.example.taskone.databinding.FragmentGroupBinding
import com.example.taskone.model.GroupExpense


class GroupFragment : Fragment() {
    private lateinit var binding : FragmentGroupBinding
    private lateinit var adapterGroupExpense: AdapterGroupExpense
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGroupBinding.inflate(layoutInflater)

        showingGroupExpenses()

        return binding.root
    }

    private fun showingGroupExpenses() {
        adapterGroupExpense = AdapterGroupExpense()
        binding.groupExpenses.adapter = adapterGroupExpense

        val groupExpenseList = arrayListOf<GroupExpense>()

        groupExpenseList.add(GroupExpense(expenseName = "Road Trip" , name = "Viraj" , expenseAmount = 453 , expenseDateAndTime = "11-03-2024 17:56"))
        groupExpenseList.add(GroupExpense(expenseName = "Party" , name = "Viraj" , expenseAmount = 500 , expenseDateAndTime = "02-03-2024 17:56"))
        adapterGroupExpense.differ.submitList(groupExpenseList)
    }

}