package com.thanakorn.todo.data.main.repository

import com.thanakorn.todo.data.main.local.entity.TodoListItemEntity
import kotlinx.coroutines.flow.Flow

interface TodoDataRepository {
    suspend fun getTodoList(): Flow<List<TodoListItemEntity>>
}