package com.example.androidfirst

import java.text.SimpleDateFormat
import java.util.*


fun main() {

    var data:Int = 20
    data = 30
    //템플릿 문자열
    println("data = ${data}")


    var value:String? = formatDate(Date())
    println("date = ${value}")

    var user: User = User()
    user.sayHello()
    println("name = ${user.name}")
}

fun formatDate(date: Date):String?{
    val sdf: SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    return sdf.format(date)
}

public class User{
    //멤버변수
    public var name: String = "Hello"
    //멤버함수
    public fun sayHello():Unit{
        println("name = ${this.name}")
    }
}