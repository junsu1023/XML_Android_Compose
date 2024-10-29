package com.example.data.mapper

import com.example.data.entity.MemoEntity
import com.example.domain.model.MemoModel

fun MemoEntity.toModel(): MemoModel = MemoModel(
    this.id, this.updateDate, this.title, this.content
)

fun MemoModel.toEntity(): MemoEntity = MemoEntity(
    this.id, this.updateDate, this.title, this.content
)