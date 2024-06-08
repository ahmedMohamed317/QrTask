package com.example.task.model.auth

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class BodyAuthentication(
    @SerializedName("name")
    var name: String,
    @SerializedName("age")
    var age: String,
    @SerializedName("mobileNumber")
    var mobileNumber: String,
    @SerializedName("gender")
    var gender: String,
    ): Parcelable
