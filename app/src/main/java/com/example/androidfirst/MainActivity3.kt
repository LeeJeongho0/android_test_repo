package com.example.androidfirst

import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.androidfirst.databinding.ActivityMain4Binding

class MainActivity3 : AppCompatActivity(),CompoundButton.OnCheckedChangeListener {
    lateinit var binding: ActivityMain4Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.ckbClick.setOnCheckedChangeListener(this)
        binding.ckbClick2.setOnCheckedChangeListener(this)

        binding.ckbClick3.setOnCheckedChangeListener(object :
            CompoundButton.OnCheckedChangeListener {
            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
                Toast.makeText(applicationContext, "3번 체크박스", Toast.LENGTH_SHORT).show()
            }
        })
        binding.ckbClick4.setOnCheckedChangeListener { buttonView: CompoundButton?, isChecked: Boolean ->
            Toast.makeText(applicationContext, "4번 체크박스", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
        when(buttonView?.id){
            R.id.ckbClick -> Toast.makeText(applicationContext,"1번 체크박스",Toast.LENGTH_SHORT).show()
            R.id.ckbClick2 -> Toast.makeText(applicationContext,"2번 체크박스",Toast.LENGTH_SHORT).show()
        }
    }
}





