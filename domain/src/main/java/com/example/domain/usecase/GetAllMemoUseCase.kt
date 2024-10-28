package com.example.domain.usecase

import com.example.domain.model.MemoModel
import com.example.domain.repository.MemoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllMemoUseCase @Inject constructor(
    private val memoRepository: MemoRepository
) {
    operator fun invoke(): Flow<List<MemoModel>> = memoRepository.getAllMemo()
}