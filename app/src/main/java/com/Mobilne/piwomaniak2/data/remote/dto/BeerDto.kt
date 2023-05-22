package com.Mobilne.piwomaniak2.data.remote.dto

import com.Mobilne.piwomaniak2.domain.model.Beer

data class BeerDto(
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
    val id: String,
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

fun BeerDto.toBeer(): Beer {
    return Beer(
        abv = abv,
        attenuation_level=attenuation_level,
        boil_volume=boil_volume,
        brewers_tips=brewers_tips,
        contributed_by=contributed_by,
        description=description,
        ebc=ebc,
        first_brewed=first_brewed,
        food_pairing=food_pairing,
        ibu=ibu,
        beerId=id,
        image_url=image_url,
        ingredients=ingredients,
        method=method,
        name=name,
        ph=ph,
        srm=srm,
        tagline=tagline,
        target_fg=target_fg,
        target_og=target_og,
        volume=volume
    )
}