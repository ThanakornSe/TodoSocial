package com.thanakorn.todo.data.main.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.thanakorn.todo.data.main.local.entity.TodoListItemEntity
import kotlinx.parcelize.Parcelize

@Parcelize
data class TodoListItemResponse(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("userId")
    val userId: Int? = null,
    @SerializedName("completed")
    val completed: Boolean? = null,
) : Parcelable {
    companion object {
        fun TodoListItemResponse.toTodoListItemEntity(): TodoListItemEntity =
            TodoListItemEntity(
                id = this.id, title = this.title, userId = this.userId, completed = this.completed
            )
    }
}