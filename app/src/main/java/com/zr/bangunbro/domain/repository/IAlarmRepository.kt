package com.zr.bangunbro.domain.repository

import com.zr.bangunbro.domain.model.Alarm

interface IAlarmRepository {
    suspend fun getAlarms(): List<Alarm>
    suspend fun addAlarm(alarm: Alarm)
    suspend fun deleteAlarm(id: Long)
    suspend fun setAlarmActive(id: Long, isActive: Boolean)
    suspend fun getAlarmDetail(id: Long): Alarm
}