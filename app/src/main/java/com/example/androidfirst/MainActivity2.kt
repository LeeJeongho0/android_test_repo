package com.example.androidfirst

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfirst.databinding.ActivitySub23Binding

class MainActivity2 : AppCompatActivity() {
    lateinit var binding6: ActivitySub23Binding
    var flag: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding6 = ActivitySub23Binding.inflate(layoutInflater)
        setContentView(binding6.root)


        binding6.btnSelectOne.setOnClickListener {
            if (flag == true) {
                binding6.screenOne.visibility = View.VISIBLE
                binding6.screenTwo.visibility = View.INVISIBLE
                flag = false
            } else {
                binding6.screenOne.visibility = View.INVISIBLE
                binding6.screenTwo.visibility = View.VISIBLE
                flag = true
            }
        }

        //FrameLayout -> LinearLayout 1번화면
        binding6.imgPictureOne.setOnClickListener {
            Toast.makeText(this, "1번화면입니다", Toast.LENGTH_SHORT).show()
        }
        //FrameLayout -> LinearLayout 2번화면
        binding6.imgPictureTwo.setOnClickListener {
            Toast.makeText(this, "2번화면입니다", Toast.LENGTH_SHORT).show()
        }

    }
}