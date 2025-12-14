package com.example.instagramminiclone.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.instagramminiclone.ui.profile.ProfileScreen
import com.instagrammini.ui.login.LoginScreen
import com.instagrammini.ui.signup.SignupScreen
import com.instagrammini.ui.feed.FeedScreen
import com.instagrammini.ui.post.CreatePostScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = Routes.LOGIN) {
        composable(Routes.LOGIN) { LoginScreen(navController) }
        composable(Routes.SIGNUP) { SignupScreen(navController) }
        composable(Routes.FEED) { FeedScreen(navController) }
        composable(Routes.CREATE_POST) { CreatePostScreen(navController) }
        composable(Routes.PROFILE) { ProfileScreen() }
    }
}

