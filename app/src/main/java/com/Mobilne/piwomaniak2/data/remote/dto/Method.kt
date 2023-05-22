package com.Mobilne.piwomaniak2.data.remote.dto

data class Method(
    val fermentation: Fermentation,
    val mash_temp: List<MashTemp>,
    val twist: Any
)