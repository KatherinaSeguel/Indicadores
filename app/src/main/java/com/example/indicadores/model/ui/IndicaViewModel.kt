package com.example.indicadores.model.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.indicadores.Repository
import com.example.indicadores.model.local.DataBaseIndicador
import com.example.indicadores.model.local.MaestraEntity

class IndicaViewModel (application: Application) : AndroidViewModel(application) { //sólo se hereda de la clase ViewModel sin contexto porque no es ROOM(androidViewmodel)
//Linea de arriba se modifica cuando después creo el ROOM

    private val mRepository: Repository

    //variable referencial al repositorio
    init {
        //se instancia el repositorio
        val fruDao = DataBaseIndicador.getDataBase(application).getIndicadorDao()
        mRepository = Repository(fruDao)
        //indico el método que traerá el repository
        mRepository.getDataFromServer(mindica = String())
    }

    //primer fragmento
    fun exposeLiveDataFromServer(): LiveData<MaestraEntity> {
        return mRepository.mLiveData //devuelve un Listado de frutas observables

    }

    //no lo había hecho
//segundo fragmanto
    //Este elemento será observado por la vista cuando le pase el Id
   /* fun getOneIndicadorresByID(id: String): LiveData<MaestraEntity> {
        return mRepository.getDataFromServer(id)
    }*/
}
