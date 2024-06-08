package com.example.task.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<T : ViewBinding> : AppCompatActivity() {

    private var _binding: T? = null
    val binding get() = _binding


    protected abstract fun getViewBinding(inflater: LayoutInflater): T

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = getViewBinding(layoutInflater)
        setContentView(_binding?.root)
        onCreateInit()
        initClicks()
    }

    protected abstract fun initClicks()

    protected abstract fun onCreateInit()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}