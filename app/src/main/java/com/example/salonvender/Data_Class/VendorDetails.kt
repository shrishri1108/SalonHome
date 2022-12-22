package com.example.salonvender.Data_Class

data class VendorDetails(
    val address: String,
    val contact_no2: String,
    val created_at: String,
    val deleted_at: Any,
    val dob: String,
    val email: String,
    val gender: String,
    val id: Int,
    val id_proof_image: Any,
    val image: String,
    val is_approved: Int,
    val is_registered: Boolean,
    val lat: Int,
    val licence_image: Any,
    val lng: Double,
    val name: String,
    val phone: String,
    val service_for: String,
    val shop_name: String,
    val status: Int,
    val updated_at: String,
    val vendor_type: String,
    val verified_at: Any
)