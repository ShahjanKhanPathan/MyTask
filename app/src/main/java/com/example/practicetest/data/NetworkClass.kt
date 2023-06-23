package com.example.practicetest.data

sealed class NetworkClass<T>(val data : T? = null, val message : String? = null) {
    class onSuccess<T>(data: T?) : NetworkClass<T>(data)
    class onFailure<T>(data: T?,message: String?) : NetworkClass<T>(data, message)
    class onLoading<T>() : NetworkClass<T>()
}