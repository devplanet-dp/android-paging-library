package com.dev_planet.android_paging.service

import com.dev_planet.android_paging.model.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("users")
    fun getUsers(@Query("page") page:Int):Call<UserResponse>
}