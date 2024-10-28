package com.example.data.datasource

import com.example.data.dao.MemoDao
import com.example.data.entity.MemoEntity
import kotlinx.coroutines.flow.Flow

class MemoDataSource(
    private val memoDao: MemoDao
) {
    fun getAllMemo(): Flow<List<MemoEntity>> = memoDao.getAllMemo()

    suspend fun insertMemo(memoEntity: MemoEntity): Result<Unit> = memoDao.insertMemo(memoEntity)

    suspend fun deleteMemo(memoEntity: MemoEntity): Result<Unit> = memoDao.deleteMemo(memoEntity)
}