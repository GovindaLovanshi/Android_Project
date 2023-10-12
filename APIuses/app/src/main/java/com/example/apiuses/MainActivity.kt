    package com.example.apiuses

import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var myadapter : MyAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView=findViewById(R.id.recyclerView)



       val retroFitBuilder = Retrofit.Builder()
           .baseUrl("https://dummyjson.com/")
           .addConverterFactory(GsonConverterFactory.create())
           .build()
           .create(APIInterface::class.java)


        val retrofit = retroFitBuilder.getProductData()

        retrofit.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                // if api call is a success then use the data in API and shoe in your application
                val responseBody = response.body()
                val productList = responseBody?.products !! //(!! -->  if(productList != null)

                myadapter = MyAdapter(this@MainActivity,productList)
                recyclerView.adapter = myadapter
                recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)


            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
             // if api call is fail
                Log.d("Main Activity", "onFailure: "+ t.message)


            }
        })
    }
}