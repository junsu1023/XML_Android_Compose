package com.example.data.dao

import androidx.room.Dao
import com.example.data.entity.MemoEntity

@Dao
interface MemoDao {
    suspend fun getAllMemo(): List<MemoEntity>

    suspend fun insertMemo(memoEntity: MemoEntity): Result<Unit>

    suspend fun deleteMemo(memoEntity: MemoEntity): Result<Unit>
}
