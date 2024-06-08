package com.example.task.util

import android.content.Context
import com.example.task.R
import com.example.task.util.AppResult

fun Context.noNetworkConnectivityError(): AppResult.Error {
    return AppResult.Error(Exception(this.resources.getString(R.string.no_network_connectivity)))
}

