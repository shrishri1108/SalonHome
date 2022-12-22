package com.example.salonvender.activity

import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.salonvender.R
import com.example.salonvender.databinding.ActivityHomeDashBinding
import com.example.salonvender.fragment.AccountFragment
import com.example.salonvender.fragment.AppointmentFragment
import com.example.salonvender.fragment.HomeFragment
import com.example.salonvender.fragment.SalesFragment


class HomeActivity_dash : AppCompatActivity() {

    lateinit var binding: ActivityHomeDashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home_dash)


        /* val view: View = getWindow().getDecorView()
         var flags: Int = view.getSystemUiVisibility()
         flags = flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
         view.setSystemUiVisibility(flags)
         getWindow().setStatusBarColor(Color.parseColor("#7A000066"))*/


        actionBar?.title = Html.fromHtml("<font color='#FFFFFF'>ActionBar-title </font>")


        val fgTransaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        fgTransaction.replace(R.id.container, HomeFragment())
        fgTransaction.commit()

        val homeFragment = HomeFragment()
        val appointmentFragment = AppointmentFragment()
        val salesFragment = SalesFragment()
        val accountFragment = AccountFragment()
        //val mainFragment = HomeFragment()

        setCurrentFragment(homeFragment)

        binding.bottomNegivation.setOnItemSelectedListener { item ->
            when (item.itemId) {

                R.id.Appointment -> setCurrentFragment(appointmentFragment)
                R.id.sales -> setCurrentFragment(salesFragment)
                R.id.account -> setCurrentFragment(accountFragment)
                R.id.home -> setCurrentFragment(homeFragment)


            }
            true
        }


    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.container, fragment).commit()
        }

    }
}