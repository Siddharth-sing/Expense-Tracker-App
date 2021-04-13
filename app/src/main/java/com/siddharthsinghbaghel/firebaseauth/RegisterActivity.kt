package com.siddharthsinghbaghel.firebaseauth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    val ref = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)


        val email=findViewById<TextInputEditText>(R.id.login_email)
        val password=findViewById<TextInputEditText>(R.id.login_password)
        val registerBtn=findViewById<Button>(R.id.register_button)

        registerBtn.setOnClickListener {
            ref.createUserWithEmailAndPassword(
                    email.text.toString().trim(),
                    password.text.toString().trim()
            ).addOnCompleteListener{
                if(it.isSuccessful)
                {
                   Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
                    val intent= Intent(this,LoginActivity::class.java)
                    startActivity(intent)

                }
            }.addOnFailureListener{
                Toast.makeText(this,"Success",Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun goToLogin(view: View) {

        val intent= Intent(this,LoginActivity::class.java)
        startActivity(intent)
        finish()
    }




}