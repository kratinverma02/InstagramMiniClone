package com.instagrammini.ui.feed

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.instagramminiclone.data.datastore.TokenManager
import com.example.instagramminiclone.data.network.RetrofitInstance
import com.example.instagramminiclone.data.repository.PostRepository
import com.example.instagramminiclone.viewmodel.FeedViewModel
import com.instagrammini.ui.components.PostItem

@Composable
fun FeedScreen(nav: NavController) {
    val context = LocalContext.current
    val vm = remember {
        FeedViewModel(
            PostRepository(RetrofitInstance.api),
            TokenManager(context),
            context
        )
    }

    LaunchedEffect(Unit) { vm.loadFeed() }

    LazyColumn {
        items(vm.posts) { post ->
            PostItem(post = post)
        }
    }
}



