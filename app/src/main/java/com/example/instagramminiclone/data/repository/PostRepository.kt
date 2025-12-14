package com.example.instagramminiclone.data.repository

import com.example.instagramminiclone.model.PostRequest
import com.example.instagramminiclone.data.network.ApiService

class PostRepository(private val api: ApiService) {

    suspend fun getFeed(token: String) =
        api.getFeed("Bearer $token")

    suspend fun createPost(token: String, post: PostRequest) =
        api.createPost("Bearer $token", post)
}
