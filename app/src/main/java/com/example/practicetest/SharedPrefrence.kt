package com.example.practicetest

import android.content.Context
import android.content.SharedPreferences


const val MY_PREFERENCE_FILE = "my_preference_file"
const val MY_ANSWER = "my_answer"
class SharedPreference(context: Context) {


   private var myShared = context.getSharedPreferences(MY_PREFERENCE_FILE,Context.MODE_PRIVATE)

    fun saveAnswer(answer: String) {
        val myEditor = myShared.edit()
        myEditor.putString(MY_ANSWER, answer)
        myEditor.apply()
    }

    fun getAnswer(): String? {
        return myShared.getString(MY_ANSWER, "")
    }

}