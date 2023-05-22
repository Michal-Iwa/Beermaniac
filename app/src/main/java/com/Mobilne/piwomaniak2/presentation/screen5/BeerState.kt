package com.Mobilne.piwomaniak2.presentation.screen5

import com.Mobilne.piwomaniak2.domain.model.Beer

data class BeerState(
    val isLoading: Boolean = false,
    val beer: Beer? = null,
    val error: String = ""
)
