package com.Mobilne.piwomaniak2.presentation

sealed class Screen(val route: String) {
    object MainScreen: Screen("main_screen")
    object BeerListLT3Screen: Screen("beer_list_lt3_screen")
    object BeerListGT3LT5Screen: Screen("beer_list_gt3_lt5_screen")
    object BeerListGT5Screen: Screen("beer_list_gt5_screen")
    object BeerDetailScreen: Screen("beer_detail_screen")
}