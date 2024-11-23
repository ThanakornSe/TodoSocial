package com.thanakorn.todo.data.main.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.thanakorn.todo.data.main.local.dao.TodoListDao
import com.thanakorn.todo.data.main.local.entity.TodoListItemEntity

@Database(entities = [TodoListItemEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoListDao(): TodoListDao
}