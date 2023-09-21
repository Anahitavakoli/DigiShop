package com.anahitavakoli.apps.digishop.screens.category

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anahitavakoli.apps.digishop.data.DataOrException
import com.anahitavakoli.apps.digishop.model.BaseCategories
import com.anahitavakoli.apps.digishop.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: CategoryRepository): ViewModel() {

    var categories : MutableState<DataOrException<BaseCategories,Boolean,Exception>> =
        mutableStateOf(DataOrException(null, true, Exception("")))

    init {
        getCategories()
    }

    private fun getCategories(){
        viewModelScope.launch {
            categories.value.loading = true
            categories.value = repository.getAllCategories()

            if (categories.value.toString().isNotEmpty()){
                categories.value.loading = false
            }
        }
    }
}