package com.novadev.eltiempomvvm.datos

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.novadev.eltiempomvvm.datos.network.response.TiempoActualResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

// Key generada al iniciar sesion en la API
const val API_KEY = "4db49a7daa1141378e2123355180912"

// HTTP: http://api.apixu.com/v1/current.json?key=4db49a7daa1141378e2123355180912&q=Madrid&Lang=es

interface ApixuWeatherApiService {

    // uso de Retrofit
    @GET("current.json")
        fun getTiempoActual(
        //q indica la query para la localizacion y lang el idioma
            @Query("q") location: String,
            @Query("lang") languageCode: String = "es"


    ): Deferred<TiempoActualResponse>


    companion object {
        // usa el api_key creado anteriormente y reemplanza el key que aparece en la url para cada llamada
        operator fun invoke(): ApixuWeatherApiService{
            val requestInterceptor = Interceptor {chain ->
                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("key", API_KEY)
                    .build()
                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()
                return@Interceptor chain.proceed(request)


            }
            // añade a cada peticion http todo lo generado anteriormente del api_key
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .build()

            // Usa retrofit para crear la base de la url junto con la api_key, convierte el json obtenido a Gson.
            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://api.apixu.com/v1/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ApixuWeatherApiService::class.java)

        }
    }
}