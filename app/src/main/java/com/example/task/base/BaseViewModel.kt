package com.example.task.base

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task.util.AppResult
import com.example.task.util.NetworkManager
import com.example.task.util.SingleLiveEvent
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class BaseViewModel() :
    ViewModel() {
    val statusCode = SingleLiveEvent<Int?>()
    val showError = SingleLiveEvent<String?>()
    val checkConnection = SingleLiveEvent<Boolean?>()
    private var job: Job? = null

    fun <T> call(
        serverCall: suspend () -> AppResult<T>,
        onResponse: (AppResult<T>) -> Unit
    ) {
        job = viewModelScope.launch {
            val result = serverCall()
            when (result) {
                is AppResult.Success -> {
                    onResponse(result)
                }

                is AppResult.Error -> {
                    showError.value = result.exception.message
                    statusCode.value = result.statusCode
                }

            }
        }
    }


    fun isOnline(context: Context) {
        checkConnection.value = NetworkManager.isOnline(context)
    }

    override fun onCleared() {
        super.onCleared()
        job?.cancel()
    }
}