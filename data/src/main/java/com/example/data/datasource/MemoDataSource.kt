package com.example.data.datasource

import com.example.data.dao.MemoDao
import com.example.data.entity.MemoEntity

class MemoDataSource(
    private val memoDao: MemoDao
) {
    suspend fun getAllMemo(): List<MemoEntity> = memoDao.getAllMemo()

    suspend fun insertMemo(memoEntity: MemoEntity): Result<Unit> = memoDao.insertMemo(memoEntity)

    suspend fun deleteMemo(memoEntity: MemoEntity): Result<Unit> = memoDao.deleteMemo(memoEntity)
}