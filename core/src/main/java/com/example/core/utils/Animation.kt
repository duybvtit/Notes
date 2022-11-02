package com.example.core.utils

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInHorizontally
import com.example.core.utils.NavigationAnimationSpec.ANIMATION_FADE_IN_TWEEN_DURATION
import com.example.core.utils.NavigationAnimationSpec.ANIMATION_SIDE_IN_TWEEN_DURATION
import com.example.core.utils.NavigationAnimationSpec.INITIAL_OFFSET_X

@ExperimentalAnimationApi
fun popEnterTransition(routeScreens: List<String>): EnterTransition? {
    routeScreens.forEach { _ ->
        return slideInHorizontally(
            initialOffsetX = { -INITIAL_OFFSET_X },
            animationSpec = tween(ANIMATION_SIDE_IN_TWEEN_DURATION)
        ) + fadeIn(animationSpec = tween(ANIMATION_FADE_IN_TWEEN_DURATION))
    }
    return null
}

// specifies the animation that runs when you navigate() to this destination.
@ExperimentalAnimationApi
fun enterTransition(routeScreens: List<String>): EnterTransition? {
    routeScreens.forEach { _ ->
        return slideInHorizontally(
            initialOffsetX = { INITIAL_OFFSET_X },
            animationSpec = tween(ANIMATION_SIDE_IN_TWEEN_DURATION)
        ) + fadeIn(animationSpec = tween(ANIMATION_FADE_IN_TWEEN_DURATION))
    }
    return null
}

object NavigationAnimationSpec {
    const val INITIAL_OFFSET_X = 400
    const val ANIMATION_SIDE_IN_TWEEN_DURATION = 300
    const val ANIMATION_FADE_IN_TWEEN_DURATION = 400
}