package com.example.indicadores.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "detalleIndicador_table")
class DetalleIndicador (
        @PrimaryKey  val codigo: String,
                     val fecha: String,
                     val nombre: String,
                     val unidadMedida: String,
                     val valor: Double
)