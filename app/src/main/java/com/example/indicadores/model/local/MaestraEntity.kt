package com.example.indicadores.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull


@Entity(tableName = "maestra_table")
class MaestraEntity(
        @PrimaryKey (autoGenerate = true) @NotNull val id: Int,
        val autor: String,
        val bitcoin: String,
        val dolar: String,
        val dolarIntercambio: String,
        val euro: String,
        val fecha: String,
        val imacec: String,
        val ipc: String,
        val ivp: String,
        val libraCobre: String,
        val tasaDesempleo: String,
        val tpm: String,
        val uf: String,
        val utm: String,
        val version: String
)