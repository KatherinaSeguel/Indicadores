package com.example.indicadores

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.indicadores.model.local.Dao.DaoIndicadores
import com.example.indicadores.model.local.MaestraEntity
import com.example.indicadores.model.pojo.Indicadores
import com.example.indicadores.model.remoto.RetrofitClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Repository (private val indicaDao: DaoIndicadores) {
    private val service = RetrofitClient.getRetrofitClient()
    val mLiveData = indicaDao.getOneIndicadorByID(mid = Int)
    val mLiveDataPri=indicaDao.getAllIndicadores()

    //La vieja confiable
    fun getDataFromServer(mindica:String) {
        val call = service.fetchAllIndicadores()
        call.enqueue(object : Callback<Indicadores> {


            override fun onFailure(call: Call<Indicadores>, t: Throwable) {
                Log.e("Repository",t.message.toString())

            }

            override fun onResponse(call: Call<Indicadores>, response: Response<Indicadores>)
            {
                when(response.code()){
                    //***se cambia***  in 200..299 -> mLiveData.postValue(response.body())
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        response.body()?.let {

                            Log.d("Info",it.toString())
                            indicaDao.insertAllIndicador(converter(listOf(it)))

                        }
                    }
                    in 300..399 -> Log.d("ERROR 300",response.errorBody().toString())
                    in 400..499 -> Log.d("ERROR 400",response.errorBody().toString())
                }
            }


        }) //llamadas asincronas

    }

    // En este metodo paso de datos o objeto  ,, varieble listadoDeRazas= listadoDeFrutas
    //se hace este función si lo que trae la database es distinto a lo que yo quiero en el ROOM
    //Aquí lo transformo.
    fun converter(list: List<Indicadores>):List<MaestraEntity>{

        var listadoDeFrutas = mutableListOf<MaestraEntity>()
        list.map {
            listadoDeFrutas.add(MaestraEntity(
                    id =0,
                    autor = it.autor,
                    bitcoin = it.bitcoin.nombre,
                    dolar = it.dolar.nombre,
                    dolarIntercambio = it.dolarIntercambio.nombre,
                    euro = it.euro.nombre,
                    fecha = it.fecha,
                    imacec = it.imacec.nombre,
                    ipc = it.ipc.nombre,
                    ivp = it.ivp.nombre,
                    libraCobre = it.libraCobre.nombre,
                    tasaDesempleo = it.tasaDesempleo.nombre,
                    tpm = it.tpm.nombre,
                    uf = it.uf.nombre,
                    utm = it.utm.nombre,
                    version = it.version))
        }
        return listadoDeFrutas
    }
    //esto tampoco lo había hecho
    //segundo fragmanto
    //Este elemento será observado por la vista cuando le pase el Id
   /* fun getOneIndicaByID(id:Int): LiveData<MaestraEntity> {
        return  indicaDao.getOneIndicadorByID(id)

    }*/

}