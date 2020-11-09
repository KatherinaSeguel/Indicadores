package com.example.indicadores.model.local.Dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.indicadores.model.local.EntityIndicadores
import com.example.indicadores.model.pojo.Indicadores

@Dao
interface DaoIndicadores {
    //inserta todos datos
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllIndicadores(listaIndica: List<EntityIndicadores>)

//Selecciona todos los datos

    @Query("SELECT * FROM Indicadores_table")
    fun getAllIndicadores(): LiveData<List<EntityIndicadores>>

    //Selecciona u objeto en específico
//va al DAO y trae el objeto encontrado por ID envuelto en LiveData
    @Query("SELECT * FROM Indicadores_table WHERE autor=:mid")//los : es para que sepa que es la variable
    fun getOneIndicadorByID(mid:String): LiveData<EntityIndicadores> //yo le paso un id y la query me trae el Tfruto u objeto que encuentre


    //elimina toda la tabla
    @Query("Delete FROM Indicadores_table")
    suspend fun deleteALLIndicadores()



}