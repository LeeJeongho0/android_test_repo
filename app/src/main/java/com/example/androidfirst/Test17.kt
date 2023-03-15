package com.example.androidfirst

fun main() {
//    val myClass:MyClass = MyClass()
    println(MyClass.data)
    println(MyClass.sum())
}

class MyClass constructor(){
    companion object{
        var data = 10
        fun sum(){
            println("static member variable = ${MyClass.data}")
        }
    }
}