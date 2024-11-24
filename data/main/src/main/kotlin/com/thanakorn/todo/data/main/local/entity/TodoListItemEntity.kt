package com.thanakorn.todo.data.main.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "todolist")
data class TodoListItemEntity(
    @PrimaryKey
    @ColumnInfo("id")
    val id: Int? = null,
    @ColumnInfo("title")
    val title: String? = null,
    @ColumnInfo("userId")
    val userId: Int? = null,
    @ColumnInfo("completed")
    val completed: Boolean? = null,
) : Parcelable