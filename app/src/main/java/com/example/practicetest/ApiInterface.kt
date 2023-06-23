package com.example.practicetest

import com.example.practicetest.data.Consts
import com.example.practicetest.modal.QuestionsListResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiInterface {

    @GET(Consts.END_POINT)
    suspend fun getQuestionList() : Response<QuestionsListResponse?>
}