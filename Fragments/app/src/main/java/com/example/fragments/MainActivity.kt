package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.Fragment
import com.example.fragments.ui.login.LoginFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnClock = findViewById<Button>(R.id.timeBtn)
        val btnExam = findViewById<Button>(R.id.examBtn)
        val validate = findViewById<Button>(R.id.btnValidate)


        btnClock.setOnClickListener{
           replaceFrameWitrhFragment(clock_Fragement())
        }
        
        btnExam.setOnClickListener{
            replaceFrameWitrhFragment(fragment_Exam())
            
        }

        validate.setOnClickListener{
            replaceFrameWitrhFragment(LoginFragment())
        }
    }

    private fun replaceFrameWitrhFragment(frag: Fragment) {

        val frageManger = supportFragmentManager
        val transaction = frageManger.beginTransaction()
        transaction.replace(R.id.frameLayout,frag)
        transaction.commit()

    }
}