package com.example.adapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import kotlin.concurrent.timerTask

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.ListView)

        val taskList = arrayListOf<String>()
        taskList.add("Visit HANUMAN MANDIR ")
        taskList.add("Attend Exam")
        taskList.add("Complete The App Dev Project")
        taskList.add("Buy Subji From Market")
        taskList.add("Watching the Cricket Match")

        val adapterForMyListView = ArrayAdapter(this, android.R.layout.simple_list_item_1,taskList)
        listView.adapter = adapterForMyListView
        listView.setOnItemClickListener {  parent, view, position, ld ->

        val text = "Clicked On Item: " +(view as TextView).text.toString()
            Toast.makeText(this, text,Toast.LENGTH_SHORT).show()

        }
    }
}