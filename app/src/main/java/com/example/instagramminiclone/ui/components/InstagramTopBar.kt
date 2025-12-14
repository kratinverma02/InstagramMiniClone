package com.example.instagramminiclone.ui.components

import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@Composable
fun InstagramTopBar(title: String) {
    TopAppBar(
        title = {
            Text(text = title, style = MaterialTheme.typography.titleLarge)
        }
    )
}