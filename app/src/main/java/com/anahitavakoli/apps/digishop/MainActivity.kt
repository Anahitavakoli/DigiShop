package com.anahitavakoli.apps.digishop

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.anahitavakoli.apps.digishop.screens.DashboardScreen

import com.anahitavakoli.apps.digishop.ui.theme.DigiShopTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DigiShopTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(){
        Scaffold( drawerContent = {
            Text(text = "Drawer")
        } , content = {
            DashboardScreen()
        }
        )
}

@Composable
fun Body(){
Column {
    Image(
        painter = painterResource(id = R.drawable.img_2097),
        contentDescription = stringResource(id = R.string.app_name)
    )
    Spacer(modifier = Modifier.height(100.dp))
    CounterView()
}
}

@Composable
fun CounterView(){

    val state : MutableState<Int> = remember {
        mutableStateOf(1)
    }

    Row(horizontalArrangement = Arrangement.SpaceAround) {
        Button(onClick = {  state.value += 1  }) {
            Text(text = "+")
        }

        Text(text = state.value.toString())

        Button(onClick = { if(state.value > 1) state.value -= 1 }) {
            Text(text = "-")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    DigiShopTheme {
        MainScreen()
    }
}