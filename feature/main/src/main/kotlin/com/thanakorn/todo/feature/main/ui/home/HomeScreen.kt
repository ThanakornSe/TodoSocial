package com.thanakorn.todo.feature.main.ui.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.thanakorn.todo.feature.main.model.HomeUiState
import com.thanakorn.todo.feature.main.viewmodel.HomeViewModel
import com.thanakorn.todo.resource.theme.AppTheme
import com.thanakorn.todo.resource.theme.Typography
import com.thanakorn.todo.resource.theme.toolbarColor
import com.thanakorn.todo.resource.theme.white
import com.thanakorn.todo.ui.base.BaseUiState
import com.thanakorn.todo.ui.base.BaseViewModelCommonActionCompose
import com.thanakorns.todo.resource.R
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

    BaseViewModelCommonActionCompose(viewModel = viewModel)

    HomeScreen(uiState = uiState)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    uiState: BaseUiState<HomeUiState>,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier
                    .fillMaxWidth(),
                title = {
                    Text(
                        text = stringResource(R.string.app_name),
                        style = Typography.titleLarge,
                        color = white
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = toolbarColor
                )
            )
        }
    ) { paddingValue ->

        LazyColumn(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValue)
        ) {
            uiState.mainUiState?.todoList?.let { todoList ->
                items(todoList) {
                    TaskItem(title = it.title, isCompleted = it.completed)
                }
            }
        }
    }
}

@Preview
@Composable
private fun DefaultHomeScreenPreview() {
    AppTheme {
        HomeScreen(uiState = BaseUiState())
    }
}