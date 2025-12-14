package com.example.instagramminiclone.viewmodel


import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagramminiclone.data.datastore.TokenManager
import com.example.instagramminiclone.model.PostRequest
import com.example.instagramminiclone.data.network.RetrofitInstance
import com.example.instagramminiclone.data.repository.PostRepository
import kotlinx.coroutines.launch

class PostViewModel(
    private val repo: PostRepository,
    private val tokenManager: TokenManager,
    private val context: Context
) : ViewModel() {

    fun createPost(imageUrl: String, caption: String, onDone: () -> Unit) {
        viewModelScope.launch {
            tokenManager.getToken(context).collect { token ->
                token?.let {
                    repo.createPost(it, PostRequest(imageUrl, caption))
                    onDone()
                }
            }
        }
    }
}

