package com.example.core.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.example.core.utils.sdp
import com.example.core.utils.ssp

@Composable
internal fun singlePadding() = 8.dp

@Composable
internal fun iconSize() = 48.dp

@Composable
fun TinySpace(): Dp {
    return 4.sdp
}

@Composable
fun TinySpaceX(): Dp {
    return 6.sdp
}

@Composable
fun TinySpaceXS(): Dp {
    return 8.sdp
}

@Composable
fun SmallSpace(): Dp {
    return 10.sdp
}

@Composable
fun SmallSpaceX(): Dp {
    return 12.sdp
}

@Composable
fun SmallSpaceXS(): Dp {
    return 14.sdp
}

@Composable
fun FontSize10sp(): TextUnit {
    return 10.ssp
}