package com.example.taskone.model

import java.util.UUID

data  class GroupExpense(
    var id: String = UUID.randomUUID().toString(),
    val expenseName : String ? = null,
    val name : String ? = null,
    val expenseAmount : Int ? = null,
    val expenseDateAndTime : String ? = null
)