package com.jagertech.youtubeapi.model.api

import com.jagertech.youtubeapi.model.api.dataformat.SearchResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface YoutubeApi{
    companion object{
        const val apiKey = "AIzaSyB_GFIckyo-V5qP07SdL1eHBAJ67y_zRxc"
    }

    @GET("search")
    fun searchVideo(
        @Query("q") q: String,
        @Query("key") key: String = apiKey,
        @Query("pageToken") pageToken: String = "",
        @Query("part") part: String = "snippet",
        @Query("maxResults") maxResults: Int = 10,
        @Query("regionCode") regionCode: String = "TW",
    ):Call<SearchResult>
}