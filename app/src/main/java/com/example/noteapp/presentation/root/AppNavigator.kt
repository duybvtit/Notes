package com.example.noteapp.presentation.root

import android.app.Activity
import androidx.navigation.NamedNavArgument
import com.example.core.base.BaseNavigator
import com.example.core.base.NavigationRouteData
import com.example.core.navigation.NavTarget
import kotlinx.coroutines.flow.asSharedFlow

class AppNavigator(val activity: Activity) : BaseNavigator() {
    override var sharedFlow = mutableSharedFlow.asSharedFlow()


    override fun popBackStack() {
        mutableSharedFlow.tryEmit(NavigationRouteData(isPopBackStack = true))
    }

    override fun getRoute(navTarget: NavTarget): String {
        return navTarget.route + getRouteSuffix(navTarget)
    }

    override fun getRouteSuffix(navTarget: NavTarget): String {
        return when (navTarget) {
            is NavTarget.AllNotesRoute -> ""
            else -> ""
        }
    }

    override fun getRouteWithArguments(navTarget: NavTarget, navArguments: List<NamedNavArgument>?): String {
        return when (navTarget) {
            is NavTarget.AllNotesRoute -> {
                navTarget.route
            }

            else -> {
                navTarget.route
            }
        }
    }

    override fun getArguments(navTarget: NavTarget): List<NamedNavArgument> {
        return when (navTarget) {
            is NavTarget.AllNotesRoute -> {
                listOf()
            }

            else -> listOf()
        }
    }

    override fun navigateTo(navTarget: NavTarget, navArguments: List<NamedNavArgument>?, popUpToRoute: String?) {
        mutableSharedFlow.tryEmit(
            NavigationRouteData(
                route = getRouteWithArguments(navTarget, navArguments),
                popUpToRoute = popUpToRoute
            )
        )
    }

}