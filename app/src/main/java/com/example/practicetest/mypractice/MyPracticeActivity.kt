package com.example.practicetest.mypractice

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import com.example.practicetest.R
import com.example.practicetest.base.BaseActivity
import com.example.practicetest.databinding.ActivityMyPracticeBinding
import com.example.practicetest.services.MyService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import kotlin.concurrent.thread

class MyPracticeActivity : BaseActivity<ActivityMyPracticeBinding>() {

    override fun getViewBinding() = ActivityMyPracticeBinding.inflate(layoutInflater)

    override fun initView() {
        CoroutineScope(Dispatchers.Main).launch {
        myLongRunningFunction()
        }

        lifecycleScope.launch(Dispatchers.Main) {
            myTaskOne()
        }

        lifecycleScope.launch(Dispatchers.Main) {
            myTaskTwo()
        }
//        for (i in 0..100 step 5){
//            Log.d("myLoop",i.toString())
//        }
//
//        for (j in 100 downTo 0 step  5){
//            Log.d("myDownStep",j.toString())
//        }
//
//
//        myClicks()

    }

    private suspend fun myLongRunningFunction() {
        delay(10000)
    }

    private fun myClicks() {
        binding.apply {
            txtStart.setOnClickListener(myClick)
            txtStop.setOnClickListener(myClick)
            btnRun.setOnClickListener(myClick)
        }
    }

    private val myClick : View.OnClickListener = View.OnClickListener {
        when(it.id){
            R.id.txtStart -> startService(Intent(this@MyPracticeActivity, MyService::class.java))

            R.id.txtStop -> stopService(Intent(this@MyPracticeActivity, MyService::class.java))

            R.id.btnRun -> myLongRunningTask()
        }
    }

    private fun myLongRunningTask() {
        Log.d("long Fun","Pressed")
        thread(start = true){

        for (i in 1..100000000L){

        }
        }
    }


    suspend fun myTaskOne(){
        Log.d("My Tasks","Task One Started")
        yield()
        Log.d("My Tasks","Task One Ended")
    }


    suspend fun myTaskTwo(){
        Log.d("My Tasks","Task Two Started")
        yield()
        Log.d("My Tasks","Task Two Ended")
    }


}