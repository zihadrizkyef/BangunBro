package com.zr.bangunbro.domain.usecase

import com.zr.bangunbro.domain.repository.IAlarmRepository

class SetAlarmActiveUseCase(private val repository: IAlarmRepository) {
    suspend operator fun invoke(id: Long, isActive: Boolean) {
        repository.setAlarmActive(id, isActive)
    }
}