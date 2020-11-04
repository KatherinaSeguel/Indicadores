package com.example.indicadores.model.remoto

import com.example.indicadores.model.pojo.Indicadores
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface IndicadoresApi {

    //Vieja confiable
    @GET("/api")
    fun fetchAllIndicadores(): Call<List<Indicadores>>

    //Coroutines
    @GET("/api")
    suspend fun fetchAllIndicadoresWithCoroutines(): Response<List<Indicadores>>
}