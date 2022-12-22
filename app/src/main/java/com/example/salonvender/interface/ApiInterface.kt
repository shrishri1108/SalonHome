package com.example.salonvender.`interface`

import com.example.salonvender.Data_Class.Fill_Profile
import com.example.salonvender.Data_Class.LoginOtpData_class
import com.example.salonvender.model.LoginAccountData
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {


    @POST("saloon/api/send-otp")
    fun sendAllOtp(@Body data: HashMap<String, String>): Call<LoginAccountData>

    @POST("saloon/api/login")
    fun logInApi(@Body data: HashMap<String, String>): Call<LoginOtpData_class>

    /* @POST("saloon/api/update-profile")
      fun upload(@Body data: HashMap<String, String>):Call<Fill_Profile>*/
    /*   @Headers("Content-Type: multipart/form-data","Content-Type: text/plain")
       @FormUrlEncoded
       @POST("saloon/api/update-profile")
       fun upload(@Field("email") email: String,
                  @Field("name") name: String?,
                  @Field("phone") phone: String,
                  @Field("gender") gender: String,
                  @Field("dob") dob: String,
                  @Field("vendor_type") vendor_type: String,
                  @Field("bank_name") bank_name: String,
                  @Field("account_holder_name") account_holder_name: String,
                  @Field("account_no") account_no: String,
                  @Field("ifsc_code") ifsc_code: String,
                  ):Call<Fill_Profile>*/


    @Multipart
    @POST("saloon/api/update-profile")
    fun uploadToApi(
        @Part("email") email: RequestBody,
        @Part("name") name: RequestBody,
        @Part("phone") phone: RequestBody,
        @Part("gender") gender: RequestBody,
        @Part("dob") dob: RequestBody,
        @Part("vendor_type") vendor_type: RequestBody,
        @Part("bank_name") bank_name: RequestBody,
//        @Part("check_image") check_image: MultipartBody.Part,
        @Part("location") location: RequestBody,
//        @Part("user_image") user_image: MultipartBody.Part,
//        @Part("id_proof_image") id_proof_image: MultipartBody.Part,
        @Part("account_holder_name") account_holder_name: RequestBody,
//        @Part("licence_image") licence_image: MultipartBody.Part,
        @Part("account_no") account_no: RequestBody,
        @Part("service_for") service_for: RequestBody,
        @Part("ifsc_code") ifsc_code: RequestBody
    ): Call<Fill_Profile>


//        @POST("saloon/api/update-profile")
//        open fun Name(
//                @Field(SyncStateContract.Constants.ACTION_ID) actionId: String?,
//                @Field(SyncStateContract.Constants.OFFER_CODE) offerCode: String?
//        ): Call<PlanResponse?>?

}