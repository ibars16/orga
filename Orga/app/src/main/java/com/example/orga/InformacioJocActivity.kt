package com.example.orga

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController

class InformacioJocActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = ""

        setContentView(R.layout.activity_informacio_joc)

        val descripcio = findViewById<TextView>(R.id.textJocComplet)
        val id_informacio = getIntent().getStringExtra("id_informacio")?.toInt()

        descripcio.setText(Constantes.INFORMACIO_QR[id_informacio!!])

        val tancar = findViewById<Button>(R.id.tancaInfoJoc)
        tancar.setOnClickListener {
            this.finish()
        }

    }


}