package com.anahitavakoli.apps.digishop.screens.home

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anahitavakoli.apps.digishop.data.DataOrException
import com.anahitavakoli.apps.digishop.model.HomeModel
import com.anahitavakoli.apps.digishop.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: ProductRepository) : ViewModel(){

    var data : MutableState<DataOrException<HomeModel,Boolean,Exception>> =
        mutableStateOf(DataOrException(null,true,Exception("")))

    init {
        getHomeData()
    }

    private fun getHomeData(){
        viewModelScope.launch {
            data.value.loading = true
            data.value = repository.getHome()
            if(data.value.toString().isNotEmpty()){
                data.value.loading = false
            }
        }
    }
}