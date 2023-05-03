package com.fyp.chatgpt_compose.data.repository

import com.fyp.chatgpt_compose.data.remote.BotApi
import com.fyp.chatgpt_compose.models.BrainShopResponse
import com.fyp.chatgpt_compose.util.Resource
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository @Inject constructor(
    private val api: BotApi
) {

    suspend fun getResponse(message: String): Resource<BrainShopResponse> {
        val response = try {
            api.getResponse(uid = "123", msg = message)
        } catch (e: Exception) {
            return Resource.Error("Can't fetch message" + e.message)
        }
        return Resource.Success(response)
    }


}