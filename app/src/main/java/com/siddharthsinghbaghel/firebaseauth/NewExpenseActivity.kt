package com.siddharthsinghbaghel.firebaseauth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore
import java.time.temporal.TemporalAmount

class NewExpenseActivity : AppCompatActivity() {

    private lateinit var fabBtnDone:FloatingActionButton
    private lateinit var txtExpense:EditText
    private lateinit var txtExpenseDescription:EditText
    private lateinit var expenseDate:EditText
    private lateinit var amount:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_expense)

        fabBtnDone = findViewById(R.id.fabBtnSave)
        txtExpense = findViewById(R.id.edtExpense)
        txtExpenseDescription = findViewById(R.id.edtExpenseDescription)
        amount = findViewById(R.id.edtAmount)
        expenseDate = findViewById(R.id.edtDate)

        fabBtnDone.setOnClickListener{

            saveToFirestrore(amount.text.toString(),txtExpense.text.toString(),txtExpenseDescription.text.toString(),expenseDate.text.toString())

        }
    }

    private fun saveToFirestrore(amount: String, expense: String,expenseDescription: String, date: String) {

        val db = FirebaseFirestore.getInstance()

        val user: MutableMap<String, Any> = HashMap()
        user["Amount"] = amount
        user["Expense"] = expense
        user["Expense Description"] = expenseDescription
        user["Date"] = date

        db.collection("users")
            .add(user)
            .addOnSuccessListener {
                Toast.makeText(this, "Record added successfully ", Toast.LENGTH_SHORT ).show()
            }
            .addOnFailureListener{
                Toast.makeText(this, "Record Failed to add ", Toast.LENGTH_SHORT ).show()
            }

    }
}