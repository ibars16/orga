package com.example.orga

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MostrarInformacio: AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_informacio)

        val idInformacio = getIntent().getStringExtra("id")?.toInt()

        val titulo = findViewById<TextView>(R.id.tituloMostrarInformacio)
        val descripcio = findViewById<TextView>(R.id.descripcioMostrarInformacio)
        val imagen = findViewById<ImageView>(R.id.imageMostrarInformacio)

        titulo.setText(Constantes.INFORMACIO_ORGA_TITUL[idInformacio!!])
        descripcio.setText(Constantes.INFORMACIO_ORGA_DESCRIPCIO[idInformacio!!].toString())
        imagen.setImageResource(Constantes.INFORMACIO_ORGA_IMATGE[idInformacio!!])




    }
}