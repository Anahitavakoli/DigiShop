package com.anahitavakoli.apps.digishop.screens.category

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun CategoryScreen(viewModel: CategoryViewModel = hiltViewModel()) {

    val categoryData = viewModel.categories.value.data

    if(viewModel.categories.value.loading == true){
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                CircularProgressIndicator()
            }
        }
    }else{
        LazyColumn(){
            items(categoryData!!.categories){item->
                Card(modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .height(100.dp), elevation = 8.dp){
                    Row(horizontalArrangement = Arrangement.End) {

                        Text(text = "${item.title}", modifier = Modifier.padding(vertical = 10.dp))

                        Spacer(modifier = Modifier.width(30.dp))

                        AsyncImage( modifier = Modifier.height(100.dp),
                            model = "${item.icon}",
                            contentDescription = null,
                        )
                    }
                }
            }
        }
    }

}