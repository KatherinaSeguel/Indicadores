package com.example.indicadores.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.indicadores.model.pojo.*
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Indicadores_table")
class EntityIndicadores (
    @PrimaryKey     val autor: String,
                    val bitcoin: Bitcoin,
                    val dolar: Dolar,
                    val dolarIntercambio: DolarIntercambio,
                    val euro: Euro,
                    val fecha: String,
                    val imacec: Imacec,
                    val ipc: Ipc,
                    val ivp: Ivp,
                    val libraCobre: LibraCobre,
                    val tasaDesempleo: TasaDesempleo,
                    val tpm: Tpm,
                    val uf: Uf,
                    val utm: Utm,
                    val version: String
)
