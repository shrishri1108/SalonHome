package com.example.salonvender.activity


import android.app.Application
import android.content.Context
import android.location.Geocoder
import com.example.salonvender.RestClient

import com.google.gson.Gson

import java.io.File

class App : Application() {


    companion object {
        private var appContext: Context? = null
        private var gson: Gson? = null
        private var geocoder: Geocoder? = null
        private var applicationInstance: App? = null
        fun getInstance(): App {
            return applicationInstance!!
        }
    }

    private val TAG = "appp"
    var firebaseToken: String? = null

    override
    fun onCreate() {
        super.onCreate()
        applicationInstance = this
        appContext = this


        RestClient.inst.setup()
        gson = Gson()
        geocoder = Geocoder(this)
    }


    @JvmName("getFirebaseToken1")
    fun getFirebaseToken(): String? {
        return firebaseToken
    }


    override
    protected fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        //  MultiDex.install(this);
    }

    fun getGson(): Gson? {
        return gson
    }

    fun getGeoCoder(): Geocoder? {
        return geocoder
    }

/*    public String getAccessToken() {
        try {
            if (PrefManager.getInstance(appContext).getUserDetail() != null) {
                return PrefManager.getInstance(appContext).getUserDetail().getUser().getSession_token();
            } else {
                return "";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }*/

    fun setupApis() {
        RestClient.inst.setup()
    }

    // check how much memory is available for cache video
    fun freeMemory() {
        try {
            val dir = cacheDir
            deleteDir(dir)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        System.runFinalization()
        Runtime.getRuntime().gc()
        System.gc()
    }


    // delete the cache if it is full
    fun deleteDir(dir: File?): Boolean {
        return if (dir != null && dir.isDirectory) {
            val children = dir.list()
            for (i in children.indices) {
                val success = deleteDir(File(dir, children[i]))
                if (!success) {
                    return false
                }
            }
            dir.delete()
        } else if (dir != null && dir.isFile) {
            dir.delete()
        } else {
            false
        }
    }


}