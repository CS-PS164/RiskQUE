package com.bangkit.riskque.data.remote

import com.bangkit.riskque.model.GetDplkResponse
import com.bangkit.riskque.model.LoginResponse
import com.bangkit.riskque.model.RegisterResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @POST("login")
    @FormUrlEncoded
    fun doLogin(
        @Field("email") email: String, @Field("password") password: String
    ): Call<LoginResponse>

    @POST("register")
    @FormUrlEncoded
    fun doRegister(
        @Field("name") name: String,
        @Field("email") email: String,
        @Field("password") password: String
    ): Call<RegisterResponse>

    @GET("stories")
    suspend fun getDplkList(
        @Header("Authorization") token: String,
        @Query("page") page: Int,
        @Query("size") size: Int
    ): GetDplkResponse
}