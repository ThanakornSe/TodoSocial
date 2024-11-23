package com.thanakorn.todo.feature.main.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.thanakorn.todo.feature.main.model.HomeUiState
import com.thanakorn.todo.feature.main.viewmodel.HomeViewModel
import com.thanakorn.todo.resource.theme.AppTheme
import com.thanakorn.todo.ui.base.BaseUiState
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeMainScreen(
    navController: NavHostController,
    viewModel: HomeViewModel = koinViewModel(),
) {
    LaunchedEffect(Unit) {
        viewModel.getHomeData()
    }

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    println("fsdfasfd ${uiState.mainUiState?.todoList}")

    HomeScreen(uiState = uiState)
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: BaseUiState<HomeUiState>,
) {
    Box(modifier = Modifier.fillMaxSize().background(color = Color.White)) {
        Text(modifier = Modifier.align(Alignment.Center),text = "HomeScreen", color = Color.Black, fontSize = 20.sp)
    }

}

@Preview
@Composable
private fun DefaultHomeScreenPreview() {
    AppTheme {
        HomeScreen(uiState = BaseUiState())
    }
}