package com.thanakorn.todo.feature.main.viewmodel

import androidx.lifecycle.viewModelScope
import com.thanakorn.todo.common.util.DispatcherProvider
import com.thanakorn.todo.domain.main.usecase.GetTodoListUseCase
import com.thanakorn.todo.feature.main.model.HomeTodoUiState
import com.thanakorn.todo.feature.main.model.HomeUiState
import com.thanakorn.todo.ui.base.BaseViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel(
    private val useCase: GetTodoListUseCase,
    private val dispatcher: DispatcherProvider,
) : BaseViewModel<HomeUiState>() {
    fun getHomeData() {
        useCase
            .execute()
            .flowOn(dispatcher.io)
            .onStart {
                setLoading(true)
            }.onEach {
                _uiState.update { currentState ->
                    currentState.copy(
                        mainUiState =
                        HomeUiState(
                            todoList =
                            it.map { todo ->
                                HomeTodoUiState(
                                    id = todo.id ?: 0,
                                    userId = todo.userId ?: 0,
                                    title = todo.title ?: "",
                                    completed = todo.completed ?: false,
                                )
                            },
                        ),
                        isLoading = false,
                    )
                }
            }.catch {
                setLoading(false)
                setApiError(isApiError = true, errorMessage = it.message)
            }.launchIn(viewModelScope)
    }
}
