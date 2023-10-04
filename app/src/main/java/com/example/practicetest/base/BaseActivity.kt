package com.example.practicetest.base

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding : VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        Log.d("My Practice Module","On Create From Activity")
        initView()
    }

    abstract fun initView()
    abstract fun getViewBinding() : VB


    fun showToast(message : String){
        Toast.makeText(this,message,Toast.LENGTH_LONG).show()
    }
}