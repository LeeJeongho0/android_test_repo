package com.example.androidfirst

var student: String? = null



fun main() {
    class NonDataClass(var name: String, var email:String, var age:Int)
    data class DataClass(var name: String, var email:String, var age:Int)

    val nonObj1 = NonDataClass("kim","kim@nate",20)
    val nonObj2 = NonDataClass("kim","kim@nate",20)
    val dataObj1 = DataClass("kim","kim@nate",20)
    val dataObj2 = DataClass("kim","kim@nate",20)

    println("nonObj1 == nonObj2 : ${nonObj1 == nonObj2}")
    println("nonObj1.equals(nonObj2) : ${nonObj1.equals(nonObj2)}")
    println("dataObj1 == dataObj2 : ${dataObj1 == dataObj2}")
    println("dataObj1.equals(dataObj2) : ${dataObj1.equals(dataObj2)}")

    println(nonObj1.toString())
    println(dataObj1.toString())
}