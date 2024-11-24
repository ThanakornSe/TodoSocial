package com.thanakorn.todo.domain.main.usecase

import com.thanakorn.todo.data.main.repository.TodoDataRepository
import com.thanakorn.todo.domain.main.model.TodoListItemModel
import com.thanakorn.todo.domain.main.model.TodoListItemModel.Companion.toTodoListItemModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTodoListUseCase(private val repository: TodoDataRepository) {
    suspend fun execute(): Flow<List<TodoListItemModel>> = repository.getTodoList().map {
        it.map { item ->
            item.toTodoListItemModel()
        }
    }
}