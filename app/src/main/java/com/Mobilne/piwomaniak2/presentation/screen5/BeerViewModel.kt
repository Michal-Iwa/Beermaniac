package com.Mobilne.piwomaniak2.presentation.screen5

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.Mobilne.piwomaniak2.common.BeerListState
import com.Mobilne.piwomaniak2.common.Constants
import com.Mobilne.piwomaniak2.common.Resource
import com.Mobilne.piwomaniak2.common.Resource2
import com.Mobilne.piwomaniak2.domain.use_case.get_beer_by_id.GetBeerByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BeerViewModel @Inject constructor(
    private val getBeerByIdUseCase: GetBeerByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel(){
    private val _state = mutableStateOf(BeerListState())
    val state: State<BeerListState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_BEER_ID)?.let {beerId ->
            getBeer(beerId)
        }
    }

    private fun getBeer(beerId: String) {
        getBeerByIdUseCase(beerId).onEach { result ->
            when (result) {
                is Resource2.Success -> {
                    Log.e("TAG", "asdas1")
                    _state.value = BeerListState(beers = result.data?: emptyList())
                }
                is Resource2.Error -> {
                    Log.e("TAG", "asdas2")
                    _state.value = BeerListState(
                        error = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource2.Loading -> {
                    Log.e("TAG", "asdas3")
                    _state.value = BeerListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}