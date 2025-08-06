package com.ifpemoveis.weatherapp.api


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import com.ifpemoveis.weatherapp.BuildConfig

interface WeatherServiceAPI {
    companion object {
        const val BASE_URL = "https://api.weatherapi.com/v1/"
        val API_KEY = BuildConfig.WEATHER_API_KEY
    }

    // Procura a localização baseado no nome ou coordenadas
//    @GET("search.json?key=$API_KEY&lang=pt_br")
//    fun search(@Query("q") query: String): Call<List<APILocation>?>

    @GET("search.json")
    fun search(
        @Query("key") key: String = BuildConfig.WEATHER_API_KEY,
        @Query("lang") lang: String = "pt_br",
        @Query("q") query: String
    ): Call<List<APILocation>?>

}