package com.example.data.di.databse

import android.content.Context
import androidx.room.Room
import com.example.data.dao.MemoDao
import com.example.data.database.MemoDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideMemoDatabase(@ApplicationContext context: Context): MemoDatabase = Room
        .databaseBuilder(
            context,
            MemoDatabase::class.java,
            "memo_app.db"
        ).build()

    @Provides
    fun provideMemoDao(memoDatabase: MemoDatabase) = memoDatabase.memoDao()
}