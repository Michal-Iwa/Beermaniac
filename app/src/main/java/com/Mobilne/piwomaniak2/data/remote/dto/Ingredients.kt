package com.Mobilne.piwomaniak2.data.remote.dto

data class Ingredients(
    val hops: List<Hop>,
    val malt: List<Malt>,
    val yeast: String
)