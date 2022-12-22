package com.example.salonvender.Data_Class

data class Home_data(
    val `$most_popular`: List<MostPopular>,
    val `$near_by_shops`: List<NearByShop>,
    val banners: List<Banner>,
    val categories: List<Category>,
    val status: Boolean
)