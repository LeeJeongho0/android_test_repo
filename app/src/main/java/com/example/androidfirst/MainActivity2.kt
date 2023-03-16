package com.example.androidfirst

import android.os.Bundle
import android.text.InputType
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfirst.databinding.ActivitySub11Binding
import com.example.androidfirst.databinding.ActivitySub13Binding
import com.example.androidfirst.databinding.ActivitySub15Binding
import com.example.androidfirst.databinding.ActivitySub16Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding: ActivitySub11Binding
    lateinit var binding2: ActivitySub13Binding
    lateinit var binding3: ActivitySub15Binding
    lateinit var binding4: ActivitySub16Binding
    var flag:Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySub11Binding.inflate(layoutInflater)
        binding2 = ActivitySub13Binding.inflate(layoutInflater)
        binding3 = ActivitySub15Binding.inflate(layoutInflater)
        binding4 = ActivitySub16Binding.inflate(layoutInflater)
        setContentView(binding4.root)


       binding4.tvClick.setOnLongClickListener {
           binding4.edtPassword.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
           Toast.makeText(applicationContext,binding4.edtPassword.text.toString(), Toast.LENGTH_SHORT).show()
           return@setOnLongClickListener(true)
       }
        binding4.edtPassword.setOnClickListener{
            binding4.edtPassword.inputType = InputType.TYPE_TEXT_VARIATION_PASSWORD
        }

//        binding2.btnClick.setOnClickListener {
//            if(flag == true){
//                binding2.btnTarget.visibility = View.VISIBLE
//                binding2.btnGone.visibility = View.VISIBLE
//                flag = false
//            } else{
//                binding2.btnTarget.visibility = View.INVISIBLE
//                binding2.btnGone.visibility = View.GONE
//                flag = true
//            }
//        }
    }
}