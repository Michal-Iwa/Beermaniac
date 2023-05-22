package com.Mobilne.piwomaniak2.presentation.screen3

import android.annotation.SuppressLint
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.navArgument
import com.Mobilne.piwomaniak2.common.BeerListItem
import com.Mobilne.piwomaniak2.domain.model.Beer
import com.Mobilne.piwomaniak2.presentation.Screen
import com.Mobilne.piwomaniak2.presentation.screen1.MainList


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BeerListGT3LT5Screen(
    navController: NavController,
    viewModel: BeerListGT3LT5ViewModel = hiltViewModel()
) {
    val mContext = LocalContext.current
    val state = viewModel.state.value
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Beermaniac", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigateUp() }) {
                        Icon(Icons.Default.ArrowBack, "back",tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(28,61,91)
                ),
            )
        },
        content = {
            val paddingValues = it
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(top = paddingValues.calculateTopPadding())
            ) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(state.beers) { beer ->
                        BeerListItem(beer = beer, onItemClick = {
                            navController.navigate(Screen.BeerDetailScreen.route + "/${beer.beerId}")
                        })
                    }
                }
                if (state.error.isNotBlank()) {
                    Text(
                        text = state.error,
                        color = Color.Magenta,
                        textAlign = TextAlign.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 20.dp)
                            .align(Alignment.Center)
                    )
                }
                if (state.isLoading) {
                    CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                }
            }
        }
    )
}


