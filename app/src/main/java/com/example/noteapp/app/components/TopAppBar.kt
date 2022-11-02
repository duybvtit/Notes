package com.example.noteapp.app.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.core.theme.SmallSpaceXS
import com.example.core.utils.BoldText
import com.example.core.utils.ssp
import com.example.noteapp.R

@Composable
fun IncludeTopAppBar(
    title: String,
    actionText: String = "",
    isShowActionButton: Boolean = false,
    isShowActionText: Boolean = false,
    actionButton: Int? = null,
    onBackClick: () -> Unit,
    isShowActionContent: MutableState<Boolean> = mutableStateOf(false),
    actionButtonContent: (@Composable () -> Unit)? = null,
    actionTextClick: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    TopAppBar(
        modifier = modifier,
        title = {
            BoldText(
                content = title,
                color = colorResource(id = R.color.white),
                fontSize = 13.ssp
            )
        },
        actions = {
            if (isShowActionButton) {
                Box(modifier = Modifier.width(100.dp)) {
                    IconButton(
                        onClick = { isShowActionContent.value = !isShowActionContent.value },
                        modifier = Modifier.align(Alignment.CenterEnd)
                    ) {
                        Icon(
                            painter = painterResource(id = actionButton ?: 0),
                            "",
                            tint = colorResource(id = R.color.white)
                        )
                    }
                    Row(modifier = Modifier.align(Alignment.CenterEnd)) {
                        actionButtonContent?.invoke()
                    }
                }
            }

            if (isShowActionText) {
                BoldText(
                    content = actionText.uppercase(), fontSize = 12.ssp,
                    modifier = Modifier
                        .clickable {
                            actionTextClick?.invoke()
                        }
                        .padding(end = SmallSpaceXS()),
                    color = MaterialTheme.colors.primary,
                )
            }
        },
        navigationIcon = {
            IconButton(onClick = {
                onBackClick.invoke()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_note),
                    "",
                    tint = colorResource(id = R.color.white)
                )
            }
        },
        backgroundColor = Color.White,
        elevation = 0.dp
    )
}