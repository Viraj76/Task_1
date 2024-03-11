package com.example.taskone.model

import java.util.UUID

data class PersonalExpense(
    var id: String = UUID.randomUUID().toString(),
    val expenseName : String ? = null,
    val expenseAmount : Int ? = null,
    val expenseDateAndTime : String ? = null
)
