package com.example.indicadores.model.remoto

import com.example.indicadores.model.pojo.Indicadores
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface IndicadoresApi {

    //Vieja confiable
    @GET("api/")
    fun fetchAllIndicadores(): Call<Indicadores>

    //Coroutines
    @GET("api/")
    suspend fun fetchAllIndicadoresWithCoroutines(): Response<Indicadores>



    @GET("/api/{tipo_indicador}")
    suspend fun fetchPorTipoCorutinas(): Response<Indicadores>

    @GET("/api/{tipo_indicador}")
    fun fetchPorTipoList(TipoIndicador: String): Call<Indicadores>
    abstract fun getDataFromApi(): Any


}