package com.thanakorn.todo.feature.main.viewmodel

import androidx.lifecycle.ViewModel
import com.thanakorn.todo.domain.main.usecase.GetTodoListUseCase

class HomeViewModel(private val useCase: GetTodoListUseCase):ViewModel() {

}