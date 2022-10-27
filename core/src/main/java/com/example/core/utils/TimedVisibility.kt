package com.example.core.utils

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun Delay(modifier: Modifier = Modifier, delayMillis: Long = 200, content: @Composable () -> Unit) {
    TimedVisibility(modifier = modifier, delayMillis = delayMillis, visibility = false, content = content)
}

@Composable
fun TimedVisibility(modifier: Modifier = Modifier, delayMillis: Long = 3000, visibility: Boolean = true, content: @Composable () -> Unit) {
    var visible by remember { mutableStateOf(visibility) }
    val scope = rememberCoroutineScope()

    DisposableEffect(Unit) {
        val job = scope.launch {
            delay(delayMillis)
            visible = !visible
        }
        onDispose {
            job.cancel()
        }
    }

    AnimatedVisibility(visible = visible, modifier = modifier, enter = fadeIn(), exit = fadeOut()) {
        content
    }
}