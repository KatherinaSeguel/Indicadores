package com.example.indicadores.model.remoto

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        private const val URL_BASE = "https://mindicador.cl"
        fun getRetrofitClient() : IndicadoresApi {
            val mRetrofit = Retrofit.Builder()
                    .baseUrl(URL_BASE)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            return mRetrofit.create(IndicadoresApi::class.java)
        }
    }

}