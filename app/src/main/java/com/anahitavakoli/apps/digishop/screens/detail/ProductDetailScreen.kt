package com.anahitavakoli.apps.digishop.screens.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.anahitavakoli.apps.digishop.model.Product
import com.anahitavakoli.apps.digishop.util.fromJson

@Composable
fun ProductDetailScreen(navController: NavController, data: String?){
    
    val pObject = data.toString().replace("$$$","/")
    val  product = pObject.fromJson(Product::class.java)

    Column(modifier = Modifier
        .verticalScroll(rememberScrollState())) {

        Text(text = product.title)

        LazyRow(){
            items(items = product.gallery){
                Card(modifier = Modifier
                    .height(200.dp)
                    .width(300.dp), elevation = 5.dp) {
                    Column() {
                        AsyncImage( modifier = Modifier.height(200.dp),
                            model = it.img ,
                            contentDescription = null,
                        )
                    }
                }
            }
        }
        
        Surface(modifier = Modifier
            .fillMaxWidth()
            ,color = MaterialTheme.colors.primarySurface) {
            Text(text = product.garanti, color = Color.Black)
        }




    }

}