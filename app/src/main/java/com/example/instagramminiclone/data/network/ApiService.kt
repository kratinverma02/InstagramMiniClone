package com.example.instagramminiclone.data.network

import com.example.instagramminiclone.model.LoginRequest
import com.example.instagramminiclone.model.LoginResponse
import com.example.instagramminiclone.model.PostRequest
import com.example.instagramminiclone.model.PostResponse
import com.example.instagramminiclone.model.RegisterRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Header

interface ApiService {

    @POST("auth/register")
    suspend fun register(@Body body: RegisterRequest): Response<Unit>

    @POST("auth/login")
    suspend fun login(@Body body: LoginRequest): Response<LoginResponse>

    @GET("feed/")
    suspend fun feed(
        @Header("Authorization") token: String
    ): Response<List<PostResponse>>

    @POST("posts/")
    suspend fun createPost(
        @Header("Authorization") token: String,
        @Body post: PostRequest
    ): Response<Unit>
}
