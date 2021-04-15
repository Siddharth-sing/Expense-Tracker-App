package com.siddharthsinghbaghel.firebaseauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goToNewExpense(view: View) {

        val goToNewExpenseIntent = Intent(this,NewExpenseActivity::class.java)
        startActivity(goToNewExpenseIntent)
    }
    fun goToAllExpense(view: View) {

        val goToAllExpensesIntent = Intent(this,ExpenseAllActivity::class.java)
        Toast.makeText(this,"Inside goToAllExpense fun",Toast.LENGTH_SHORT).show()
        startActivity(goToAllExpensesIntent)
        Toast.makeText(this,"Inside goToAllExpense fun",Toast.LENGTH_SHORT).show()

    }
}