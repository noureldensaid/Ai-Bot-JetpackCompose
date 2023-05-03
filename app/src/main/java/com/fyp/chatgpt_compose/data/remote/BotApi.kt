package com.fyp.chatgpt_compose.data.remote

import com.fyp.chatgpt_compose.models.BrainShopResponse
 import com.fyp.chatgpt_compose.util.Constants.API_KEY
import com.fyp.chatgpt_compose.util.Constants.BRAIN_ID
import com.fyp.chatgpt_compose.util.Constants.USER_ID
import retrofit2.http.GET
import retrofit2.http.Query

interface BotApi {

    @GET("get")
    suspend fun getResponse(
        @Query("bid") bid: String = BRAIN_ID,
        @Query("key") key: String = API_KEY,
        @Query("uid") uid: String,
        @Query("msg") msg: String
    ): BrainShopResponse
}