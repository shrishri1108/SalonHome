package com.example.salonvender.fragment

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.salonvender.R
import com.example.salonvender.databinding.FragmentLoginBinding
import com.example.salonvender.model.LoginViewModel


class LoginFragment : Fragment() {

    lateinit var viewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentLoginBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)


        binding.buttonLoginNextBtn.setOnClickListener {

            fun isEmpty(enter: AppCompatEditText): Boolean {

                val str: CharSequence = binding.enter.text.toString()
                return TextUtils.isEmpty(str)

            }


            if (isEmpty(binding.enter)) {

                Toast.makeText(activity, "please fill mobile number", Toast.LENGTH_SHORT).show()
                binding.enter.error="please fill mobile number"

            }
            else {

                if (binding.enter.length() == 10) {

                    viewModel = ViewModelProvider(this)[LoginViewModel::class.java]


                    val hashmap = HashMap<String, String>()
                    hashmap["phone"] = binding.enter.text.toString()

                    viewModel.sendAllOtp(hashmap).observe(viewLifecycleOwner, Observer { it ->

                        if (it.result.equals("success")) {


                            val loginOtpFragment = Login_otp_Fragment()
                            val bundle = Bundle()

                            bundle.putString("phone", binding.enter.text.toString())
                            bundle.putString(
                                "cpp_code",
                                binding.countryPicker.selectedCountryCodeWithPlus
                            )

                            loginOtpFragment.arguments = bundle

                            requireActivity().supportFragmentManager.beginTransaction()
                                .replace(R.id.container, loginOtpFragment).commit()


                        }
                        Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()


                    })


                } else {

                    Toast.makeText(activity, "please enter 10 digit number", Toast.LENGTH_SHORT)
                        .show()
                    binding.enter.error = "10 digit number"


                }

            }


        }

        return binding.root
    }


}