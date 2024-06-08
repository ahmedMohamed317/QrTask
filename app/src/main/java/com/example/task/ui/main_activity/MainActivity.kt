package com.example.task.ui.main_activity

import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.NavHostFragment
import com.example.task.R
import com.example.task.databinding.ActivityMainBinding
import com.example.task.base.BaseActivity


class MainActivity : BaseActivity<ActivityMainBinding>() {
    private lateinit var navHostFragment: NavHostFragment

    override fun getViewBinding(inflater: LayoutInflater) = ActivityMainBinding.inflate(inflater)

    override fun initClicks() {
    }

    override fun onCreateInit() {
        initViews()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }

    private fun initViews() {
        navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment?
            ?: return
    }


}

