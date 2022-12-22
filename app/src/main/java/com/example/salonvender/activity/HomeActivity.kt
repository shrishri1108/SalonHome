package com.example.salonvender.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentTransaction
import com.example.salonvender.R
import com.example.salonvender.fragment.*


class HomeActivity : AppCompatActivity() {

    lateinit var binding: com.example.salonvender.databinding.ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        this.applicationContext.applicationContext

        val fgTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fgTransaction.add(R.id.container, Create_your_Account())
        fgTransaction.commit()
//
//        val fragment = Create_your_Account()
//
//        supportFragmentManager.beginTransaction().apply {
//            replace(R.id.container, fragment).commit()
//        }

       this.startActivity(Intent(this@HomeActivity, Add_Services::class.java))

    }
}

