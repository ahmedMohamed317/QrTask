package com.example.task.di

import android.content.Context
import com.example.task.repository.auth.AuthRepository
import com.example.task.repository.auth.AuthRepositoryImpl
import com.example.task.repository.payment.PaymentRepository
import com.example.task.repository.payment.PaymentRepositoryImpl
import com.example.task.repository.qr.QRRepository
import com.example.task.repository.qr.QRRepositoryImpl
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val repositoryModule = module {

    fun provideAuthRepository(
        context: Context
    ): AuthRepository {
        return AuthRepositoryImpl(context)
    }
    single { provideAuthRepository( androidContext()) }

    fun providePaymentRepository(
        context: Context
    ): PaymentRepository {
        return PaymentRepositoryImpl(context)
    }
    single { providePaymentRepository( androidContext()) }

    fun provideQRRepository(
        context: Context
    ): QRRepository {
        return QRRepositoryImpl(context)
    }
    single { provideQRRepository( androidContext()) }

}