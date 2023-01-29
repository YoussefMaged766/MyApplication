package com.example.myapplication.ui



sealed class Screen(val route:String){
    object Window:Screen("window")
    object Home:Screen("home")

    object Details:Screen("details")

fun withArgs(vararg args:String)= buildString {
    append(route)
    args.forEach {
        append("/$it")
    }
}
}
