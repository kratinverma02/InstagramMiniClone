package com.example.instagramminiclone.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagramminiclone.data.datastore.TokenManager
import com.example.instagramminiclone.data.repository.AuthRepository
import kotlinx.coroutines.launch

class AuthViewModel(
    private val repo: AuthRepository,
    private val tokenManager: TokenManager,
    private val context: Context
) : ViewModel() {

    fun login(email: String, password: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            val res = repo.login(email, password)
            if (res.isSuccessful) {
                tokenManager.saveToken(context, res.body()!!.token)
                onSuccess()
            }
        }
    }

    fun register(username: String, email: String, password: String, onSuccess: () -> Unit) {
        viewModelScope.launch {
            val res = repo.register(username, email, password)
            if (res.isSuccessful) onSuccess()
        }
    }
}










