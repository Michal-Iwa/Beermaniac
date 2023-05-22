package com.Mobilne.piwomaniak2.presentation.screen3

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Mobilne.piwomaniak2.common.BeerListState
import com.Mobilne.piwomaniak2.common.Resource
import com.Mobilne.piwomaniak2.domain.use_case.get_beer_abv_gt3_lt5.GetBeerAbvGT3LT5UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BeerListGT3LT5ViewModel @Inject constructor(
    private val getBeerAbvGT3LT5UseCase: GetBeerAbvGT3LT5UseCase
): ViewModel(){

    private val _state = mutableStateOf(BeerListState())
    val state: State<BeerListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getBeerAbvGT3LT5UseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = BeerListState(beers = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = BeerListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = BeerListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}