package com.example.androidfirst

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.androidfirst.databinding.ActivityMain10Binding
import com.example.androidfirst.databinding.RegisterLayoutBinding
import com.example.androidfirst.databinding.ToastLayoutBinding

class MainActivity9 : AppCompatActivity(), View.OnClickListener, DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {
    lateinit var binding: ActivityMain10Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain10Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnToast.setOnClickListener(this)
        binding.btnDate.setOnClickListener(this)
        binding.btnTime.setOnClickListener(this)
        binding.btnDialog.setOnClickListener(this)
        binding.btnItemDialog.setOnClickListener(this)
        binding.btnMultiItemDialog.setOnClickListener(this)
        binding.btnSingleItemDialog.setOnClickListener(this)
        binding.btnCustomDialog.setOnClickListener(this)
        binding.btnFindLocate.setOnClickListener(this)
        binding.btnRington.setOnClickListener(this)

    }

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btnToast -> {
                val toast = Toast.makeText(applicationContext, "토스트메시지", Toast.LENGTH_SHORT)
                toast.duration = Toast.LENGTH_LONG
                toast.setGravity(Gravity.TOP, 0, 200)
//                val toastLayout = LayoutInflater.from(applicationContext).inflate(R.layout.toast_layout,null)
//                toast.view = toastLayout.rootView
                var toastLayoutBinding: ToastLayoutBinding
                toastLayoutBinding = ToastLayoutBinding.inflate(layoutInflater)
                toast.view = toastLayoutBinding.root
                toast.show()
            }
            R.id.btnDate -> {
                DatePickerDialog(this, this, 2023, 3 - 1, 23).show()
            }
            R.id.btnTime -> {
                TimePickerDialog(this,this, 13, 45,true).show()
            }
            R.id.btnDialog -> {
                val eventHandler = object: DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Toast.makeText(this@MainActivity9,"${if(which==-1){"ok"}else{"no"}}클릭하셨어요",Toast.LENGTH_SHORT).show()
                    }
                }
                AlertDialog.Builder(this).run {
                    setTitle("알림창")
                    setIcon(R.drawable.computer_24)
                    setMessage("알림창 정보를 보여드립니다.")
                    setPositiveButton("YES", eventHandler)
                    setNegativeButton("NO", eventHandler)
                    show()
                }
            }
            R.id.btnItemDialog -> {
                val eventHandler = object: DialogInterface.OnClickListener{
                    override fun onClick(dialog: DialogInterface?, which: Int) {
                        Toast.makeText(this@MainActivity9,"${if(which==-1){"ok"}else{"no"}}클릭하셨어요",Toast.LENGTH_SHORT).show()
                    }
                }
                val items = arrayOf<String>("홍길동", "저길동", "고길동", "중길동")
                AlertDialog.Builder(this).run {
                    setTitle("알림창")
                    setIcon(R.drawable.computer_24)
                    setItems(items, object:DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            binding.btnItemDialog.text = items[which]
                        }
                    })
                    setNegativeButton("NO", eventHandler)
                    show()
                }
            }
            R.id.btnMultiItemDialog -> {
                val items = arrayOf<String>("홍길동", "저길동", "고길동", "중길동")
                AlertDialog.Builder(this).run {
                    setTitle("알림창")
                    setIcon(R.drawable.computer_24)
                    setMultiChoiceItems(items, booleanArrayOf(true,false,false,false), object:DialogInterface.OnMultiChoiceClickListener{
                        override fun onClick(
                            dialog: DialogInterface?,
                            which: Int,
                            isChecked: Boolean
                        ) {
                            if(isChecked == true){
                                binding.btnMultiItemDialog.text = items[which]
                            }
                        }

                    })
                    setPositiveButton("YES", object:DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            Toast.makeText(applicationContext,"선택했습니다",Toast.LENGTH_SHORT).show()
                        }

                    })
                    setNegativeButton("Cancel", null)
                    show()
                }
            }
            R.id.btnSingleItemDialog -> {
                val items = arrayOf<String>("홍길동", "저길동", "고길동", "중길동")
                AlertDialog.Builder(this).run {
                    setTitle("알림창")
                    setIcon(R.drawable.computer_24)
                    setSingleChoiceItems(items,0 ,object:DialogInterface.OnClickListener{
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            binding.btnSingleItemDialog.text = items[which]
                        }
                    })
                    setNegativeButton("Close", null)
                    setCancelable(false)
                    show()
                }
            }
            R.id.btnCustomDialog -> {
                val userBinding: RegisterLayoutBinding
                val dialogBuilder = AlertDialog.Builder(this)
                val userDialog:AlertDialog

                //사용자화면 인플렉션하기
                userBinding = RegisterLayoutBinding.inflate(layoutInflater)
                //사용자다이얼로그 제목, 뷰설정 보이기
                dialogBuilder.setTitle("사용자 이름 입력하기")
                dialogBuilder.setIcon(R.drawable.computer_24)
                dialogBuilder.setView(userBinding.root)
                //dialogBuilder.create() dialogBuilder정보를 dismiss()새로추가해서 userDialog에 넘겨줌.
                userDialog = dialogBuilder.create()
                userDialog.show()
                //이벤트처리하기
                userBinding.btnCancel.setOnClickListener{
                    Toast.makeText(applicationContext,"취소합니다",Toast.LENGTH_SHORT).show()
                    userDialog.dismiss()
                }
                userBinding.btnRegister.setOnClickListener {
                    binding.tvMessage.text = userBinding.edtName.text.toString()
                    userDialog.dismiss()
                }

            }
            R.id.btnFindLocate -> {
                val state = ContextCompat.checkSelfPermission(applicationContext, "android.permission.ACCESS_FINE_LOCATION")
                if(state == PackageManager.PERMISSION_GRANTED){
                    binding.tvMessage.text = "위치추적권한허용"
                }else{
                    binding.tvMessage.text = "위치추적권한불허"
                }
            }
            R.id.btnRington -> {
                //Uniform Resource Identifer, 리소스를 구분하는 식별자.
                //안드로이드에서 URI의 역할은 리소스(외부 앱, 이미지, 텍스트 등)에 접근할 수 있는 식발자 역할
                val notificationUri: Uri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
                val rington = RingtoneManager.getRingtone(applicationContext, notificationUri)
                rington.play()
            }
        }
    }

    //콜백함수
    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        Toast.makeText(applicationContext, "${year} ${month + 1} ${dayOfMonth}", Toast.LENGTH_SHORT).show()
    }

    override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
        Toast.makeText(applicationContext,"${hourOfDay}시 ${minute}분",Toast.LENGTH_SHORT).show()
    }
}