package com.siddharthsinghbaghel.firebaseauth

import com.google.firebase.firestore.ServerTimestamp


class Expense {
    private var dateExp: String? = null
    private var expenseExp: String? = null
    private var expenseDescriptionExp: String? = null
    private var amountExp: String? = null

    constructor() {} //Empty constructor  Needed for Firebase
    constructor(dateExp: String?, expenseExp: String?, expenseDescriptionExp: String?, amountExp: String?) {
        this.dateExp = dateExp
        this.expenseExp = expenseExp
        this.expenseDescriptionExp = expenseDescriptionExp
        this.amountExp = amountExp
    }

    @JvmName("getDateExp1")
    fun getDateExp(): String? {
        return dateExp
    }

    @JvmName("getExpenseExp1")
    fun getExpenseExp(): String? {
        return expenseExp
    }

    @JvmName("getExpenseDescriptionExp1")
    fun getExpenseDescriptionExp(): String? {
        return expenseDescriptionExp
    }

    @JvmName("getAmountExp1")
    fun getAmountExp(): String? {
        return amountExp
    }
}


