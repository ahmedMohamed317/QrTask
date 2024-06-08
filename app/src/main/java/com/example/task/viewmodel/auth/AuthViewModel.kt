package com.example.task.viewmodel.auth

import android.content.Context
import androidx.core.widget.doOnTextChanged
import com.chivorn.smartmaterialspinner.SmartMaterialSpinner
import com.example.task.R
import com.example.task.repository.auth.AuthRepository
import com.example.task.base.BaseViewModel
import com.example.task.util.CheckValidData
import com.google.android.material.textfield.TextInputLayout
import com.hbb20.CountryCodePicker

class AuthViewModel(private val repository: AuthRepository) : BaseViewModel() {

    fun watchName(textInputLayout: TextInputLayout) {
        textInputLayout.editText?.doOnTextChanged { text, start, before, count ->
            if (text?.length!! > 1) {
                if (textInputLayout.error != null) {
                    textInputLayout.error = null
                }
            }else{
                textInputLayout.error = "Please enter a valid name"
            }
        }
    }

    fun watchMobileLength(mobileInputLayout: TextInputLayout,countryCodePicker: CountryCodePicker) {
        mobileInputLayout.editText?.doOnTextChanged { text, start, before, count ->

            CheckValidData.checkPhone(countryCodePicker,mobileInputLayout)

        }
    }

    fun registerMobileInsideCountryCode(countryCodePicker: CountryCodePicker,mobileInputLayout: TextInputLayout) {
        countryCodePicker.setCountryForNameCode("EG")
        countryCodePicker.registerCarrierNumberEditText(mobileInputLayout.editText)
    }

    fun watchAge(textInputLayout: TextInputLayout) {
        textInputLayout.editText?.doOnTextChanged { text, start, before, count ->
            if (text?.toString()?.toInt()!! >12) {
                if (textInputLayout.error != null) {
                    textInputLayout.error = null
                }
            }else{
                textInputLayout.error = "Please enter valid age"
            }
        }
    }
    fun getAndSetSpinnerData(spinner: SmartMaterialSpinner<Any>){
        spinner.item = repository.getSpinnerData()
    }


}