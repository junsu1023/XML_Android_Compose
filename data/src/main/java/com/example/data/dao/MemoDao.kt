package com.example.data.dao

import androidx.room.Dao
import com.example.data.entity.MemoEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MemoDao {
    fun getAllMemo(): Flow<List<MemoEntity>>

    suspend fun insertMemo(memoEntity: MemoEntity): Result<Unit>

    suspend fun deleteMemo(memoEntity: MemoEntity): Result<Unit>
}
