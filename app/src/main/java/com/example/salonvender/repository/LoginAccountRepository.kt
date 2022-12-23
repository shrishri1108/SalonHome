package com.example.salonvender

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.salonvender.Data_Class.Fill_Profile
import com.example.salonvender.Data_Class.LoginOtpData_class
import com.example.salonvender.model.Categories_response
import com.example.salonvender.model.LoginAccountData
import okhttp3.MultipartBody

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Part


object LoginAccountRepository {
    private var sendOtp = MutableLiveData<LoginAccountData>()
    private var recieveOtp = MutableLiveData<LoginOtpData_class>()
    private var upload = MutableLiveData<Fill_Profile>()
    private var category = MutableLiveData<Categories_response>()


    fun sendAllOtp(hashmap: HashMap<String, String>): MutableLiveData<LoginAccountData> {
        val call = RestClient.inst.mRestService!!.sendAllOtp(hashmap)
        call.enqueue(object : retrofit2.Callback<LoginAccountData> {
            override fun onResponse(
                call: Call<LoginAccountData>,
                response: Response<LoginAccountData>
            ) {
                if (response.isSuccessful) {
                    sendOtp.value = response.body()
                }
            }

            override fun onFailure(call: Call<LoginAccountData>, t: Throwable) {

            }
        })
        return sendOtp
    }

    fun recieveAllOtp(hashmap: HashMap<String, String>): MutableLiveData<LoginOtpData_class> {
        val call = RestClient.inst.mRestService!!.logInApi(hashmap)
        call.enqueue(object : retrofit2.Callback<LoginOtpData_class> {
            override fun onResponse(
                call: Call<LoginOtpData_class>,
                response: Response<LoginOtpData_class>
            ) {
                if (response.isSuccessful) {
                    Log.d("ajkhdaksd", "lkjsdfsd")
                    recieveOtp.value = response.body()

                }
            }

            override fun onFailure(call: Call<LoginOtpData_class>, t: Throwable) {
                Log.d("akjsdasd", t.toString())
            }
        })
        return recieveOtp
    }

    fun getAllCategoryFromRepo(token :String): MutableLiveData<Categories_response> {
        val call = RestClient.inst.mRestService!!.getAllCategory(token)
        call.enqueue(object : retrofit2.Callback<Categories_response> {
            override fun onResponse(
                call: Call<Categories_response>,
                response: Response<Categories_response>
            ) {
                if(response.isSuccessful) {
                    Log.d("categoryhit","onResponse: Success")
                    category.value = response.body()

                }
            }

            override fun onFailure(call: Call<Categories_response>, t: Throwable) {
                Log.d("categoryhit", "onFailure: "+ t.toString())
            }

        })
        return category
    }
    /*fun upload(hashmap: HashMap<String, String>): MutableLiveData<Fill_Profile> {
        val call = RestClient.inst.mRestService!!.upload(
            hashmap.get("email").toString(),
            hashmap.get("name").toString(),
            hashmap.get("phone").toString(),
            hashmap.get("gender").toString(),
            hashmap.get("dob").toString(),
            hashmap.get("vendor_type").toString(),
            hashmap.get("bank_name").toString(),
            hashmap.get("account_holder_name").toString(),
            hashmap.get("account_no").toString(),
            hashmap.get("ifsc_code").toString()
        )

//        fun updateProfileData() {
//            fun getRequestBody(str: String?): RequestBody =
//                str.toString().toRequestBody("text/plain".toMediaTypeOrNull())
//
//
//            Fill_Profile.etsProfileApi(
//                getRequestBody(binding.etFirstName.text.toString()),
//                getRequestBody(binding.etLastName.text.toString()),
//                getRequestBody(binding.etPincode.text.toString()),
//                getRequestBody(binding.etAge.text.toString()),
//                getRequestBody(GANDER),
//                getRequestBody(selectedMarriageStatus)
//            )
//            MutableLiveData.observe(this) {
//                makeToast(it!!.Message)
//                hitgetProfileAPi()
//            }
//        }
        call.enqueue(object : retrofit2.Callback<Fill_Profile> {
            override fun onResponse(call: Call<Fill_Profile>, response: Response<Fill_Profile>) {
                if (response.isSuccessful) {

                    upload.value = response.body()

                }


            }


            override fun onFailure(call: Call<Fill_Profile>, t: Throwable) {

            }
        })
        return upload

    }*/

    var UpdateProfileLiveData: LiveData<Fill_Profile?> = MutableLiveData<Fill_Profile?>()

   /* fun etsProfileApi(
        @Part("firstName") first_name: RequestBody,
        @Part("lastName") last_name : RequestBody,
        @Part("pincode") pincode: RequestBody,
        @Part("age") age: RequestBody,
        @Part("gender") gender: RequestBody,
        @Part("maritalStatus") maritalStatus: RequestBody,
    ) {
        val temp = MutableLiveData<Fill_Profile?>()
        UpdateProfileLiveData = temp
        getResult(temp, apiInterface.updateUserProfile(first_name, last_name, pincode, age,gender, maritalStatus))
    }*/

    fun etsProfileApi(
        @Part("email") email: RequestBody,
        @Part("name") name: RequestBody,
        @Part("phone") phone: RequestBody,
        @Part("gender") gender: RequestBody,
        @Part("dob") dob: RequestBody,
        @Part("vendor_type") vendor_type: RequestBody,
        @Part("bank_name") bank_name: RequestBody,
//        @Part("check_image") check_image: MultipartBody.Part,
        @Part("location") location: RequestBody,
//        @Part user_image: MultipartBody.Part,
//        @Part("id_proof_image") id_proof_image: MultipartBody.Part,
        @Part("account_holder_name") account_holder_name: RequestBody,
//        @Part("licence_image") licence_image: MultipartBody.Part,
        @Part("account_no") account_no: RequestBody,
        @Part("service_for") service_for: RequestBody,
        @Part("ifsc_code") ifsc_code: RequestBody): MutableLiveData<Fill_Profile> {
//        val call = RestClient.inst.mRestService!!.uploadToApi(email,name,phone,gender,dob,vendor_type,bank_name,check_image,location, user_image, id_proof_image, account_holder_name, licence_image, account_no, service_for, ifsc_code)
        val call = RestClient.inst.mRestService!!.uploadToApi(email,name,phone,gender,dob,vendor_type,bank_name, location,account_holder_name,account_no,service_for,ifsc_code)
        call.enqueue(object : retrofit2.Callback<Fill_Profile> {
            override fun onResponse(
                call: Call<Fill_Profile>,
                response: Response<Fill_Profile>
            ) {
                if (response.isSuccessful) {
                    Log.d("hit", "lkjsdfsd")
                    upload.value = response.body()

                }
                else {
                    Log.d("hit", "mErors :"+ response.errorBody()!!.charStream().readText().toString() )
                }
            }

            override fun onFailure(call: Call<Fill_Profile>, t: Throwable) {
                Log.d("hit", " onFailures: "+t.toString())
            }
        })
        return upload
    }
}
