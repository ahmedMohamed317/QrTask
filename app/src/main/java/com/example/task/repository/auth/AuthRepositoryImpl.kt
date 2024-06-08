package com.example.task.repository.auth


import android.content.Context
import com.example.task.util.AppResult
import com.example.task.util.Utils.handleApiError
import com.example.task.util.Utils.handleSuccess

class AuthRepositoryImpl(
    private val context: Context
) : AuthRepository {

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
    override fun getSpinnerData(): List<String> {
        return listOf("Male","Female")
    }


}