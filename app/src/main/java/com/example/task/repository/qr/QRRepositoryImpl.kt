package com.example.task.repository.qr


import android.content.Context

import com.example.task.util.AppResult
import com.example.task.repository.auth.AuthRepository
import com.example.task.util.Utils.handleApiError
import com.example.task.util.Utils.handleSuccess

class QRRepositoryImpl(
    private val context: Context
) : QRRepository {

//
//    override suspend fun getTerms(): AppResult<ResponseGetAgreements> {
//        return try {
//            val response = api.getTermsAndConditions()
//            if (response.isSuccessful) {
//                //save the data
//                handleSuccess(response)
//            } else {
//                handleApiError(response)
//            }
//        } catch (e: Exception) {
//            AppResult.Error(e)
//        }
//    }


}