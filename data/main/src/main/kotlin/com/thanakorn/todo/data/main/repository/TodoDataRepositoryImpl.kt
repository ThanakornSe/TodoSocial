package com.thanakorn.todo.data.main.repository

import com.thanakorn.todo.data.main.model.TodoListResponse
import com.thanakorn.todo.data.main.service.TodoListService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TodoDataRepositoryImpl(private val service: TodoListService) : TodoDataRepository {
    override suspend fun getTodoList(): Flow<TodoListResponse> {
        return flow {
            val response = service.getTodoList()
            if (response.isSuccessful) {
                response.body()?.let {
                    emit(it)
                }
            } else {
                throw Exception(response.message())
            }
        }
    }
}