package com.thanakorn.todo.domain.main.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class TodoListItemModel(
    @SerializedName("id")
    val id: Int? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("userId")
    val userId: Int? = null,
    @SerializedName("completed")
    val completed: Boolean? = null,
) : Parcelable