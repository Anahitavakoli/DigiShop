package com.anahitavakoli.apps.digishop.screens.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.anahitavakoli.apps.digishop.navigation.NavigationItem
import com.anahitavakoli.apps.digishop.util.toJson

@Composable
fun HomeScreen(navController: NavController, viewModel: HomeViewModel = hiltViewModel()) {

    var homeData = viewModel.data.value.data

    if(viewModel.data.value.loading == true){
        Surface(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()) {
            Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                CircularProgressIndicator()
            }
        }
    }else{
            Column(modifier = Modifier
                .verticalScroll(rememberScrollState())) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp), horizontalArrangement = Arrangement.End) {
                    Text(text = "New Mobile" , fontSize = 14.sp)
                }

                LazyRow(){
                    items(homeData!!.mobile){item->
                        Card(modifier = Modifier
                            .padding(10.dp)
                            .width(180.dp)
                            .height(150.dp)) {
                            Column(modifier = Modifier
                                .wrapContentSize(Alignment.Center)
                                .clickable {
                                    navController.navigate(NavigationItem.Product.rout + "/${item.toJson().toString().replace("/","$$$")}")
                                }) {
                                AsyncImage( modifier = Modifier.height(100.dp),
                                    model = "${item.icon}",
                                    contentDescription = null,
                                )
                                Text(text = "${item.title.subSequence(0,15)}", modifier = Modifier.padding(vertical = 10.dp))
                            }
                        }
                    }
                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp), horizontalArrangement = Arrangement.End) {
                    Text(text = "Make up" , fontSize = 14.sp)
                }

                LazyRow(){
                    items(homeData!!.makeup){item->
                        Card(modifier = Modifier
                            .padding(10.dp)
                            .width(150.dp)
                            .height(150.dp)) {
                            Column(modifier = Modifier
                                .wrapContentSize(Alignment.Center)
                                .clickable { }) {
                                AsyncImage(modifier = Modifier.height(100.dp),
                                    model = "${item.icon}",
                                    contentDescription = null,
                                )
                                Text(text = "${item.title.subSequence(0,15)}", modifier = Modifier.padding(vertical = 10.dp))
                            }
                        }
                    }
                }

                Row(modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp), horizontalArrangement = Arrangement.End) {
                    Text(text = "Discounts" , fontSize = 14.sp)
                }

                LazyRow(){
                    items(homeData!!.discount){item->
                        Card(modifier = Modifier
                            .padding(10.dp)
                            .width(180.dp)
                            .height(200.dp)) {
                            Column(modifier = Modifier
                                .wrapContentSize(Alignment.Center)
                                .clickable { }) {
                                AsyncImage(modifier = Modifier.height(100.dp),
                                    model = "${item.icon}",
                                    contentDescription = null,
                                )
                                
                                Box(modifier = Modifier.background(Color(color = 0xFF2196F3)).clip(shape =
                                    RoundedCornerShape(10.dp)
                                ).height(30.dp).width(40.dp).padding(3.dp)) {
                                    Text(text = "${item.discount}%", color = Color.White)
                                }
                                
                                Text(text = "${item.title.subSequence(0,15)}", modifier = Modifier.padding(vertical = 10.dp))
                            }
                        }
                    }
                }

            }
    }
}