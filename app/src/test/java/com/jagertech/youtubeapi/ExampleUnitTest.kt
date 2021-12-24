package com.jagertech.youtubeapi

import android.app.appsearch.SearchResults
import com.jagertech.youtubeapi.model.api.ApiManager
import com.jagertech.youtubeapi.model.api.dataformat.SearchResult
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Before
    fun api(){
//        ApiManager().youtubeApi.searchVideo().enqueue(object: Callback<SearchResult>{
//            override fun onResponse(call: Call<SearchResult>, response: Response<SearchResult>) {
//                System.out.println("S");
//            }
//
//            override fun onFailure(call: Call<SearchResult>, t: Throwable) {
//                System.out.println("E");
//            }
//
//        })
    }

    @Test
    fun addition_isCorrect() {
//        System.out.println("E");

//        assertEquals(4, 2 + 2)
    }

    @After
    fun result(){

    }
}