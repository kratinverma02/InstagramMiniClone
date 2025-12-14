package com.instagrammini.ui.post

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.instagramminiclone.data.datastore.TokenManager
import com.example.instagramminiclone.data.network.RetrofitInstance
import com.example.instagramminiclone.data.repository.PostRepository
import com.example.instagramminiclone.viewmodel.PostViewModel

@Composable
fun CreatePostScreen(nav: NavController) {
    val context = LocalContext.current
    val vm = remember {
        PostViewModel(
            PostRepository(RetrofitInstance.api),
            TokenManager(context),
            context
        )
    }

    var imageUrl by remember { mutableStateOf("") }
    var caption by remember { mutableStateOf("") }

    Column(Modifier.padding(24.dp)) {
        OutlinedTextField(value = imageUrl, onValueChange = { imageUrl = it })
        OutlinedTextField(value = caption, onValueChange = { caption = it })

        Button(onClick = {
            vm.createPost(imageUrl, caption) {
                nav.popBackStack()
            }
        }) {
            Text("Post")
        }
    }
}

