package com.gateway.marvel.ui.main

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.gateway.marvel.ui.characters.CharactersScreen
import com.gateway.marvel.ui.comics.ComicsScreen
import com.gateway.marvel.ui.movies.MoviesScreen
import com.gateway.marvel.ui.settings.SettingsScreen

object DestinationMainContent {
    const val MOVIES_ROUTE = "movies"
    const val CHARACTERS_ROUTE = "characters"
    const val COMICS_ROUTE = "comics"
    const val SETTINGS_ROUTE = "settings"
}

sealed class MainScreenContent(
    val route: String,
    val title: String
) {
    data object Movies : MainScreenContent(
        route = DestinationMainContent.MOVIES_ROUTE,
        title = "Фильмы"
    )

    data object Characters : MainScreenContent(
        route = DestinationMainContent.CHARACTERS_ROUTE,
        title = "Персонажи"
    )

    data object Comics : MainScreenContent(
        route = DestinationMainContent.COMICS_ROUTE,
        title = "Комиксы"
    )

    data object Settings : MainScreenContent(
        route = DestinationMainContent.SETTINGS_ROUTE,
        title = "Настройки"
    )
}

@Composable
fun MainContentNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(MainScreenContent.Movies.route) {
            MoviesScreen()
        }

        composable(MainScreenContent.Characters.route) {
            CharactersScreen()
        }

        composable(MainScreenContent.Comics.route) {
            ComicsScreen()
        }

        composable(MainScreenContent.Settings.route) {
            SettingsScreen()
        }
    }
}

fun conditionSwitchScreen(
    navController: NavHostController,
    currentRoute: String?,
    selectRoute: String
) {
    if (currentRoute != selectRoute) navController.navigate(selectRoute) { popUpTo(0) }
}