package com.example.salonvender.activity

import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.salonvender.R
import com.example.salonvender.databinding.ActivityAddServicesBinding
import com.example.salonvender.model.LoginViewModel
import com.example.salonvender.singalton_object.PrefManager

class Add_Services : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var viewModel: LoginViewModel
    val categoryList =
        ArrayList<String>()
    lateinit var addServicesBinding: ActivityAddServicesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        addServicesBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_services)
        addServicesBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_services)
        this.applicationContext.applicationContext


//        addServicesBinding.categorySpinner.setOnItemSelectedListener(this@Add_Services);

        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]

//
        addServicesBinding.categorySpinner.setOnItemSelectedListener(this)

        // Create an ArrayAdapter using a simple spinner layout and languages array
        val aa = ArrayAdapter(this, android.R.layout.simple_spinner_item, categoryList)
        // Set layout to use when the list of choices appear
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Set Adapter to Spinner
        addServicesBinding.categorySpinner.setAdapter(aa)
        categoryList.add("Select Category")

        viewModel.getCategory(PrefManager.getInstance(App.getInstance())!!.userDetail.token).observe(this, Observer {
            if(it.result) {
                Log.d("categoryhitres", "onCreate: Successful ")
                for( category_single in it.categories) {
                    if(category_single != null) {
                        categoryList.add( category_single.name)
                    }
                }
            }
            else {
                Toast.makeText(applicationContext, ""+it.message, Toast.LENGTH_SHORT).show()
            }
        })


//        addServicesBinding.switchGender.textOn="Female"
//        addServicesBinding.switchGender.textOff="Male"
//        addServicesBinding.switchGender.setBackgroundColor(Color.BLUE)
//          addServicesBinding.switchGender.setOnClickListener(View.OnClickListener {
//
//          })
//        addServicesBinding.categoryCard.setOnClickListener {
//
//        }
        //        if(addServicesBinding.switchGender.isChecked) {
////            addServicesBinding.switchGender.setBackgroundColor(Color.MAGENTA)
//            addServicesBinding.switchGender.textOn= "Male"
//
//        }
//        else {
////            addServicesBinding.switchGender.setBackgroundColor(Color.BLUE)
//        addServicesBinding.switchGender.textOff= "Female"
//        }
//        addServicesBinding.mrpPrice.paintFlags= View.INVISIBLE
//        addServicesBinding.etOfferPrice.paintFlags= View.INVISIBLE
//
//        addServicesBinding.switchLays.setOnClickListener {
//
//
//            if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
//                addServicesBinding.categoryItemCard.visibility = View.GONE
//
//                addServicesBinding.hairCut.setOnClickListener {
//                    addServicesBinding.category.text = addServicesBinding.hairCut.text
//                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
//                        addServicesBinding.categoryItemCard.visibility = View.GONE
//                    }
//
//                }
//
//                addServicesBinding.hairColoring.setOnClickListener {
//                    addServicesBinding.category.text = addServicesBinding.hairColoring.text
//                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
//                        addServicesBinding.categoryItemCard.visibility = View.GONE
//                    }
//                }
//
//                addServicesBinding.hairDryer.setOnClickListener {
//                    addServicesBinding.category.text = addServicesBinding.hairDryer.text
//                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
//                        addServicesBinding.categoryItemCard.visibility = View.GONE
//                    }
//                }
//                addServicesBinding.hairWash.setOnClickListener {
//                    addServicesBinding.category.text = addServicesBinding.hairWash.text
//                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
//                        addServicesBinding.categoryItemCard.visibility = View.GONE
//                    }
//                }
//                addServicesBinding.shaving.setOnClickListener {
//                    addServicesBinding.category.text = addServicesBinding.shaving.text
//                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
//                        addServicesBinding.categoryItemCard.visibility = View.GONE
//                    }
//                }
//                addServicesBinding.skinCare.setOnClickListener {
//                    addServicesBinding.category.text = addServicesBinding.skinCare.text
//                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
//                        addServicesBinding.categoryItemCard.visibility = View.GONE
//                    }
//                }
//            } else {
//                addServicesBinding.categoryItemCard.visibility = View.VISIBLE
//                addServicesBinding.hairCut.setOnClickListener {
//                    addServicesBinding.category.text = addServicesBinding.hairCut.text
//                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
//                        addServicesBinding.categoryItemCard.visibility = View.GONE
//                    }
//
//                }
//
//
//                addServicesBinding.hairColoring.setOnClickListener {
//                    addServicesBinding.category.text = addServicesBinding.hairColoring.text
//                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
//                        addServicesBinding.categoryItemCard.visibility = View.GONE
//                    }
//                }
//
//                addServicesBinding.hairDryer.setOnClickListener {
//                    addServicesBinding.category.text = addServicesBinding.hairDryer.text
//                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
//                        addServicesBinding.categoryItemCard.visibility = View.GONE
//                    }
//                }
//                addServicesBinding.hairWash.setOnClickListener {
//                    addServicesBinding.category.text = addServicesBinding.hairWash.text
//                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
//                        addServicesBinding.categoryItemCard.visibility = View.GONE
//                    }
//                }
//                addServicesBinding.shaving.setOnClickListener {
//                    addServicesBinding.category.text = addServicesBinding.shaving.text
//                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
//                        addServicesBinding.categoryItemCard.visibility = View.GONE
//                    }
//                }
//                addServicesBinding.skinCare.setOnClickListener {
//                    addServicesBinding.category.text = addServicesBinding.skinCare.text
//                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
//                        addServicesBinding.categoryItemCard.visibility = View.GONE
//                    }
//                }
//
//            }
//
//
//        }

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        addServicesBinding.categorySpinner.isSelected = true
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}
