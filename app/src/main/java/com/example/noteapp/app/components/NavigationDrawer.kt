package com.example.noteapp.app.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.core.theme.Black
import com.example.core.theme.SmallSpace
import com.example.core.theme.SmallSpaceXS
import com.example.core.theme.TinySpaceXS
import com.example.core.utils.CustomText
import com.example.core.utils.GetScreenWidth
import com.example.noteapp.R

sealed class DrawerScreen(val titleResId: Int, val resIcon: Int) {
    object AllNotes : DrawerScreen(titleResId = R.string.all_notes_title, resIcon = R.drawable.ic_note)
    object Calendar : DrawerScreen(titleResId = R.string.calendar_title, resIcon = R.drawable.ic_note)
    object Reminders : DrawerScreen(titleResId = R.string.reminders_title, resIcon = R.drawable.ic_note)
}

private val screens = listOf(
    DrawerScreen.AllNotes, DrawerScreen.Calendar, DrawerScreen.Reminders
)

@Composable
@Preview
fun NavigationDrawer(modifier: Modifier = Modifier) {
    val screenWith = GetScreenWidth()
    val widthNavigationDrawer = screenWith * 2 / 4

    Column(
        modifier = modifier
            .width(widthNavigationDrawer.dp)
            .fillMaxHeight()
            .background(color = Black)
    ) {
        screens.forEach {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(horizontal = SmallSpace(), vertical = TinySpaceXS())
            ) {
                Icon(painter = painterResource(id = it.resIcon), contentDescription = "", tint = Color.White)

                Spacer(modifier = Modifier.size(SmallSpaceXS()))

                CustomText(content = stringResource(id = it.titleResId), style = MaterialTheme.typography.body1, color = Color.White)
            }
        }
    }
}
