package com.siddharthsinghbaghel.firebaseauth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerAdapter
import com.firebase.ui.firestore.FirestoreRecyclerOptions

class AllExpenseAdapter(options: FirestoreRecyclerOptions<Expense>) : FirestoreRecyclerAdapter<Expense, AllExpenseAdapter.ExpenseHolder>(options) {

    class ExpenseHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val dateView : EditText = itemView.findViewById(R.id.dateItem)
        val expenseView: EditText = itemView.findViewById(R.id.expenseItem)
        val expenseDesView: EditText = itemView.findViewById(R.id.expenseDescriptionItem)
        val amountView: EditText = itemView.findViewById(R.id.edtAmountItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExpenseHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_expense, parent, false)
        return ExpenseHolder(view)
    }

    override fun onBindViewHolder(holder: ExpenseHolder, position: Int, model: Expense) {

         holder.dateView.setText(model.getDateExp())
         holder.expenseView.setText(model.getExpenseExp())
         holder.expenseDesView.setText(model.getExpenseDescriptionExp())
         holder.amountView.setText(model.getExpenseDescriptionExp())

    }

}