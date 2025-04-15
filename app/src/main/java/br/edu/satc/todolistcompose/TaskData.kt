package br.edu.satc.todolistcompose

import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Database
import androidx.room.Delete
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.PrimaryKey
import androidx.room.Query
import androidx.room.RoomDatabase
import androidx.room.Update

@Entity
data class TaskData (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "complete") val complete: Boolean
)

@Dao
interface TaskDao {
    @Query("SELECT * FROM taskData")
    fun getAll(): List<TaskData>


    @Update
    fun updateAll(vararg tasksData: TaskData)

    @Insert
    fun insertAll(vararg tasksData: TaskData)

    @Delete
    fun delete(tasksData: TaskData)
}

@Database(entities = [TaskData::class], version = 1)
abstract class AppDatabase: RoomDatabase(){
    abstract fun taskDao(): TaskDao
}