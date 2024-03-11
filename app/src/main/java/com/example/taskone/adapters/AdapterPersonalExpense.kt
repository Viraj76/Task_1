package com.example.taskone.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskone.model.PersonalExpense
import com.example.taskone.databinding.IvPersonalExpenseBinding

class AdapterPersonalExpense : RecyclerView.Adapter<AdapterPersonalExpense.PersonalExpenseViewHolder>() {

    class PersonalExpenseViewHolder(val binding : IvPersonalExpenseBinding) : ViewHolder(binding.root)

    val diffUtil = object : DiffUtil.ItemCallback<PersonalExpense>(){
        override fun areItemsTheSame(oldItem: PersonalExpense, newItem: PersonalExpense): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PersonalExpense, newItem: PersonalExpense): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this,diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PersonalExpenseViewHolder {
        return PersonalExpenseViewHolder(IvPersonalExpenseBinding.inflate(LayoutInflater.from(parent.context) , parent, false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: PersonalExpenseViewHolder, position: Int) {
        val expense = differ.currentList[position]

        holder.binding.apply {
            tvExpenseName.text = expense.expenseName
            tvMoney.text = expense.expenseAmount.toString()
            tvDate.text = expense.expenseDateAndTime
        }
    }
}