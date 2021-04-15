package com.siddharthsinghbaghel.firebaseauth

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.FirestoreRecyclerOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query


class ExpenseAllActivity : AppCompatActivity() {


    private val db = FirebaseFirestore.getInstance()
    private val userRef = db.collection("users")
    private  var adapter: AllExpenseAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        Toast.makeText(this,"Inside OnCreate fun", Toast.LENGTH_SHORT).show()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense_all)



        val btnShowAll: Button =findViewById(R.id.btnShowAll)

        btnShowAll.setOnClickListener {
            setUpRecyclerView()
        }


    }

    private fun setUpRecyclerView() {

        val query: Query = userRef.orderBy("date", Query.Direction.DESCENDING)
        val options = FirestoreRecyclerOptions.Builder<Expense>()
            .setQuery(query, Expense::class.java)
            .build()
        adapter = AllExpenseAdapter(options)
        val recyclerView = findViewById<RecyclerView>(R.id.recView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

    }
    override fun onStart() {
        super.onStart()
        adapter?.startListening()
    }

    override fun onStop() {
        super.onStop()

        if (adapter != null) {
            adapter!!.stopListening()
        }
    }
}

/* val query: Query = notebookRef.orderBy("priority", Query.Direction.DESCENDING)
        val options = FirestoreRecyclerOptions.Builder<Note>()
            .setQuery(query, Note::class.java)
            .build()
        adapter = NoteAdapter(options)
        val recyclerView = findViewById<RecyclerView>(R.id.recView)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter*/