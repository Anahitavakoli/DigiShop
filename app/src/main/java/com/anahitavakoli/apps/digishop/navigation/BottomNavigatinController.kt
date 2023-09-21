package com.anahitavakoli.apps.digishop.navigation

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.navArgument
import com.anahitavakoli.apps.digishop.screens.category.CategoryScreen
import com.anahitavakoli.apps.digishop.screens.detail.ProductDetailScreen
import com.anahitavakoli.apps.digishop.screens.home.HomeScreen
import com.anahitavakoli.apps.digishop.screens.setting.SettingScreen

@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = NavigationItem.Home.rout){
        composable(NavigationItem.Home.rout){
            HomeScreen(navController)
        }
        composable(NavigationItem.Category.rout){
            CategoryScreen()
        }
        composable(NavigationItem.Setting.rout){
            SettingScreen()
        }
        composable(NavigationItem.Product.rout+"/{product}",
        arguments = listOf(navArgument("product"){
            type = NavType.StringType
        })
        ){backStackEntry->
            ProductDetailScreen(navController,backStackEntry.arguments?.getString("product"))
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {

    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Category,
        NavigationItem.Setting
    )

    BottomNavigation(backgroundColor = Color(0xFF3F51B5),
        contentColor = Color.White) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRout = navBackStackEntry?.destination?.route

        items.forEach {
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = it.icon),
                    contentDescription = "")
                },
                selectedContentColor = Color.White,
                unselectedContentColor = Color.White.copy(0.4f),
                alwaysShowLabel = false,
                selected = currentRout == it.rout, onClick = {
                    navController.navigate(it.rout){
                        navController.graph.startDestDisplayName.let{route->
                            popUpTo(route){
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                })
        }
    }
}
