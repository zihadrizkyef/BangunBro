package com.zr.bangunbro.domain.usecase

import com.zr.bangunbro.domain.model.Alarm
import com.zr.bangunbro.domain.repository.IAlarmRepository

class GetAlarmUseCase(private val repository: IAlarmRepository) {
    suspend operator fun invoke(): List<Alarm> {
        return repository.getAlarms()
    }
}