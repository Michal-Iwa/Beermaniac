package com.Mobilne.piwomaniak2.presentation.screen1

import android.annotation.SuppressLint
import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.Mobilne.piwomaniak2.presentation.Screen
import com.example.piwomaniak2.R


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    navController: NavController
){
    val mContext = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Beermaniac", color = Color.White) },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(28,61,91)
                )
            )
        },
        content = {
            MainList(paddingValues = it,navController)
        }
    )
}

@Composable
fun MainList(paddingValues: PaddingValues,navController: NavController) {
    var painter: Painter
    Column(
        modifier = Modifier
            .padding(top = paddingValues.calculateTopPadding())
            .verticalScroll(rememberScrollState())
    ) {
        Image(
            painter = painterResource(id = R.drawable.screen1top),
            contentDescription = null,
        )
        painter = painterResource(id = R.drawable.photo1)
        DisplayImage(painter = painter,1, navController)
        painter = painterResource(id = R.drawable.photo2)
        DisplayImage(painter = painter,2,navController)
        painter = painterResource(id = R.drawable.photo3)
        DisplayImage(painter = painter,3,navController)
    }

}

@Composable
fun DisplayImage(painter: Painter, id: Int,navController: NavController) {
    val mContext = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable { LaunchSecondScreen(id,mContext, navController) },
        shape = RoundedCornerShape(15.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = null,
        )
    }
}

fun LaunchSecondScreen(id: Int, mContext: Context,navController: NavController) {
    when(id) {
        1 -> { navController.navigate(Screen.BeerListLT3Screen.route )}
        2 -> { navController.navigate(Screen.BeerListGT3LT5Screen.route )}
        3 -> { navController.navigate(Screen.BeerListGT5Screen.route )}
    }
}
