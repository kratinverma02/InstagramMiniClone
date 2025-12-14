package com.example.instagramminiclone.model

data class PostResponse(
    val id: Int,
    val image_url: String,
    val caption: String,
    val user_id: Int
)