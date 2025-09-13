package com.zr.bangunbro.ui.create_alarm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zr.bangunbro.domain.model.Alarm
import com.zr.bangunbro.domain.usecase.AddAlarmUseCase
import kotlinx.coroutines.launch
import java.time.DayOfWeek
import java.time.LocalTime

class CreateAlarmViewModel(
    private val addAlarmUseCase: AddAlarmUseCase,
) : ViewModel() {
    var title = ""
    var time: LocalTime = LocalTime.now()
    val days = arrayListOf<DayOfWeek>()

    fun saveAlarm() = viewModelScope.launch {
        val alarm = Alarm(
            id = 0,
            title = title,
            time = time,
            days = days,
            isActive = true,
        )
        addAlarmUseCase(alarm)
    }
}