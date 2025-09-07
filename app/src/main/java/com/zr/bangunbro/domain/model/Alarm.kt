package com.zr.bangunbro.domain.model

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.LocalTime

data class Alarm(
    val id: Long,
    val title: String,
    val time: LocalTime,
    val days: List<DayOfWeek>,
    val isActive: Boolean,
)