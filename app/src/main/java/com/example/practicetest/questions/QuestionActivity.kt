package com.example.practicetest.questions

import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.practicetest.base.BaseActivity
import com.example.practicetest.data.NetworkClass
import com.example.practicetest.databinding.ActivityQuestionBinding
import com.example.practicetest.viewmodal.MyViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


@AndroidEntryPoint
class QuestionActivity : BaseActivity<ActivityQuestionBinding>() {

    private val viewModel : MyViewModel by viewModels()

    override fun initView() {
        viewModel.getQuestlist()
        getQuesList()
    }

    override fun getViewBinding() = ActivityQuestionBinding.inflate(layoutInflater)



    private fun getQuesList(){
        viewModel.myQuestions.observe(this, Observer {
            Log.d("Check",it.data.toString())
            when(it){
                is NetworkClass.onSuccess ->  {
                    val myQues = it.data.toString()

                    while (myQues in it.data!![0]?.question!!){

                    }
                }

                is NetworkClass.onFailure ->  Log.d("Error",it.message.toString())

                is  NetworkClass.onLoading -> {

                }

            }
        })
    }

    override fun onStart() {
        super.onStart()
      Log.d("My Practice Module","On Start From Activity")
    }


    override fun onResume() {
        super.onResume()
        Log.d("My Practice Module","On Resume From Activity")
    }

    override fun onPause() {
        super.onPause()
        Log.d("My Practice Module","On Pause From Activity")

    }

    override fun onStop() {
        super.onStop()
        Log.d("My Practice Module","On Stop From Activity")

    }

    override fun onRestart() {
        super.onRestart()
        Log.d("My Practice Module","On Restart From Activity")

    }



    override fun onDestroy() {
        super.onDestroy()
        Log.d("My Practice Module","On Destroy From Activity")
    }


}