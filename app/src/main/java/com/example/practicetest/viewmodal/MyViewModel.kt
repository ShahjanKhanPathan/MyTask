package com.example.practicetest.viewmodal


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.practicetest.data.NetworkClass
import com.example.practicetest.modal.QuestionsListResponse
import com.example.practicetest.repository.MyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(
    private val repository: MyRepository
) : ViewModel() {

    val myQuestions : LiveData<NetworkClass<QuestionsListResponse?>>
        get() = repository._myQuestion

    fun getQuestlist() = viewModelScope.launch(Dispatchers.IO) {
        repository.getQuestions()
    }
}