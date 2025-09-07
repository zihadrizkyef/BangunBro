package com.zr.bangunbro.domain.usecase

import com.zr.bangunbro.domain.repository.IAlarmRepository

class DeleteAlarmUseCase(private val repository: IAlarmRepository) {
    suspend operator fun invoke(id: Long) {
        return repository.deleteAlarm(id)
    }
}