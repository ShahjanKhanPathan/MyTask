package com.example.practicetest.mypractice

sealed class NewSealedClass(name : String) {

    class MySecondClass(new : String) : NewSealedClass(new)
}


class MyThirdClass(name : String) : NewSealedClass(name)