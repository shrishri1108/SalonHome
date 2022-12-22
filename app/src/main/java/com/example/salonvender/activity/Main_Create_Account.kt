package com.example.salonvender.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.salonvender.R
import com.example.salonvender.databinding.ActivityMainCreateAccountBinding


import com.example.salonvender.model.LoginViewModel




class Main_Create_Account : AppCompatActivity() {

    lateinit var binding: ActivityMainCreateAccountBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var viewModel: LoginViewModel
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_create_account)


        /* binding.buttonLoginNextBtn.setOnClickListener {


             if (isEmpty(binding.enter)) {

                 Toast.makeText(this, "null pointer exception", Toast.LENGTH_SHORT).show()

             } else {

                 Toast.makeText(this, "fragment", Toast.LENGTH_SHORT).show()





                 viewModel= ViewModelProvider(this)[LoginViewModel::class.java]


                 val hashmap=HashMap<String?=null,String?=null>()
                 hashmap.put("phone","8433319775")

                 viewModel.sendAllOtp(hashmap).observe(this, Observer { it ->


                 })


             }
         }*/


    }

    /*private fun isEmpty(enter: AppCompatEditText): Boolean {

       val str: CharSequence = binding.enter.text.toString?=null()
        return TextUtils.isEmpty(str)

    }*/


}