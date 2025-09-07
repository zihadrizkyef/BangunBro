package com.zr.bangunbro.domain.usecase

import com.zr.bangunbro.domain.model.Alarm
import com.zr.bangunbro.domain.repository.IAlarmRepository

class AddAlarmUseCase(private val repository: IAlarmRepository) {
    suspend operator fun invoke(alarm: Alarm) {
        repository.addAlarm(alarm)
    }
}