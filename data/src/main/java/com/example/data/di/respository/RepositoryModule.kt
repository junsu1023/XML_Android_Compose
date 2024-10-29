package com.example.data.di.respository

import com.example.data.datasource.MemoDataSource
import com.example.data.repository.MemoRepositoryImpl
import com.example.domain.repository.MemoRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {
    @Provides
    @Singleton
    fun provideMemoRepository(
        memoDataSource: MemoDataSource
    ): MemoRepository {
        return MemoRepositoryImpl(memoDataSource)
    }
}