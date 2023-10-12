package com.example.bindingview

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.bindingview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            if(binding.checkBox.isChecked){

            }else{
                binding.checkBox.backgroundTintList = getColorStateList(Color.RED)
                Toast.makeText(this,"Please Accept term And Condition",Toast.LENGTH_SHORT).show()
            }
        }

    }
}