package com.fyp.chatgpt_compose.ui.screens

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fyp.chatgpt_compose.data.repository.Repository
import com.fyp.chatgpt_compose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChatScreenViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    var loadError by mutableStateOf("")
    var isLoading by mutableStateOf(false)

    fun getResponse(message: String, callback: (String) -> Unit) {
        viewModelScope.launch {
            isLoading = true
            val result = repository.getResponse(message)
            when (result) {
                is Resource.Success -> {
                    val msg = result.data!!.cnt
                    Log.e("message", "message: $msg")
                    callback(msg)
                    isLoading = false
                    loadError = ""
                }

                is Resource.Error -> {
                    loadError = result.message!!
                    Log.e("error", "error $loadError")
                    isLoading = false
                }
                else -> {
                    isLoading = true
                }
            }
        }
    }


}