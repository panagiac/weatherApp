package com.panagiac.demo.data.models

class CitiesDAO : ArrayList<CitiesDAOItem>()

data class CitiesDAOItem(
    val country: String,
    val id: Int,
    val name: String,
    val state: String
)