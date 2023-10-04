package com.example.practicetest.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.practicetest.ApiInterface
import com.example.practicetest.data.NetworkClass
import com.example.practicetest.kotlinmodel.MyQuesListItem
import javax.inject.Inject

class MyRepository @Inject constructor(private val apiInterface: ApiInterface) {

    private val myQuestions = MutableLiveData<NetworkClass<List<MyQuesListItem?>>>()

    val _myQuestion : LiveData<NetworkClass<List<MyQuesListItem?>>>
        get() = myQuestions


     suspend fun getQuestions(){
        myQuestions.postValue(NetworkClass.onLoading())
       val response =  apiInterface.getQuestionList()
        if (response.isSuccessful && response.body() != null){
            myQuestions.postValue(NetworkClass.onSuccess(response.body()))
       }
    }
}


