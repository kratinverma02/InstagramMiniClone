package com.instagrammini.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.instagrammini.model.PostResponse

@Composable
fun PostItem(post: PostResponse, onLike: () -> Unit) {
    var liked by remember { mutableStateOf(false) }

    Column {
        AsyncImage(
            model = post.image_url,
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .pointerInput(Unit) {
                    detectTapGestures(
                        onDoubleTap = {
                            liked = true
                            onLike()
                        }
                    )
                }
        )

        Row(modifier = Modifier.padding(8.dp)) {
            IconButton(onClick = {
                liked = !liked
                onLike()
            }) {
                Icon(
                    imageVector = if (liked) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = null,
                    tint = if (liked) Color.Red else Color.Black
                )
            }
        }

        Text(post.caption, modifier = Modifier.padding(8.dp))
    }
}
