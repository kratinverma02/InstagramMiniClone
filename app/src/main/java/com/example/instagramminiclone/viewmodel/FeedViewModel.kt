package com.example.instagramminiclone.viewmodel

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.instagramminiclone.data.datastore.TokenManager
import com.example.instagramminiclone.model.PostResponse
import com.example.instagramminiclone.data.repository.PostRepository
import kotlinx.coroutines.launch

class FeedViewModel(
    private val repo: PostRepository,
    private val tokenManager: TokenManager,
    private val context: Context
) : ViewModel() {

    var posts by mutableStateOf<List<PostResponse>>(emptyList())
        private set

    fun loadFeed() {
        viewModelScope.launch {
            tokenManager.getToken(context).collect { token ->
                token?.let {
                    val res = repo.getFeed(it)
                    if (res.isSuccessful) posts = res.body()!!
                }
            }
        }
    }
}



