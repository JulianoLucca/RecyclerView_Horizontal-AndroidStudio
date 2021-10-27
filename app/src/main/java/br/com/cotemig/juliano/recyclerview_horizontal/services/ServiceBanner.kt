package br.com.cotemig.juliano.recyclerview_horizontal.services

import br.com.cotemig.juliano.recyclerview_horizontal.models.Banner
import retrofit2.Call
import retrofit2.http.GET


interface ServiceBanner {

    @GET("amigos")
    fun getBanners() : Call<List<Banner>>

}