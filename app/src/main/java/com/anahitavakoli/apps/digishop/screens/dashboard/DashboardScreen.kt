package com.anahitavakoli.apps.digishop.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.anahitavakoli.apps.digishop.navigation.BottomNavigationBar
import com.anahitavakoli.apps.digishop.navigation.Navigation

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun DashboardScreen() {

    val navController =  rememberNavController()

    Scaffold(topBar = {
        TopAppBar(title = { Text(text = "Online Shop") })
    }, content = {space->
                 Box(modifier = Modifier.padding(space)) {
                    Navigation(navController = navController)
                 }
    }
    ,bottomBar = {BottomNavigationBar(navController)})

}




