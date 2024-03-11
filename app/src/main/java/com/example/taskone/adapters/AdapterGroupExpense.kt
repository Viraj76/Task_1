package com.example.taskone.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.taskone.model.GroupExpense
import com.example.taskone.databinding.IvGroupExpenseBinding

class AdapterGroupExpense : RecyclerView.Adapter<AdapterGroupExpense.GroupViewHolder>() {

    class GroupViewHolder(val binding : IvGroupExpenseBinding) : ViewHolder(binding.root)

    val diffUtil = object : DiffUtil.ItemCallback<GroupExpense>(){
        override fun areItemsTheSame(oldItem: GroupExpense, newItem: GroupExpense): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GroupExpense, newItem: GroupExpense): Boolean {
            return oldItem == newItem
        }
    }
    val differ = AsyncListDiffer(this,diffUtil)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupViewHolder {
        return GroupViewHolder(IvGroupExpenseBinding.inflate(LayoutInflater.from(parent.context) , parent, false))
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: GroupViewHolder, position: Int) {
        val expense = differ.currentList[position]

        holder.binding.apply {
            tvExpenseName.text = expense.expenseName
            tvMoney.text = expense.expenseAmount.toString()
            tvDate.text = expense.expenseDateAndTime
            tvname.text = expense.name
        }
    }
}