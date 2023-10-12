package com.example.myapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SecondActivity : AppCompatActivity() {

    lateinit var dataBase : DatabaseReference
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val signUpbtn  =  findViewById<Button>(R.id.buttonSignup)
        val etName = findViewById<TextInputEditText>(R.id.etName)
        val etMail = findViewById<TextInputEditText>(R.id.etMail)
        val etPassword = findViewById<TextInputEditText>(R.id.etPassword)

        signUpbtn.setOnClickListener {

            val name = etName.text.toString()
            val mail = etMail.text.toString()
            val passWord = etPassword.text.toString()

            val user = User(name, passWord ,mail)

            dataBase = FirebaseDatabase.getInstance().getReference("Users")
            dataBase.child(name).setValue(user).addOnSuccessListener {

                etName.text?.clear()
                etMail.text?.clear()
                etPassword.text?.clear()


                Toast.makeText(this,"User Registered", Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
            }
        }

        val signInText = findViewById<TextView>(R.id.textAlert)
        signInText.setOnClickListener {
           val openSignInActivity = Intent(this,Activity3::class.java)
            startActivity(openSignInActivity)

        }

    }
}