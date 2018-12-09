package com.novadev.eltiempomvvm.datos.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.novadev.eltiempomvvm.datos.db.entity.CURRENT_WEATHER_ID
import com.novadev.eltiempomvvm.datos.db.entity.TiempoActualEntrada
import com.novadev.eltiempomvvm.datos.db.unitlocalized.ImperialCurrentWeatherEntry
import com.novadev.eltiempomvvm.datos.db.unitlocalized.MetricCurrentWeatherEntry
import java.util.*

@Dao
interface TiempoActualDao {
    // Va a existir conflicto porque el id que se creó es comun para todos ya que no necesitamos un id para cada response.
    // Por ello cada vez que haya un conflicto se reemplazará
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(tiempoActual: TiempoActualEntrada)

    //Queries que devuelven todos los datos mapeados tanto de Metric como de Imperial
    // Se usa LiveData para poder actualizar esos datos y si cambian de valor que se actualicen
    @Query("select * from tiempo_actual where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @Query("select * from tiempo_actual where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}