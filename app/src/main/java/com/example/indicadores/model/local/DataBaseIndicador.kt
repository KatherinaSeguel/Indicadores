package com.example.indicadores.model.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.indicadores.model.local.Dao.DaoIndicadores

private const val DATA_BESE_NAME= "Indicadores_db"

@Database(entities=[MaestraEntity::class], version=1 )
abstract class DataBaseIndicador : RoomDatabase(){

    //Método para Dao
    abstract fun getIndicadorDao(): DaoIndicadores

    companion object {  //permite acceder a el sin necesidad de crear el objeto de la clase, nombre clase + punto y acceso a lo que está en el companen objet
        @Volatile
        private var INSTANCE: DataBaseIndicador? = null
        fun getDataBase(context: Context): DataBaseIndicador {

            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(context,
                        DataBaseIndicador::class.java,
                        DATA_BESE_NAME)
                        .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}