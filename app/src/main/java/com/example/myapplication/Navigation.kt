package com.example.myapplication

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.myapplication.ui.Screen
import com.example.myapplication.ui.theme.MyApplicationTheme


@Composable
fun Nav() {
    val navContreoller = rememberNavController()

    NavHost(navController = navContreoller, Screen.Window.route) {

        composable(Screen.Window.route) {
            Window(navContreoller)
        }


        composable(
//            route = "home?title={title}&body={body}",
//            route = Screen.Home.route+"/{title}/{body}",
            route = Screen.Home.route,
            arguments = listOf(
                navArgument(name = "title")
                {
                    type = NavType.StringType
                    defaultValue = " "
                },
                navArgument(name = "body")
                {
                    type = NavType.StringType
                    defaultValue = " "
                }
            )
        ) { backstackEntry ->
            Home(
                navContreoller,
                TitleIs = backstackEntry.arguments?.getString("title"),
                BodyIs = backstackEntry.arguments?.getString("body")
            )
        }
    }


}

