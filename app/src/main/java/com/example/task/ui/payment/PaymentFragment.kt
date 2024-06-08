package com.example.task.ui.payment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.task.R
import com.example.task.databinding.FragmentPaymentBinding
import com.example.task.viewmodel.payment.PaymentViewModel
import com.example.task.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class PaymentFragment : BaseFragment<FragmentPaymentBinding>() {
    private val paymentViewModel by viewModel<PaymentViewModel>()
    private val args : PaymentFragmentArgs by navArgs()

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentPaymentBinding = FragmentPaymentBinding.inflate(inflater , container , false)


    override fun initClicks() {
        binding.toolbar.backBtn.setOnClickListener {
            navigateUp()
        }
        binding.fiveEgpBtn.setOnClickListener { navigateToQRFragment(getString(R.string.five_egp)) }
        binding.sevenEgpBtn.setOnClickListener { navigateToQRFragment(getString(R.string.seven_egp)) }
        binding.tenEgpBtn.setOnClickListener {  navigateToQRFragment(getString(R.string.ten_egp))}
    }

    override fun initViewModel() {
    }

    override fun onCreateInit() {
    }

    override fun initSetAdapter() {
    }

    override fun initToolBar() {
        binding.toolbar.tvTitle.text = getString(R.string.payment_process)

    }
    private fun navigateUp(){
        findNavController().navigateUp()
    }

    private fun navigateToQRFragment(paymentValue : String){
        if (checkCurrentDestination(R.id.paymentFragment)) {
            val action =
                PaymentFragmentDirections.actionPaymentFragmentToQRFragment(args.argsAuth,paymentValue)
            findNavController().navigate(action)
        }
    }
}