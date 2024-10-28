package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.dao.MemoDao
import com.example.data.entity.MemoEntity

@Database(entities = [MemoEntity::class], version = 1, exportSchema = false)
abstract class MemoDatabase: RoomDatabase() {
    abstract fun memoDao(): MemoDao
}