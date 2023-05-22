package com.Mobilne.piwomaniak2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.Mobilne.piwomaniak2.presentation.screen1.MainScreen
import com.Mobilne.piwomaniak2.presentation.Screen
import com.Mobilne.piwomaniak2.presentation.screen1.Screen1ViewModel
import com.Mobilne.piwomaniak2.presentation.screen2.BeerListLT3Screen
import com.Mobilne.piwomaniak2.presentation.screen4.BeerListGT5Screen
import com.Mobilne.piwomaniak2.presentation.screen3.BeerListGT3LT5Screen
import com.Mobilne.piwomaniak2.presentation.screen5.BeerDetailScreen
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: Screen1ViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepOnScreenCondition{
                viewModel.isLoading.value
            }
        }
        setContent {
            Surface(modifier = Modifier.fillMaxSize(), color = Color(0xFFD9D9D9)) {}
            val navController = rememberNavController()
            NavHost(
                navController = navController,
                startDestination = Screen.MainScreen.route
            ){
                composable(
                    route = Screen.MainScreen.route
                ) {
                    MainScreen(navController)
                }
                composable(
                    route = Screen.BeerListLT3Screen.route
                ) {
                    BeerListLT3Screen(navController)
                }
                composable(
                    route = Screen.BeerListGT3LT5Screen.route
                ) {
                    BeerListGT3LT5Screen(navController)
                }
                composable(
                    route = Screen.BeerListGT5Screen.route
                ) {
                    BeerListGT5Screen(navController)
                }
                composable(
                    route = Screen.BeerDetailScreen.route + "/{beerId}"
                ) {
                    BeerDetailScreen(navController)
                }

            }
        }

    }
}
