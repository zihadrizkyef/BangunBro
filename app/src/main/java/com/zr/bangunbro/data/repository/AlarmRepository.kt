package com.zr.bangunbro.data.repository

import com.zr.bangunbro.domain.model.Alarm
import com.zr.bangunbro.domain.repository.IAlarmRepository
import java.time.DayOfWeek
import java.time.LocalTime

class AlarmRepository: IAlarmRepository {

    private val dummyAlarms = mutableListOf(
        Alarm(id = 1, title = "Morning Alarm", time = LocalTime.of(7, 0), days = listOf(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY), isActive = true),
        Alarm(id = 2, title = "Weekend Alarm", time = LocalTime.of(9, 0), days = listOf(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY), isActive = false),
        Alarm(id = 3, title = "Study Session", time = LocalTime.of(14, 30), days = listOf(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY), isActive = true),
        Alarm(id = 4, title = "Workout", time = LocalTime.of(18, 0), days = listOf(DayOfWeek.TUESDAY, DayOfWeek.THURSDAY), isActive = true),
        Alarm(id = 5, title = "Movie Night", time = LocalTime.of(20, 0), days = listOf(DayOfWeek.FRIDAY), isActive = false),
        Alarm(id = 6, title = "Alarm 6", time = LocalTime.of(6, 0), days = listOf(DayOfWeek.MONDAY), isActive = true),
        Alarm(id = 7, title = "Alarm 7", time = LocalTime.of(6, 15), days = listOf(DayOfWeek.TUESDAY), isActive = false),
        Alarm(id = 8, title = "Alarm 8", time = LocalTime.of(6, 30), days = listOf(DayOfWeek.WEDNESDAY), isActive = true),
        Alarm(id = 9, title = "Alarm 9", time = LocalTime.of(6, 45), days = listOf(DayOfWeek.THURSDAY), isActive = false),
        Alarm(id = 10, title = "Alarm 10", time = LocalTime.of(7, 0), days = listOf(DayOfWeek.FRIDAY), isActive = true),
        Alarm(id = 11, title = "Alarm 11", time = LocalTime.of(7, 15), days = listOf(DayOfWeek.SATURDAY), isActive = false),
        Alarm(id = 12, title = "Alarm 12", time = LocalTime.of(7, 30), days = listOf(DayOfWeek.SUNDAY), isActive = true),
        Alarm(id = 13, title = "Alarm 13", time = LocalTime.of(7, 45), days = listOf(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY), isActive = false),
        Alarm(id = 14, title = "Alarm 14", time = LocalTime.of(8, 0), days = listOf(DayOfWeek.TUESDAY, DayOfWeek.THURSDAY), isActive = true),
        Alarm(id = 15, title = "Alarm 15", time = LocalTime.of(8, 15), days = listOf(DayOfWeek.SATURDAY, DayOfWeek.SUNDAY), isActive = false),
        Alarm(id = 16, title = "Alarm 16", time = LocalTime.of(8, 30), days = listOf(DayOfWeek.MONDAY), isActive = true),
        Alarm(id = 17, title = "Alarm 17", time = LocalTime.of(8, 45), days = listOf(DayOfWeek.TUESDAY), isActive = false),
        Alarm(id = 18, title = "Alarm 18", time = LocalTime.of(9, 0), days = listOf(DayOfWeek.WEDNESDAY), isActive = true),
        Alarm(id = 19, title = "Alarm 19", time = LocalTime.of(9, 15), days = listOf(DayOfWeek.THURSDAY), isActive = false),
        Alarm(id = 20, title = "Alarm 20", time = LocalTime.of(9, 30), days = listOf(DayOfWeek.FRIDAY), isActive = true),
        Alarm(id = 21, title = "Alarm 21", time = LocalTime.of(9, 45), days = listOf(DayOfWeek.SATURDAY), isActive = false),
        Alarm(id = 22, title = "Alarm 22", time = LocalTime.of(10, 0), days = listOf(DayOfWeek.SUNDAY), isActive = true),
        Alarm(id = 23, title = "Alarm 23", time = LocalTime.of(10, 15), days = listOf(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY), isActive = false),
        Alarm(id = 24, title = "Alarm 24", time = LocalTime.of(10, 30), days = listOf(DayOfWeek.TUESDAY, DayOfWeek.THURSDAY, DayOfWeek.SATURDAY), isActive = true),
        Alarm(id = 25, title = "Alarm 25", time = LocalTime.of(10, 45), days = listOf(DayOfWeek.FRIDAY, DayOfWeek.SUNDAY), isActive = false),
        Alarm(id = 26, title = "Alarm 26", time = LocalTime.of(11, 0), days = listOf(DayOfWeek.MONDAY), isActive = true),
        Alarm(id = 27, title = "Alarm 27", time = LocalTime.of(11, 15), days = listOf(DayOfWeek.TUESDAY), isActive = false),
        Alarm(id = 28, title = "Alarm 28", time = LocalTime.of(11, 30), days = listOf(DayOfWeek.WEDNESDAY), isActive = true),
        Alarm(id = 29, title = "Alarm 29", time = LocalTime.of(11, 45), days = listOf(DayOfWeek.THURSDAY), isActive = false),
        Alarm(id = 30, title = "Alarm 30", time = LocalTime.of(12, 0), days = listOf(DayOfWeek.FRIDAY), isActive = true),
        Alarm(id = 31, title = "Alarm 31", time = LocalTime.of(12, 15), days = listOf(DayOfWeek.SATURDAY), isActive = false),
        Alarm(id = 32, title = "Alarm 32", time = LocalTime.of(12, 30), days = listOf(DayOfWeek.SUNDAY), isActive = true),
        Alarm(id = 33, title = "Alarm 33", time = LocalTime.of(12, 45), days = listOf(DayOfWeek.MONDAY, DayOfWeek.THURSDAY), isActive = false),
        Alarm(id = 34, title = "Alarm 34", time = LocalTime.of(13, 0), days = listOf(DayOfWeek.TUESDAY, DayOfWeek.FRIDAY), isActive = true),
        Alarm(id = 35, title = "Alarm 35", time = LocalTime.of(13, 15), days = listOf(DayOfWeek.WEDNESDAY, DayOfWeek.SATURDAY), isActive = false),
        Alarm(id = 36, title = "Alarm 36", time = LocalTime.of(13, 30), days = listOf(DayOfWeek.SUNDAY), isActive = true),
        Alarm(id = 37, title = "Alarm 37", time = LocalTime.of(13, 45), days = listOf(DayOfWeek.MONDAY), isActive = false),
        Alarm(id = 38, title = "Alarm 38", time = LocalTime.of(14, 0), days = listOf(DayOfWeek.TUESDAY), isActive = true),
        Alarm(id = 39, title = "Alarm 39", time = LocalTime.of(14, 15), days = listOf(DayOfWeek.WEDNESDAY), isActive = false),
        Alarm(id = 40, title = "Alarm 40", time = LocalTime.of(14, 30), days = listOf(DayOfWeek.THURSDAY), isActive = true),
        Alarm(id = 41, title = "Alarm 41", time = LocalTime.of(14, 45), days = listOf(DayOfWeek.FRIDAY), isActive = false),
        Alarm(id = 42, title = "Alarm 42", time = LocalTime.of(15, 0), days = listOf(DayOfWeek.SATURDAY), isActive = true),
        Alarm(id = 43, title = "Alarm 43", time = LocalTime.of(15, 15), days = listOf(DayOfWeek.SUNDAY), isActive = false),
        Alarm(id = 44, title = "Alarm 44", time = LocalTime.of(15, 30), days = listOf(DayOfWeek.MONDAY, DayOfWeek.FRIDAY), isActive = true),
        Alarm(id = 45, title = "Alarm 45", time = LocalTime.of(15, 45), days = listOf(DayOfWeek.TUESDAY, DayOfWeek.SATURDAY), isActive = false),
        Alarm(id = 46, title = "Alarm 46", time = LocalTime.of(16, 0), days = listOf(DayOfWeek.WEDNESDAY, DayOfWeek.SUNDAY), isActive = true),
        Alarm(id = 47, title = "Alarm 47", time = LocalTime.of(16, 15), days = listOf(DayOfWeek.THURSDAY), isActive = false),
        Alarm(id = 48, title = "Alarm 48", time = LocalTime.of(16, 30), days = listOf(DayOfWeek.MONDAY), isActive = true),
        Alarm(id = 49, title = "Alarm 49", time = LocalTime.of(16, 45), days = listOf(DayOfWeek.TUESDAY), isActive = false),
        Alarm(id = 50, title = "Alarm 50", time = LocalTime.of(17, 0), days = listOf(DayOfWeek.WEDNESDAY), isActive = true),
        Alarm(id = 51, title = "Alarm 51", time = LocalTime.of(17, 15), days = listOf(DayOfWeek.THURSDAY), isActive = false),
        Alarm(id = 52, title = "Alarm 52", time = LocalTime.of(17, 30), days = listOf(DayOfWeek.FRIDAY), isActive = true),
        Alarm(id = 53, title = "Alarm 53", time = LocalTime.of(17, 45), days = listOf(DayOfWeek.SATURDAY), isActive = false),
        Alarm(id = 54, title = "Alarm 54", time = LocalTime.of(18, 0), days = listOf(DayOfWeek.SUNDAY), isActive = true),
        Alarm(id = 55, title = "Alarm 55", time = LocalTime.of(18, 15), days = listOf(DayOfWeek.MONDAY, DayOfWeek.WEDNESDAY, DayOfWeek.FRIDAY, DayOfWeek.SUNDAY), isActive = false),
        Alarm(id = 56, title = "Alarm 56", time = LocalTime.of(18, 30), days = listOf(DayOfWeek.TUESDAY, DayOfWeek.THURSDAY, DayOfWeek.SATURDAY), isActive = true),
        Alarm(id = 57, title = "Alarm 57", time = LocalTime.of(18, 45), days = listOf(DayOfWeek.MONDAY), isActive = false),
        Alarm(id = 58, title = "Alarm 58", time = LocalTime.of(19, 0), days = listOf(DayOfWeek.TUESDAY), isActive = true),
        Alarm(id = 59, title = "Alarm 59", time = LocalTime.of(19, 15), days = listOf(DayOfWeek.WEDNESDAY), isActive = false),
        Alarm(id = 60, title = "Alarm 60", time = LocalTime.of(19, 30), days = listOf(DayOfWeek.THURSDAY), isActive = true),
        Alarm(id = 61, title = "Alarm 61", time = LocalTime.of(19, 45), days = listOf(DayOfWeek.FRIDAY), isActive = false),
        Alarm(id = 62, title = "Alarm 62", time = LocalTime.of(20, 0), days = listOf(DayOfWeek.SATURDAY), isActive = true),
        Alarm(id = 63, title = "Alarm 63", time = LocalTime.of(20, 15), days = listOf(DayOfWeek.SUNDAY), isActive = false),
        Alarm(id = 64, title = "Alarm 64", time = LocalTime.of(20, 30), days = listOf(DayOfWeek.MONDAY, DayOfWeek.TUESDAY, DayOfWeek.WEDNESDAY, DayOfWeek.THURSDAY, DayOfWeek.FRIDAY, DayOfWeek.SATURDAY, DayOfWeek.SUNDAY), isActive = true),
        Alarm(id = 65, title = "Alarm 65", time = LocalTime.of(20, 45), days = listOf(DayOfWeek.MONDAY), isActive = false)
    )

    override suspend fun getAlarms(): List<Alarm> {
        return dummyAlarms.toList()
    }

    override suspend fun addAlarm(alarm: Alarm) {
        dummyAlarms.add(alarm.copy(id = (dummyAlarms.maxOfOrNull { it.id } ?: 0) + 1))
    }

    override suspend fun deleteAlarm(id: Long) {
        dummyAlarms.removeAll { it.id == id }
    }

    override suspend fun setAlarmActive(id: Long, isActive: Boolean) {
        val index = dummyAlarms.indexOfFirst { it.id == id }
        if (index != -1) {
            dummyAlarms[index] = dummyAlarms[index].copy(isActive = isActive)
        }
    }

    override suspend fun getAlarmDetail(id: Long): Alarm {
        return dummyAlarms.first { it.id == id }
    }
}
