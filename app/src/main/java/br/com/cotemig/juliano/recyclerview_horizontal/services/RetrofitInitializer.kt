package br.com.cotemig.juliano.recyclerview_horizontal.services

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://mockup.fluo.app/v1/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun serviceBanner(): ServiceBanner {
        return retrofit.create(ServiceBanner::class.java)
    }

}