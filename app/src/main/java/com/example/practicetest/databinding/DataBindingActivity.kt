package com.example.practicetest.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.practicetest.R

class DataBindingActivity : AppCompatActivity() {
    private lateinit var binding : ActivityDataBindingBinding
    lateinit var myViewModel : DataBindingViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myData = DataHolderClass("Nature Effects","https://images.unsplash.com/photo-1597431834637-9b1ec1df1b77?crop=entropy&cs=tinysrgb&fit=crop&fm=jpg&h=800&ixid=MnwxfDB8MXxyYW5kb218MHx8fHx8fHx8MTY5NTI5Njc4MQ&ixlib=rb-4.0.3&q=80&utm_campaign=api-credit&utm_medium=referral&utm_source=unsplash_source&w=1900")
        binding = DataBindingUtil.setContentView(this,R.layout.activity_data_binding)
        myViewModel = ViewModelProvider(this)[DataBindingViewModel::class.java]
        binding.myViewModel = myData
        binding.lifecycleOwner = this
    }
}