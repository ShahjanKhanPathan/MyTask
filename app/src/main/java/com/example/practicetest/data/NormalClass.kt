package com.example.practicetest.data

fun main(){
val myDays = Days.Tuesday
    println(myDays.dayCount)
}

enum class Days(val dayCount : Int){
    Sunday(1),
    Monday(2),
    Tuesday(3),
    Wednesday(4),
    Thursday(5),
    Friday(6),
    Saturday(7)
}