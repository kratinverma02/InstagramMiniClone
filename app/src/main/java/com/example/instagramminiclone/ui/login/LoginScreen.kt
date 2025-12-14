package com.instagrammini.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.instagramminiclone.data.datastore.TokenManager
import com.example.instagramminiclone.navigation.Routes
import com.example.instagramminiclone.data.network.RetrofitInstance
import com.example.instagramminiclone.data.repository.AuthRepository
import com.example.instagramminiclone.viewmodel.AuthViewModel

@Composable
fun LoginScreen(nav: NavController) {
    val context = LocalContext.current
    val vm = AuthViewModel(
        AuthRepository(RetrofitInstance.api),
        TokenManager(context)
    )

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column {
        TextField(value = email, onValueChange = { email = it })
        TextField(value = password, onValueChange = { password = it })

        Button(onClick = {
            vm.login(email, password) {
                nav.navigate(Routes.FEED) {
                    popUpTo(Routes.LOGIN) { inclusive = true }
                }
            }
        }) {
            Text("Login")
        }
    }
}

