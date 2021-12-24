package com.jagertech.youtubeapi.model.api

import android.net.Uri
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.jagertech.youtubeapi.model.api.dataformat.SearchResult
import io.reactivex.rxjava3.kotlin.subscribeBy
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiManager {
    companion object{
        const val TIMEOUT:Long = 50
        val instance = ApiManager()
    }

    private val builder = OkHttpClient.Builder()
    private var retrofit : Retrofit
    var youtubeApi :YoutubeApi

    init{

        builder
            .connectTimeout(TIMEOUT, TimeUnit.SECONDS)
            .readTimeout(TIMEOUT, TimeUnit.SECONDS)
            .writeTimeout(TIMEOUT, TimeUnit.SECONDS)

        retrofit = Retrofit.Builder()
            .baseUrl("https://www.googleapis.com/youtube/v3/")
            .client(builder.build())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        youtubeApi = retrofit.create(YoutubeApi::class.java)
    }
}