package com.thanakorn.todo.data.main.repository

import com.thanakorn.todo.data.main.model.TodoListResponse
import kotlinx.coroutines.flow.Flow

interface TodoDataRepository {
    suspend fun getTodoList(): Flow<TodoListResponse>
}