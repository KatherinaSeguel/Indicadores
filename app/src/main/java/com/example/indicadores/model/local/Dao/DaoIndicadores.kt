package com.example.indicadores.model.local.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.indicadores.model.local.MaestraEntity

@Dao
interface DaoIndicadores {
    //inserta todos datos


    @Insert(onConflict = OnConflictStrategy.REPLACE )
  fun insertAllIndicador(mList: List<MaestraEntity>)





//Selecciona todos los datos

    @Query("SELECT * FROM maestra_table")
    fun getAllIndicadores(): LiveData<MaestraEntity>


    //Selecciona u objeto en específico
//va al DAO y trae el objeto encontrado por ID envuelto en LiveData
    @Query("SELECT * FROM maestra_table WHERE id=:mid")//los : es para que sepa que es la variable
    fun getOneIndicadorByID(mid: Int): LiveData<MaestraEntity> //yo le paso un id y la query me trae el Tfruto u objeto que encuentre


   /* //elimina toda la tabla
    @Query("Delete FROM maestra_table")
    suspend fun deleteALLIndicadores()*/



}