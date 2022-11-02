package com.example.noteapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.core.theme.NoteAppTheme
import com.example.core.theme.notesAppColors
import com.example.core.utils.SetUpSystemUi
import com.example.noteapp.presentation.root.AppNavigationComponent
import com.example.noteapp.presentation.root.AppNavigator
import com.example.noteapp.presentation.widget.EmptyView
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NoteAppTheme {
                SetUpSystemUi(systemUiController = rememberSystemUiController(), systemColor = notesAppColors.primary)

                // A surface container using the 'background' color from the theme
                AppNavigationComponent(navigator = AppNavigator(this))
            }
        }
    }
}

@Composable
@Preview
fun PreviewData() {
    EmptyView(painter = painterResource(id = R.mipmap.ic_launcher), content = "")
}