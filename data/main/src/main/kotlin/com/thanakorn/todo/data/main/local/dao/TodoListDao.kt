package com.thanakorn.todo.data.main.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.thanakorn.todo.data.main.local.entity.TodoListItemEntity

@Dao
interface TodoListDao {

    @Query("SELECT * FROM todolist")
    fun getAllFromTodoList(): List<TodoListItemEntity>


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertTodoList(todos: List<TodoListItemEntity>)

    @Update
    suspend fun updateNotifications(vararg todos: TodoListItemEntity)

    @Query("DELETE FROM todolist")
    fun deleteAll()

}