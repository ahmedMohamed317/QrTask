package com.example.task.viewmodel.payment

import com.example.task.repository.payment.PaymentRepository
import com.example.task.base.BaseViewModel

class PaymentViewModel(private val repository: PaymentRepository) : BaseViewModel() {


//    val responseAuth = SingleLiveEvent<String>()
//
//    fun getTermsAndConditions() {
//        call({
//            return@call repository.getTerms()
//        }) {
//            when (it) {
//                is AppResult.Success -> {
//                    responseGetTerms.postValue(it.successData!!)
//                }
//
//                is AppResult.Error -> {
//                    showError.postValue(it.message)
//                }
//            }
//        }
//
//    }
}