package com.example.noteapp.presentation.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import com.example.core.theme.SmallSpace
import com.example.core.utils.CustomText


@Composable
fun EmptyView(modifier: Modifier = Modifier, painter: Painter, content: String?) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = painter, contentDescription = "")

        Spacer(modifier = Modifier.size(SmallSpace()))

        if (!content.isNullOrEmpty()) {
            CustomText(content = content, style = MaterialTheme.typography.body1)
        }
    }
}
