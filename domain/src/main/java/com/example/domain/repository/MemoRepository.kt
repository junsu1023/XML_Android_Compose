package com.example.domain.repository

import com.example.domain.model.MemoModel
import kotlinx.coroutines.flow.Flow

interface MemoRepository {
    fun getAllMemo(): Flow<List<MemoModel>>

    suspend fun insertMemo(memoModel: MemoModel): Result<Unit>

    suspend fun deleteMemo(memoModel: MemoModel): Result<Unit>
}