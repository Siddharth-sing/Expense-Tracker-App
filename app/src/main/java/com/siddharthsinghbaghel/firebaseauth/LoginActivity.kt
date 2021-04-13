package com.siddharthsinghbaghel.firebaseauth

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class LoginActivity:AppCompatActivity() {

    val ref = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        val emailLogin = findViewById<TextInputEditText>(R.id.emailLogin)
        val passwordLogin = findViewById<TextInputEditText>(R.id.passLogin)
        val loginBtn = findViewById<Button>(R.id.btnLogin)

        loginBtn.setOnClickListener {
            ref.signInWithEmailAndPassword(
                emailLogin.text.toString().trim(),
                passwordLogin.text.toString().trim()
            ).addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Success", Toast.LENGTH_SHORT).show()
                    val intentMain = Intent(this,MainActivity::class.java)
                    startActivity(intentMain)
                    finish()
                }
            }.addOnFailureListener { exception ->
                Toast.makeText(applicationContext, exception.localizedMessage, Toast.LENGTH_LONG)
                    .show()
            }
        }
    }

    fun goToRegister(view: View) {
        val intentRegister= Intent(this,RegisterActivity::class.java)
        startActivity(intentRegister)
        finish()
    }
}