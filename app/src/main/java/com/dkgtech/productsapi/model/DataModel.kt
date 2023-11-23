package com.dkgtech.productsapi.model

data class DataModel(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int
)