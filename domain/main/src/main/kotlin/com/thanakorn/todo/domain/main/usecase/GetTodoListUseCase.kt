package com.thanakorn.todo.domain.main.usecase

import com.thanakorn.todo.data.main.repository.TodoDataRepository
import com.thanakorn.todo.domain.main.model.TodoListItemModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTodoListUseCase(private val repository: TodoDataRepository) {
    suspend fun execute(): Flow<List<TodoListItemModel>> = repository.getTodoList().map {
        it.map { item ->
            TodoListItemModel(
                id = item.id,
                title = item.title,
                userId = item.userId,
            )
        }
    }
}