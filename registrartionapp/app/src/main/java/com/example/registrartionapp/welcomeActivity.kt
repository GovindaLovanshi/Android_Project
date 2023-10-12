package com.example.registrartionapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class welcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val name = intent.getStringExtra(SignInActivity.KEY2 )
        val mail = intent.getStringExtra(SignInActivity.KEY1 )

        val welComeText = findViewById<TextView>(R.id.welcomeView)
        val mailText = findViewById<Button>(R.id.btnEmail)
        val nameText = findViewById<Button>(R.id.btnName)
        welComeText.text = "Welcome $name"
        mailText.text = "Mail : $mail"



    }
}