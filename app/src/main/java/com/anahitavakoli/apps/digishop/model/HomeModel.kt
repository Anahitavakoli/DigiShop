package com.anahitavakoli.apps.digishop.model

data class HomeModel(
    val AmazingOffer: List<Product>,
    val `data`: Data,
    val discount: List<Product>,
    val makeup: List<Product>,
    val mobile: List<Product>,
    val news: List<New>
)