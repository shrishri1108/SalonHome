package com.example.salonvender


import com.example.salonvender.`interface`.ApiInterface
import com.example.salonvender.activity.App
import com.example.salonvender.singalton_object.PrefManager
import com.google.gson.GsonBuilder


import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import java.util.concurrent.TimeUnit

class RestClient private constructor() {
    var client: OkHttpClient? = null
    var retrofit: Retrofit? = null
    var mRestService: ApiInterface? = null


    fun setup() {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.MINUTES)
            .readTimeout(5, TimeUnit.MINUTES)
            .writeTimeout(5, TimeUnit.MINUTES)
        // Should be used only in Debug Mode.
        if (true) {
            val interceptor = HttpLoggingInterceptor()
            interceptor.setLevel(if (true) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
            builder.addInterceptor(interceptor)
        }
        val gson = GsonBuilder()
            .setLenient()
            .create()


        if (PrefManager.getInstance(App.getInstance())!!.keyIsLoggedIn) {
            client = (builder.addInterceptor { chain ->
                val request = chain.request().newBuilder().addHeader(
                    "Authorization",
                    "Bearer ${PrefManager.getInstance(App.getInstance())!!.userDetail.token}"
                ).build()
                chain.proceed(request)
            }.build())
        }
        else {
            client = builder.build()
        }

        retrofit = Retrofit.Builder()
            .baseUrl("https://teknikoglobal.in/")
            .client(client!!) //.addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
        mRestService = retrofit!!.create(ApiInterface::class.java)
    }

    companion object {
        val inst = RestClient()
    }
}