package com.example.ch18_network_test.retrofit

import com.example.ch18_network_test.model.PageListModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.*

interface NetworkService {

    @GET("/api/food/img")
    fun getList(
        @Query("serviceKey") serviceKey: String?,
        @Query("pageNo") pageNo: Int
    ): Call<PageListModel>

}