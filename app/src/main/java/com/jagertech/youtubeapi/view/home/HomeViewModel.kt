package com.jagertech.youtubeapi.view.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jagertech.youtubeapi.model.api.ApiManager
import com.jagertech.youtubeapi.model.api.dataformat.Items
import com.jagertech.youtubeapi.model.api.dataformat.SearchResult
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    val searchResultLiveData = MutableLiveData<List<Items>>()

    var q: String = ""

    var nextPageToken: String = ""

    var prevPageToken: String = ""

    fun searchVideo(q: String) {
        this.q = q
        ApiManager.instance.youtubeApi.searchVideo(q).enqueue(object : Callback<SearchResult>{
            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                searchResultLiveData.value = response.body()?.items
                nextPageToken = response.body()?.nextPageToken ?: ""
                prevPageToken = response.body()?.prevPageToken ?: ""
            }

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun nextPage(){
        ApiManager.instance.youtubeApi.searchVideo(q, pageToken = nextPageToken).enqueue(object : Callback<SearchResult>{
            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                searchResultLiveData.value = response.body()?.items
                nextPageToken = response.body()?.nextPageToken ?: ""
                prevPageToken = response.body()?.prevPageToken ?: ""
            }

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }

    fun prevPage(){
        ApiManager.instance.youtubeApi.searchVideo(q, pageToken = prevPageToken).enqueue(object : Callback<SearchResult>{
            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
                searchResultLiveData.value = response.body()?.items
                nextPageToken = response.body()?.nextPageToken ?: ""
                prevPageToken = response.body()?.prevPageToken ?: ""
            }

            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
                TODO("Not yet implemented")
            }

        })
    }
}