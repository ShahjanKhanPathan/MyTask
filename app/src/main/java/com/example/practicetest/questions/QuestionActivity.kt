package com.example.practicetest.questions

import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.practicetest.base.BaseActivity
import com.example.practicetest.data.NetworkClass
import com.example.practicetest.databinding.ActivityQuestionBinding
import com.example.practicetest.viewmodal.MyViewModel
import dagger.hilt.android.AndroidEntryPoint

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
                is NetworkClass.onSuccess ->  Log.d("On Success",it.data.toString())

                is NetworkClass.onFailure ->  Log.d("Error",it.message.toString())

                is  NetworkClass.onLoading -> {

                }

            }
        })
    }


}