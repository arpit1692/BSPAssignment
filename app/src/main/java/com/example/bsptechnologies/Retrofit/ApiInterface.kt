package com.c.kotlinmall.Retrofit
import com.example.bsptechnologies.Models.MainResults
import retrofit2.Call
import retrofit2.http.*

interface ApiInterface {

    @GET("demo_api")
    fun getResults(): Call<MainResults>
}
