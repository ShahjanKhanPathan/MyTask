package com.example.practicetest.databinding

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DataBindingViewModel : ViewModel() {

     val MyData = MutableLiveData("Here is the Base Data")

    fun onReplace(){
        MyData.value = "Here is Data Changed From Click"
    }
}