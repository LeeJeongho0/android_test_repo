package com.example.androidfirst

import android.os.Bundle
import android.util.Log
import android.view.MotionEvent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfirst.databinding.ActivityMain4Binding

class MainActivity3 : AppCompatActivity() {
    lateinit var binding: ActivityMain4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                Toast.makeText(applicationContext, "터치를 했습니다", Toast.LENGTH_SHORT).show()
                Log.d("MainActivity3","터치클릭 x = ${event?.x} rawx = ${event?.rawX}")
            }
            MotionEvent.ACTION_UP -> {
                Toast.makeText(applicationContext, "터치를 해제 했습니다", Toast.LENGTH_SHORT).show()
                Log.d("MainActivity3","터치를 해제 했습니다")
            }
        }

        return super.onTouchEvent(event)
    }
}