package com.thanakorn.todo.data.main.service

import com.thanakorn.todo.common.Constants
import com.thanakorn.todo.data.main.model.TodoListItemResponse
import retrofit2.Response
import retrofit2.http.GET

interface TodoListService {
    @GET(Constants.TODO_PATH)
    suspend fun getTodoList(): Response<List<TodoListItemResponse>>
}