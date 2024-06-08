package com.example.task.ui.qr

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.task.R
import com.example.task.databinding.FragmentQrBinding
import com.example.task.viewmodel.qr.QRViewModel
import com.example.task.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class QRFragment : BaseFragment<FragmentQrBinding>() {
    private val qrViewModel by viewModel<QRViewModel>()
    private val args : QRFragmentArgs by navArgs()



    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentQrBinding = FragmentQrBinding.inflate(inflater , container , false)


    override fun initClicks() {
        binding.toolbar.backBtn.setOnClickListener {
            navigateUp()
        }
    }

    override fun initViewModel() {
        qrViewModel.generateQrCode(requireContext(),
            args.argsPayment,
            binding.qrCodeImageView,
            args.argsAuth
            )
    }

    override fun onCreateInit() {
    }

    override fun initSetAdapter() {
    }

    override fun initToolBar() {
        binding.toolbar.tvTitle.text = getString(R.string.scan_qr_code)
    }


    private fun navigateUp(){
        findNavController().navigateUp()
    }


}