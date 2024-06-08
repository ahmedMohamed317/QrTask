package com.example.task.viewmodel.qr

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Point
import android.util.Log
import android.view.Display
import android.view.WindowManager
import android.widget.ImageView
import androidmads.library.qrgenearator.QRGContents
import androidmads.library.qrgenearator.QRGEncoder
import androidx.lifecycle.viewModelScope
import com.example.task.repository.qr.QRRepository
import com.example.task.base.BaseViewModel
import com.example.task.model.auth.BodyAuthentication
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class QRViewModel(private val repository: QRRepository) : BaseViewModel() {

    private var qrJob: Job? = null

    fun generateQrCode(
        context: Context,
        payment: String,
        qrImageView: ImageView,
        bodyAuthentication: BodyAuthentication
    ) {
        qrJob?.cancel()
        qrJob = viewModelScope.launch(Dispatchers.Main) {
            while (true) {
                try {
                    val bitmap = generateQrBitmap(context, bodyAuthentication, payment)
                    qrImageView.setImageBitmap(bitmap)
                } catch (e: Exception) {
                    Log.d("QR_Exception", e.message.toString())
                    e.printStackTrace()
                }
                delay(5000)
            }
        }
    }

    private fun generateQrBitmap(context: Context, bodyAuthentication: BodyAuthentication, payment: String): Bitmap {
        val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display: Display = windowManager.defaultDisplay
        val point = Point()
        display.getSize(point)
        val width = point.x
        val height = point.y
        var dimen = if (width < height) width else height
        dimen = dimen * 3 / 4

        val qrEncoder = QRGEncoder(prepareQrString(bodyAuthentication, payment), null, QRGContents.Type.TEXT, dimen)
        return qrEncoder.bitmap
    }



    private fun prepareQrString(bodyAuthentication: BodyAuthentication, payment: String): String {
        val dateTime = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).format(Date())
        return "${bodyAuthentication.name}-${bodyAuthentication.age}-${bodyAuthentication.gender}-$payment-$dateTime"
    }
}