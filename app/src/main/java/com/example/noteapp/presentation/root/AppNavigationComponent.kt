@file:OptIn(ExperimentalPagerApi::class, ExperimentalAnimationApi::class)

package com.example.noteapp.presentation.root

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.example.core.navigation.NavTarget
import com.example.core.utils.enterTransition
import com.example.core.utils.popEnterTransition
import com.example.noteapp.presentation.home.AllNotesScreen
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun AppNavigationComponent(
    navigator: AppNavigator
) {
    val navController = rememberAnimatedNavController()
    val pagerState = rememberPagerState()

    /** All notes **/
    val allNotesRoute = navigator.getRoute(NavTarget.AllNotesRoute)

    LaunchedEffect("AppNavigationComponent") {
        navigator.sharedFlow.onEach { routeData ->
            if (routeData.isPopBackStack) {
                if (routeData.route.isEmpty()) {
                    navController.popBackStack()
                } else {
                    navController.popBackStack(route = routeData.route, inclusive = false)
                    if (!routeData.navigateToBottomNavigationItem.isNullOrEmpty()) {

                    }
                }
            } else {
                navController.navigate(routeData.route) {
                    routeData.popUpToRoute?.let { popUpTo(it) }
                }
            }
        }.launchIn(this)
    }

    AnimatedNavHost(navController = navController, startDestination = allNotesRoute) {
        composable(route = allNotesRoute, enterTransition = {
            enterTransition(listOf())
        }, popEnterTransition = {
            popEnterTransition(listOf())
        }) {
            AllNotesScreen {

            }
        }
    }
}