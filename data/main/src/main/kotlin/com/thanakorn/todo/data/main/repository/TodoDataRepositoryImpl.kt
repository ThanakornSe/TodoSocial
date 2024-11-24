package com.thanakorn.todo.data.main.repository

import com.thanakorn.todo.common.util.DispatcherProvider
import com.thanakorn.todo.data.main.local.dao.TodoListDao
import com.thanakorn.todo.data.main.local.entity.TodoListItemEntity
import com.thanakorn.todo.data.main.model.TodoListItemResponse.Companion.toTodoListItemEntity
import com.thanakorn.todo.data.main.service.TodoListService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class TodoDataRepositoryImpl(
    private val service: TodoListService,
    private val dao: TodoListDao,
    private val dispatcher: DispatcherProvider,
) : TodoDataRepository {
    override fun getTodoList(): Flow<List<TodoListItemEntity>> {
        return flow {
            try {
                val response = service.getTodoList()
                if (response.isSuccessful) {
                    response.body()?.let { result ->

                        val entities = result.map {
                            it.toTodoListItemEntity()
                        }
                        dao.insertTodoList(entities)
                    }
                }

                val localData = dao.getAllFromTodoList()
                emit(localData)
            } catch (e: Exception) {
                val cachedData = dao.getAllFromTodoList()
                if (cachedData.isNotEmpty()) {
                    emit(cachedData)
                } else {
                    throw e
                }
            }
        }.flowOn(dispatcher.io)
    }
}