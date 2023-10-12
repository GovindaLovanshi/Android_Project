package com.example.recycleviewapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    lateinit var myRecyclerView : RecyclerView
    lateinit var newsArrayList: ArrayList<News>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myRecyclerView = findViewById(R.id.recyclerView)

        var imageArray = arrayOf(
            R.drawable.images,
            R.drawable.download



        )

        var newsHeading = arrayOf(
          "BabaSaheb B.R Ambedkar Contribution nations Building ",
        "News Supreme Court High court "
        )
         // to set hav bhav of items inside recyclerView vertically horizontally , uniform
        myRecyclerView.layoutManager = LinearLayoutManager(this)
        newsArrayList = arrayListOf<News>()

        for(index in imageArray.indices){
            val news = News(newsHeading[index],imageArray[index])
            newsArrayList.add(news)
        }

        myRecyclerView.adapter = MyAdapter(newsArrayList,this)
    }
}