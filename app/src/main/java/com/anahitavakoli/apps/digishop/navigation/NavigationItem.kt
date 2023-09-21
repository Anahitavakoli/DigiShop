package com.anahitavakoli.apps.digishop.navigation

import com.anahitavakoli.apps.digishop.R

sealed class NavigationItem(var rout: String, var icon: Int){

    object Home : NavigationItem("Home" , R.drawable.baseline_home_24 )
    object Category : NavigationItem("Category" , R.drawable.baseline_library_books_24 )
    object Setting : NavigationItem("Setting" , R.drawable.baseline_settings_24 )
    object Product : NavigationItem("Product" , R.drawable.baseline_settings_24 )

}
