package com.zr.bangunbro.di

import com.zr.bangunbro.data.repository.AlarmRepository
import com.zr.bangunbro.domain.repository.IAlarmRepository
import com.zr.bangunbro.domain.usecase.AddAlarmUseCase
import com.zr.bangunbro.domain.usecase.DeleteAlarmUseCase
import com.zr.bangunbro.domain.usecase.GetAlarmDetailUseCase
import com.zr.bangunbro.domain.usecase.GetAlarmUseCase
import com.zr.bangunbro.domain.usecase.SetAlarmActiveUseCase
import com.zr.bangunbro.ui.alarm_list.AlarmListViewModel
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val appModule = module {
    singleOf(::AlarmRepository) { bind<IAlarmRepository>() }
}

val useCaseModule = module {
    factoryOf(::AddAlarmUseCase)
    factoryOf(::GetAlarmUseCase)
    factoryOf(::DeleteAlarmUseCase)
    factoryOf(::GetAlarmDetailUseCase)
    factoryOf(::SetAlarmActiveUseCase)
}

val viewModelModule = module {
    singleOf(::AlarmListViewModel)
}