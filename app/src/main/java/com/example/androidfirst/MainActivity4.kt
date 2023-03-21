package com.example.androidfirst

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfirst.databinding.ActivityMain5Binding

class MainActivity4 : AppCompatActivity(), View.OnClickListener {
    lateinit var binding: ActivityMain5Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain5Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnClick1.setOnClickListener(this)
        binding.btnClick2.setOnClickListener(this)

        binding.btnClick3.setOnClickListener(object:View.OnClickListener{
            override fun onClick(v: View?) {
                Toast.makeText(applicationContext,"버튼 3번누름",Toast.LENGTH_SHORT).show()
            }
        })
        binding.btnClick4.setOnClickListener{v: View? ->
                Toast.makeText(applicationContext,"버튼 4번누름",Toast.LENGTH_SHORT).show()
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnClick1 -> {
                Toast.makeText(applicationContext,"버튼 1번누름",Toast.LENGTH_SHORT).show()
            }
            R.id.btnClick2 -> {
                Toast.makeText(applicationContext,"버튼 2번누름",Toast.LENGTH_SHORT).show()
            }
            else -> null
        }
    }
}