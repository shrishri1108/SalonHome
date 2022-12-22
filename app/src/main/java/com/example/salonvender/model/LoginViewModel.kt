package com.example.salonvender.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.salonvender.Data_Class.Fill_Profile
import com.example.salonvender.Data_Class.LoginOtpData_class
import com.example.salonvender.LoginAccountRepository
import okhttp3.RequestBody
import retrofit2.http.Part

class LoginViewModel : ViewModel() {
    private var sendOtp: MutableLiveData<LoginAccountData>? = null
    private var recieveOtp: MutableLiveData<LoginOtpData_class>? = null
    private var upload: MutableLiveData<Fill_Profile>? = null

    fun sendAllOtp(hashmap: HashMap<String, String>): LiveData<LoginAccountData> {
        sendOtp = LoginAccountRepository.sendAllOtp(hashmap)
        return sendOtp!!
    }

    fun recieveOtp(hashmap: HashMap<String, String>): LiveData<LoginOtpData_class> {
        recieveOtp = LoginAccountRepository.recieveAllOtp(hashmap)
        return recieveOtp!!
    }


    fun upload(
        @Part("email") email: RequestBody,
        @Part("name") name: RequestBody,
        @Part("phone") phone: RequestBody,
        @Part("gender") gender: RequestBody,
        @Part("dob") dob: RequestBody,
        @Part("vendor_type") vendor_type: RequestBody,
        @Part("bank_name") bank_name: RequestBody,
        @Part("check_image") check_image: RequestBody,
        @Part("location") location: RequestBody,
        @Part("user_image") user_image: RequestBody,
        @Part("id_proof_image") id_proof_image: RequestBody,
        @Part("account_holder_name") account_holder_name: RequestBody,
        @Part("licence_image") licence_image: RequestBody,
        @Part("account_no") account_no: RequestBody,
        @Part("service_for") service_for: RequestBody,
        @Part("ifsc_code") ifsc_code: RequestBody
    ): LiveData<Fill_Profile> {

        upload = LoginAccountRepository.etsProfileApi(email,name,phone,gender,dob,vendor_type,bank_name,account_holder_name,account_no,ifsc_code,id_proof_image,licence_image,user_image,check_image, service_for,location)
//        upload = LoginAccountRepository.etsProfileApi(
//            email,
//            name,
//            phone,
//            gender,
//            dob,
//            vendor_type,
//            bank_name,
//            location,
//            account_holder_name,
//            account_no,
////            user_image,
//        service_for,
//            ifsc_code
//        )

        return upload!!


    }


}
