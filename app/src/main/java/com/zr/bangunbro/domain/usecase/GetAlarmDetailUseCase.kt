package com.zr.bangunbro.domain.usecase

import com.zr.bangunbro.domain.model.Alarm
import com.zr.bangunbro.domain.repository.IAlarmRepository

class GetAlarmDetailUseCase(private val repository: IAlarmRepository) {
    suspend operator fun invoke(id: Long): Alarm {
        return repository.getAlarmDetail(id)
    }
}