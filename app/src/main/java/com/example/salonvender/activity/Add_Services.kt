package com.example.salonvender.activity

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.salonvender.R
import com.example.salonvender.databinding.ActivityAddServicesBinding

class Add_Services : AppCompatActivity() {
    private val categoryList =
        arrayOf("Hair Cut", "Hair Coloring", "Hair Wash", "Shaving", "Skin Care", "Hair Dryer")
    lateinit var addServicesBinding: ActivityAddServicesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        addServicesBinding = DataBindingUtil.setContentView(this, R.layout.activity_add_services)
        addServicesBinding= DataBindingUtil.setContentView(this, R.layout.activity_add_services)
        this.applicationContext.applicationContext


//        addServicesBinding.categorySpinner.setAdapter(new ServicesCategoryAdapter(this, categoryList));
        addServicesBinding.categoryCard.setOnClickListener {


            if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
                addServicesBinding.categoryItemCard.visibility = View.GONE

                addServicesBinding.hairCut.setOnClickListener {
                    addServicesBinding.category.text = addServicesBinding.hairCut.text
                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
                        addServicesBinding.categoryItemCard.visibility = View.GONE
                    }

                }

                addServicesBinding.hairColoring.setOnClickListener {
                    addServicesBinding.category.text = addServicesBinding.hairColoring.text
                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
                        addServicesBinding.categoryItemCard.visibility = View.GONE
                    }
                }

                addServicesBinding.hairDryer.setOnClickListener {
                    addServicesBinding.category.text = addServicesBinding.hairDryer.text
                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
                        addServicesBinding.categoryItemCard.visibility = View.GONE
                    }
                }
                addServicesBinding.hairWash.setOnClickListener {
                    addServicesBinding.category.text = addServicesBinding.hairWash.text
                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
                        addServicesBinding.categoryItemCard.visibility = View.GONE
                    }
                }
                addServicesBinding.shaving.setOnClickListener {
                    addServicesBinding.category.text = addServicesBinding.shaving.text
                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
                        addServicesBinding.categoryItemCard.visibility = View.GONE
                    }
                }
                addServicesBinding.skinCare.setOnClickListener {
                    addServicesBinding.category.text = addServicesBinding.skinCare.text
                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
                        addServicesBinding.categoryItemCard.visibility = View.GONE
                    }
                }
            } else {
                addServicesBinding.categoryItemCard.visibility = View.VISIBLE
                addServicesBinding.hairCut.setOnClickListener {
                    addServicesBinding.category.text = addServicesBinding.hairCut.text
                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
                        addServicesBinding.categoryItemCard.visibility = View.GONE
                    }

                }


                addServicesBinding.hairColoring.setOnClickListener {
                    addServicesBinding.category.text = addServicesBinding.hairColoring.text
                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
                        addServicesBinding.categoryItemCard.visibility = View.GONE
                    }
                }

                addServicesBinding.hairDryer.setOnClickListener {
                    addServicesBinding.category.text = addServicesBinding.hairDryer.text
                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
                        addServicesBinding.categoryItemCard.visibility = View.GONE
                    }
                }
                addServicesBinding.hairWash.setOnClickListener {
                    addServicesBinding.category.text = addServicesBinding.hairWash.text
                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
                        addServicesBinding.categoryItemCard.visibility = View.GONE
                    }
                }
                addServicesBinding.shaving.setOnClickListener {
                    addServicesBinding.category.text = addServicesBinding.shaving.text
                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
                        addServicesBinding.categoryItemCard.visibility = View.GONE
                    }
                }
                addServicesBinding.skinCare.setOnClickListener {
                    addServicesBinding.category.text = addServicesBinding.skinCare.text
                    if (addServicesBinding.categoryItemCard.visibility == View.VISIBLE) {
                        addServicesBinding.categoryItemCard.visibility = View.GONE
                    }
                }

            }


        }

    }
}