package com.example.salonvender.Data_Class

data class BankDetail(
    val account_holder_name: String,
    val account_no: String,
    val bank_name: String,
    val created_at: String,
    val deleted_at: Any,
    val id: Int,
    val ifsc_code: String,
    val image: String,
    val updated_at: String,
    val user_id: String
)