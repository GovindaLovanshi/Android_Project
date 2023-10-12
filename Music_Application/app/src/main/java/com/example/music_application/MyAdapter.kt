package com.example.music_application

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(val context: Activity,val dataList:List<Data>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // create the view in case the layout manager fails to create view fo the data
        val itemView = LayoutInflater.from(context).inflate(R.layout.each_item,parent,false)
        return  MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
       return  dataList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // populate the data into the view
        val currentData = dataList[position]

        val mediaPlayer = MediaPlayer.create(context,currentData.preview.toUri())
        holder.musicTitle.text = currentData.title

        // picasso in converter link to image

        picasso.get().load(currentData.album.cover).into(holder.musicImage)

        holder.play.setOnClickListener{
            mediaPlayer.start()
        }

        holder.pause.setOnClickListener{
            mediaPlayer.stop() 
        }

    }

    class MyViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){

        val musicImage: ImageView
        val musicTitle: TextView
        val play:ImageButton
        val pause: ImageButton

        init {
            musicImage = itemView.findViewById<ImageView>(R.id.musicImage)
            musicTitle = itemView.findViewById(R.id.musicTitle)
            play = itemView.findViewById(R.id.btnPlay)
            pause = itemView.findViewById(R.id.btnPause)
        }
    }


}