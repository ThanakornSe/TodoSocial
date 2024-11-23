package com.thanakorn.todo.data.main.repository

import com.thanakorn.todo.data.main.local.dao.TodoListDao
import com.thanakorn.todo.data.main.local.entity.TodoListItemEntity
import com.thanakorn.todo.data.main.service.TodoListService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class TodoDataRepositoryImpl(
    private val service: TodoListService,
    private val dao: TodoListDao,
) : TodoDataRepository {
    override suspend fun getTodoList(): Flow<List<TodoListItemEntity>> {
        return flow {
            try {
                val response = service.getTodoList()
                if (response.isSuccessful) {
                    response.body()?.let { result ->
                        dao.insertTodoList(result.map {
                            TodoListItemEntity(
                                id = it.id,
                                title = it.title,
                                userId = it.userId,
                                completed = it.completed
                            )
                        })
                        emit(dao.getAllFromTodoList())
                    }
                } else {
                    if (dao.getAllFromTodoList().isNotEmpty()) {
                        emit(dao.getAllFromTodoList())
                    }
                }
            } catch (e: Exception) {
                if (dao.getAllFromTodoList().isNotEmpty()) {
                    emit(dao.getAllFromTodoList())
                } else {
                    throw Exception(e.message)
                }
            }
        }
    }
}