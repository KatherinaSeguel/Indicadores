package com.example.indicadores.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "detalleIndicador_table")
class EntityIndicadores(
        @PrimaryKey  val codigo: String,
        val fecha: String,
        val nombre: String,
        val unidadMedida: String,
        val valor: Double
)
