package com.thanakorn.todo.domain.main.usecase

import com.thanakorn.todo.data.main.repository.TodoDataRepository
import com.thanakorn.todo.domain.main.model.TodoListItemModel
import com.thanakorn.todo.domain.main.model.TodoListModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTodoListUseCase(private val repository: TodoDataRepository) {
    suspend fun execute(): Flow<TodoListModel> = repository.getTodoList().map { response ->
        TodoListModel(
            todoList = response.todoList.map {
                TodoListItemModel(
                    id = it.id,
                    title = it.title,
                    userId = it.userId,
                    completed = it.completed,
                )
            }
        )
    }
}