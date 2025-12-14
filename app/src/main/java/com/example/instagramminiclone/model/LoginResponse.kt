package com.example.instagramminiclone.model

data class LoginResponse(
    val token: String,
    val user_id: Int,
    val username: String
)