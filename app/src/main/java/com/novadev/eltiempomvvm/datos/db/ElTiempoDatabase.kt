package com.novadev.eltiempomvvm.datos.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.novadev.eltiempomvvm.datos.db.entity.TiempoActualEntrada

@Database(
    entities = [TiempoActualEntrada::class],
    version = 1
)

abstract class ElTiempoDatabase: RoomDatabase() {
    abstract fun tiempoActualDao(): TiempoActualDao

    companion object {
        @Volatile private var instance : ElTiempoDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it }
        }

        // crea la base de datos
        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext,
                ElTiempoDatabase::class.java, "elTiempo.db")
                .build()
        }

}