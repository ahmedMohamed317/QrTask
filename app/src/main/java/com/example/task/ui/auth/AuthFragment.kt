package com.example.task.ui.auth

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.navigation.fragment.findNavController
import com.example.task.R
import com.example.task.databinding.FragmentAuthBinding
import com.example.task.viewmodel.auth.AuthViewModel
import com.example.task.base.BaseFragment
import com.example.task.model.auth.BodyAuthentication
import com.example.task.util.CheckValidData
import org.koin.androidx.viewmodel.ext.android.viewModel


class AuthFragment : BaseFragment<FragmentAuthBinding>() {
    private val authViewModel by viewModel<AuthViewModel>()
    private lateinit var bodyAuthentication : BodyAuthentication
    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentAuthBinding = FragmentAuthBinding.inflate(inflater , container , false)


    override fun initClicks() {
        binding.nextBtn.setOnClickListener {
            if (checkData()){
                navigateToPaymentFragment(returnBodyAuth())
            }
        }
    }

    override fun initViewModel() {
    }

    override fun onCreateInit() {
        authViewModel.registerMobileInsideCountryCode(binding.countryCode,binding.mobileInputLayout)
        watchInputData()
        authViewModel.getAndSetSpinnerData(binding.spinGenders)
        handleSpinner()
    }

    override fun initSetAdapter() {
    }

    override fun initToolBar() {
        binding.toolbar.backBtn.visibility = View.GONE
        binding.toolbar.tvTitle.text = getString(R.string.registration_form)
    }


    private fun checkData(): Boolean {
        return  CheckValidData.checkName(binding.nameInputLayout,requireContext()) &&
                CheckValidData.checkPhone(binding.countryCode, binding.mobileInputLayout)&&
                CheckValidData.checkAge(binding.ageInputLayout)&&
                checkIfGenderSelected()

    }

    private fun watchInputData() {
        authViewModel.watchName(binding.nameInputLayout)
        authViewModel.watchMobileLength(binding.mobileInputLayout,binding.countryCode)
        authViewModel.watchAge(binding.ageInputLayout)
    }

    private fun returnBodyAuth() : BodyAuthentication{
         bodyAuthentication = BodyAuthentication(
            name = binding.nameInputLayout.editText?.text.toString(),
            age = binding.ageInputLayout.editText?.text.toString(),
            mobileNumber = binding.mobileInputLayout.editText?.text.toString(),
            gender = binding.spinGenders.selectedItem.toString()
            )
        return bodyAuthentication
    }

    private fun navigateToPaymentFragment(bodyAuthentication: BodyAuthentication){
        if (checkCurrentDestination(R.id.authFragment)) {
            val action =
                AuthFragmentDirections.actionAuthFragmentToPaymentFragment(bodyAuthentication)
            findNavController().navigate(action)
        }
    }
    private fun checkIfGenderSelected():Boolean{
        if (binding.spinGenders.selectedItemPosition== -1){
            binding.spinnerError.visibility = View.VISIBLE
        }
        else{
            binding.spinnerError.visibility = View.GONE
        }
        return binding.spinGenders.selectedItemPosition!=-1
    }
    private fun handleSpinner() {
        binding.spinGenders.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position).toString()
                if (position != -1) {
                    binding.spinnerError.visibility = View.GONE
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }
    }

}