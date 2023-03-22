package com.example.androidfirst

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.example.androidfirst.databinding.ActivityMain7Binding

class MainActivity6 : AppCompatActivity() {
    lateinit var binding: ActivityMain7Binding
    var pauseTime = 0L
    var initTime = 0L
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain7Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                binding.tvMessage.text = getString(R.string.btn_start)
                binding.tvMessage.textSize = resources.getDimension(R.dimen.txt_large)
                binding.tvMessage.setTextColor((ResourcesCompat.getColor(resources, R.color.txt_color2,null)))
                binding.chronometer.base = SystemClock.elapsedRealtime() + pauseTime
                binding.chronometer.start()
                binding.btnStart.isEnabled = false
                binding.btnStop.isEnabled = true
                binding.btnReset.isEnabled = true
            }
        })
        binding.btnStop.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                binding.tvMessage.text = getString(R.string.btn_stop)
                binding.tvMessage.textSize = resources.getDimension(R.dimen.txt_small)
                binding.tvMessage.setTextColor((ResourcesCompat.getColor(resources, R.color.txt_color,null)))
                pauseTime = binding.chronometer.base - SystemClock.elapsedRealtime()
                binding.chronometer.stop()
                binding.btnStart.isEnabled = true
                binding.btnStop.isEnabled = false
                binding.btnReset.isEnabled = true
            }
        })
        binding.btnReset.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                binding.tvMessage.text = getString(R.string.btn_reset)
                binding.tvMessage.textSize = resources.getDimension(R.dimen.txt_medium)
                binding.chronometer.base = SystemClock.elapsedRealtime()
                binding.chronometer.stop()
                pauseTime = 0L
                binding.btnStart.isEnabled = true
                binding.btnStop.isEnabled = false
                binding.btnReset.isEnabled = false
            }
        })
    }

    override fun onBackPressed() {
        if (System.currentTimeMillis() - initTime > 3000) {
            binding.tvMessage.text = getString(R.string.btn_back)
            Toast.makeText(this@MainActivity6, getString(R.string.btn_back), Toast.LENGTH_SHORT).show()
            initTime = System.currentTimeMillis()
        }else{
            super.onBackPressed()
        }
    }
}

//백버튼 가져올려고 한다. (볼륨조절, 전원, 백버튼)
//    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
//        if (keyCode == KeyEvent.KEYCODE_BACK) {
//            if (System.currentTimeMillis() - initTime > 3000) {
//                Toast.makeText(this@MainActivity6, "3초안에 한 번 더 눌러주세요", Toast.LENGTH_SHORT).show()
//                initTime = System.currentTimeMillis()
//                return true
//            }
//        }
//        return super.onKeyDown(keyCode, event)
//    }




