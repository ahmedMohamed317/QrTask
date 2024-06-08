package com.example.task.di

import com.example.task.viewmodel.auth.AuthViewModel
import com.example.task.viewmodel.payment.PaymentViewModel
import com.example.task.viewmodel.qr.QRViewModel
import org.koin.android.ext.koin.androidContext


import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {

    viewModel {
        AuthViewModel(repository = get())
    }

    viewModel {
        PaymentViewModel(repository = get())
    }

    viewModel {
        QRViewModel(repository = get())
    }
}