package com.example.day30videoaudioplayer

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import android.widget.SeekBar
import kotlin.time.toDuration

class MainActivity : AppCompatActivity() {
    lateinit var  mediaPlayer : MediaPlayer
    var totalTime : Int=0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
        val btnPlay = findViewById<ImageView>(R.id.play)
        val btnPause = findViewById<ImageView>(R.id.pause)
        val btnStop = findViewById<ImageView>(R.id.stop)
        val seekBarVar = findViewById<SeekBar>(R.id.seekBar)


        mediaPlayer = MediaPlayer.create(this,R.raw.music)
        mediaPlayer.setVolume(1f,1f)
        totalTime = mediaPlayer.duration


        btnPlay.setOnClickListener{
            mediaPlayer.start()
        }
        btnPause.setOnClickListener {
            mediaPlayer.stop()
        }
        btnStop.setOnClickListener{
            mediaPlayer.stop()
            mediaPlayer.reset()
            mediaPlayer.release()
        }

        seekBarVar.max = totalTime
        seekBarVar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?,progress : Int, fromeUser: Boolean) {
                if(fromeUser){
                    mediaPlayer.seekTo(progress)
                }
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }

        })

        // change the seekbar position based on the music
        val handler = Handler()
        handler.postDelayed(object : Runnable{
            override fun run() {
                try {
                    seekBarVar.progress = mediaPlayer.currentPosition
                    handler.postDelayed(this, 1000)
                }catch (exception : java.lang.Exception){
                    seekBarVar.progress = 0
                }

            }

        },0)



    }
}

