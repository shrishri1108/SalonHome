package com.example.salonvender.fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.salonvender.R
import com.example.salonvender.activity.HomeActivity
import com.example.salonvender.activity.HomeActivity_dash
import com.example.salonvender.databinding.FragmentLoginOtpBinding
import com.example.salonvender.databinding.FragmentOtpBinding
import com.example.salonvender.model.LoginViewModel
import com.example.salonvender.singalton_object.PrefManager


class Login_otp_Fragment : Fragment() {
    lateinit var viewModel: LoginViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding: FragmentLoginOtpBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_login_otp_, container, false)


        val phone = requireArguments().getString("phone")
        val cpp_code = requireArguments().getString("cpp_code").toString()
        Log.d("phone==>>>>", phone.toString())
        binding.mobileNumber.text = cpp_code+phone.toString()

        binding.back.setOnClickListener {

            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, Create_your_Account()).commit()
        }


        binding.nextBtn.setOnClickListener {

            fun isEmpty(otppin: AppCompatEditText): Boolean {

                val str: CharSequence = binding.otpPin.text.toString()
                return TextUtils.isEmpty(str)

            }

            if (isEmpty(binding.otpPin)) {

                Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show()
                binding.otpPin.error = "please enter otp"

            } else {



                viewModel = ViewModelProvider(this)[LoginViewModel::class.java]


                val hashmap = HashMap<String, String>()
                hashmap["phone"] = phone.toString()
                hashmap["otp"] = binding.otpPin.text.toString()


//                hashmap["device_id"] = binding.otpPin.text.toString()
//                hashmap["device_token'"] = binding.otpPin.text.toString()

                hashmap["device_id"] = "dchgsjhkjsb"
                hashmap["device_token"] = "hchwjkcjkwk"

//

                viewModel.recieveOtp(hashmap).observe(viewLifecycleOwner, Observer { it ->
                    //Toast.makeText(this.activity, "Access", Toast.LENGTH_SHORT).show()
                    //Log.d("aaaa", "aaaa")


                    if (it.status){
                        if (it.agent.is_registered == 0) {

                            Toast.makeText(this.activity, "Access", Toast.LENGTH_SHORT).show()

                            val homeFragment = HomeFragment()
                            PrefManager.getInstance(requireContext())!!.keyIsLoggedIn = true
                            PrefManager.getInstance(requireContext())!!.userDetail = it


//                            val i = Intent(activity, HomeFragment::class.java)
//                        startActivity(i)
//                        (activity as Activity?)!!.overridePendingTransition(0, 0)

                            requireActivity().supportFragmentManager.beginTransaction()
                                .replace(R.id.container, Fill_Profile()).commit()


                            //  Toast.makeText(activity, "", Toast.LENGTH_SHORT).show()

                        } else {

                            Toast.makeText(activity, "Already register", Toast.LENGTH_SHORT).show()

                            requireActivity().supportFragmentManager.beginTransaction()
                                .replace(R.id.container, HomeFragment()).commit()
                        }
                    }else{
                        Toast.makeText(activity, it.message, Toast.LENGTH_SHORT).show()
                    }




                })


            }
        }

        binding.back.setOnClickListener {
            val create_your_Account = Create_your_Account()
            requireActivity().supportFragmentManager.beginTransaction()
                .replace(R.id.container, create_your_Account).commit()

        }



        return binding.root
    }


}