package com.example.core.navigation

sealed class NavTarget(val route: String){
    object AllNotesRoute: NavTarget(route = "AllNotes")
}
