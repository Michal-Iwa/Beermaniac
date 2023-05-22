package com.Mobilne.piwomaniak2.common

import com.Mobilne.piwomaniak2.domain.model.Beer

data class BeerListState(
    val isLoading: Boolean = false,
    val beers: List<Beer> = emptyList(),
    val error: String = ""
)
