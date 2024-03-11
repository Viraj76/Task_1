package com.example.taskone.utils

import android.content.Context
import android.widget.Toast

object Constant {
    fun showToast(context : Context , message : String){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }
}