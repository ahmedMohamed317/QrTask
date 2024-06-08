package com.example.task.util

import androidx.lifecycle.ViewModel


class SharedViewModel : ViewModel() {

    val itemsNotAvailableLiveEvent = SingleLiveEvent<Boolean>()

    fun setItemsNotAvailable(item: Boolean) {
        itemsNotAvailableLiveEvent.value = item
    }

    fun getItemsNotAvailable(): Boolean? {
        return itemsNotAvailableLiveEvent.value
    }

}