package com.example.data.repository

import com.example.data.datasource.MemoDataSource
import com.example.data.mapper.toEntity
import com.example.data.mapper.toModel
import com.example.domain.model.MemoModel
import com.example.domain.repository.MemoRepository
import javax.inject.Inject

class MemoRepositoryImpl @Inject constructor(
    private val memoDataSource: MemoDataSource
): MemoRepository {
    override suspend fun getAllMemo(): List<MemoModel> = memoDataSource.getAllMemo().map { it.toModel() }

    override suspend fun insertMemo(memoModel: MemoModel): Result<Unit> = memoDataSource.insertMemo(memoModel.toEntity())

    override suspend fun deleteMemo(memoModel: MemoModel): Result<Unit> = memoDataSource.deleteMemo(memoModel.toEntity())
}