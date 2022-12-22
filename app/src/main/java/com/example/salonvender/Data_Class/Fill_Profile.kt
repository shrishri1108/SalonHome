package com.example.salonvender.Data_Class

data class Fill_Profile(
    val bank_detail: BankDetail,
    val message: String,
    val result: Boolean,
    val vendor_details: VendorDetails
)