package com.novadev.eltiempomvvm.datos.network.response

import com.google.gson.annotations.SerializedName
import com.novadev.eltiempomvvm.datos.db.entity.Location
import com.novadev.eltiempomvvm.datos.db.entity.TiempoActualEntrada

data class TiempoActualResponse(
    val location: Location,

    // se usa serializedName para indicar que el nombre de la raiz del JSON es current
    @SerializedName("current")
    val tiempoActualEntrada: TiempoActualEntrada
)