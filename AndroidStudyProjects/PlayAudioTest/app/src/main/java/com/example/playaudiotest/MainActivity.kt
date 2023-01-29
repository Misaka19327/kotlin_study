package com.example.playaudiotest

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import com.example.playaudiotest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private val mediaPlayer = MediaPlayer()

    private val selectMusic = registerForActivityResult(ActivityResultContracts.GetContent()) { uri ->
        mediaPlayer.setDataSource(this, uri)
        mediaPlayer.prepare()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.selectMusic.setOnClickListener {
            selectMusic.launch("audio/*")
        }

        binding.play.setOnClickListener {
            if (!mediaPlayer.isPlaying) {
                mediaPlayer.start()
            }
        }
        binding.pause.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.pause()
            }
        }
        binding.stop.setOnClickListener {
            if (mediaPlayer.isPlaying) {
                mediaPlayer.reset()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
        mediaPlayer.release()
    }
}