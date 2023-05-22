package com.Mobilne.piwomaniak2.domain.model

import com.Mobilne.piwomaniak2.data.remote.dto.BoilVolume
import com.Mobilne.piwomaniak2.data.remote.dto.Ingredients
import com.Mobilne.piwomaniak2.data.remote.dto.Method
import com.Mobilne.piwomaniak2.data.remote.dto.Volume

data class Beer(
    val abv: Double?,
    val attenuation_level: Double?,
    val boil_volume: BoilVolume?,
    val brewers_tips: String?,
    val contributed_by: String?,
    val description: String?,
    val ebc: Double?,
    val first_brewed: String?,
    val food_pairing: List<String>?,
    val ibu: Double?,
    val beerId: String,
    val image_url: String?,
    val ingredients: Ingredients?,
    val method: Method?,
    val name: String?,
    val ph: Double?,
    val srm: Double?,
    val tagline: String?,
    val target_fg: Double?,
    val target_og: Double?,
    val volume: Volume?
)
