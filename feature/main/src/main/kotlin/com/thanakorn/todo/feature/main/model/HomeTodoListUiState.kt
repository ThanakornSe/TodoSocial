package com.thanakorn.todo.feature.main.model

data class HomeTodoUiState(
    val id: Int,
    val userId: Int,
    val title: String,
    val completed: Boolean,
)
