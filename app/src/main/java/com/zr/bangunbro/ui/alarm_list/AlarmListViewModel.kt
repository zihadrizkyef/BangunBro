package com.zr.bangunbro.ui.alarm_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zr.bangunbro.domain.model.Alarm
import com.zr.bangunbro.domain.usecase.GetAlarmUseCase
import com.zr.bangunbro.domain.usecase.SetAlarmActiveUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AlarmListViewModel(
    private val getAlarmUseCase: GetAlarmUseCase,
    private val setAlarmActiveUseCase: SetAlarmActiveUseCase,
) : ViewModel() {
    private val _alarms = MutableStateFlow<List<Alarm>>(emptyList())
    val alarms: StateFlow<List<Alarm>> = _alarms

    init {
        getAlarms()
    }

    fun getAlarms() = viewModelScope.launch {
        _alarms.value = getAlarmUseCase()
    }

    fun setAlarmActive(id: Long, isActive: Boolean) = viewModelScope.launch {
        setAlarmActiveUseCase(id, isActive)
        getAlarms()
    }
}