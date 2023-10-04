package com.example.practicetest

import com.example.practicetest.data.Consts
import com.example.practicetest.kotlinmodel.MyQuesList
import com.example.practicetest.kotlinmodel.MyQuesListItem
import com.example.practicetest.modal.QuestionsListResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @GET(Consts.END_POINT) 
    suspend fun getQuestionList() : Response<List<MyQuesListItem?>>
}