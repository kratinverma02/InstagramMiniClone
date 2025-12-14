package com.example.instagramminiclone.ui.profile

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ProfileScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {

        Text("Username", style = MaterialTheme.typography.headlineMedium)

        Spacer(modifier = Modifier.height(8.dp))

        Text("Followers: 120")
        Text("Following: 80")

        Spacer(modifier = Modifier.height(24.dp))

        Button(onClick = { /* Logout in Part 7 */ }) {
            Text("Logout")
        }
    }
}
