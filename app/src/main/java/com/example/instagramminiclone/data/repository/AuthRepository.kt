package com.example.instagramminiclone.data.repository

import com.example.instagramminiclone.model.LoginRequest
import com.example.instagramminiclone.model.RegisterRequest
import com.example.instagramminiclone.data.network.ApiService

class AuthRepository(private val api: ApiService) {

    suspend fun login(email: String, password: String) =
        api.login(LoginRequest(email, password))

    suspend fun register(username: String, email: String, password: String) =
        api.register(RegisterRequest(username, email, password))
}