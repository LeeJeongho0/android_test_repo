package com.example.androidfirst

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfirst.databinding.ActivityMain6Binding

class MainActivity5 : AppCompatActivity() {
    lateinit var binding: ActivityMain6Binding
    var pauseTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain6Binding.inflate(layoutInflater)
        setContentView(binding.root)
//        binding.btnStart.setOnClickListener(this)
//        binding.btnStop.setOnClickListener(this)
//        binding.btnReset.setOnClickListener(this)
        binding.btnStart.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
                binding.chronometer.start()
                binding.btnStart.isEnabled = false
                binding.btnStop.isEnabled = true
                binding.btnReset.isEnabled = true
            }
        })
        binding.btnStop.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
                binding.chronometer.stop()
                binding.btnStart.isEnabled = true
                binding.btnStop.isEnabled = false
                binding.btnReset.isEnabled = true
            }
        })
        binding.btnReset.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                binding.chronometer.base = SystemClock.elapsedRealtime()
                pauseTime = 0L
                binding.chronometer.stop()
                binding.btnStart.isEnabled = true
                binding.btnStop.isEnabled = false
                binding.btnReset.isEnabled = false
            }

        })

    }

    //SystemClock.elapsedRealtime() : 컴퓨터 부팅부터 시작하여 경과된시간
//    override fun onClick(v: View?) {
//        when (v?.id) {
//            R.id.btnStart -> {
//                binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
//                binding.chronometer.start()
//                binding.btnStart.isEnabled = false
//                binding.btnStop.isEnabled = true
//                binding.btnReset.isEnabled = true
//            }
//            R.id.btnStop -> {
//                pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
//                binding.chronometer.stop()
//                binding.btnStart.isEnabled = true
//                binding.btnStop.isEnabled = false
//                binding.btnReset.isEnabled = true
//            }
//            R.id.btnReset -> {
//                binding.chronometer.base = SystemClock.elapsedRealtime()
//                pauseTime = 0L
//                binding.chronometer.stop()
//                binding.btnStart.isEnabled = true
//                binding.btnStop.isEnabled = false
//                binding.btnReset.isEnabled = false
//            }
//            else -> null
//        }
//
//    }
}