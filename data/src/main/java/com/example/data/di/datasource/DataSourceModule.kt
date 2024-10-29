package com.example.data.di.datasource

import com.example.data.dao.MemoDao
import com.example.data.datasource.MemoDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    @Provides
    @Singleton
    fun provideMemoDataSource(
        memoDao: MemoDao
    ): MemoDataSource {
        return MemoDataSource(memoDao)
    }
}