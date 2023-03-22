package com.example.androidfirst

import android.os.Build
import android.os.Bundle
import android.util.DisplayMetrics
import android.util.Log
import android.view.View
import android.view.WindowMetrics
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.androidfirst.databinding.ActivityMain9Binding

class MainActivity8 : AppCompatActivity() {
    lateinit var binding: ActivityMain9Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain9Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSuljeong.setOnClickListener{v: View? ->
                binding.tvHi.setTextColor((ResourcesCompat.getColor(resources, R.color.button_color,null)))
                Log.e("MainActivity8",getString(R.string.txt_language))
                Toast.makeText(applicationContext,getString(R.string.txt_language),Toast.LENGTH_SHORT).show()
        }
        binding.tvMsg.setOnClickListener{v: View? ->
            binding.tvThank.setTextColor((ResourcesCompat.getColor(resources, R.color.button_color,null)))
            Log.e("MainActivity8",getString(R.string.txt_msg))
            Toast.makeText(applicationContext,getString(R.string.txt_msg),Toast.LENGTH_SHORT).show()
        }
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.R){
            val windowMetrics : WindowMetrics = windowManager.currentWindowMetrics
            Log.e("MainActivity8","widgh 30이상: ${windowMetrics.bounds.width()}" +
                    "height : ${windowMetrics.bounds.height()}")
        }else{
            val display = windowManager.defaultDisplay
            val displayMetrics = DisplayMetrics()
            display?.getRealMetrics(displayMetrics)
            Log.e("MainActivity8","widgh 30미만: ${displayMetrics.widthPixels}" +
                    "height : ${displayMetrics.heightPixels}")
        }

    }
}
