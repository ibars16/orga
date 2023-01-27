package com.example.orga

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipDescription
import android.content.Intent
import android.graphics.Canvas
import android.graphics.Point
import android.os.Build
import android.os.Bundle
import android.view.DragEvent
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class
MainActivity : AppCompatActivity() {

    var gbdRest: GestorBDPartida = GestorBDPartida(this)

    @SuppressLint("ClickableViewAccessibility", "Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


        val buttonInfo = findViewById<Button>(R.id.butonInformacioMenu)
        val buttonJoc = findViewById<Button>(R.id.butonJocMenu)
        val buttonPuntuacio = findViewById<Button>(R.id.butonPuntuacionsMenu)

        val ultimaPantalla = gbdRest.getPantallaActivate()


        buttonJoc.setOnClickListener {
            val ultimaPantalla = gbdRest.getPantallaActivate()

            if (ultimaPantalla != null) {
                val idUltimaPantalla =
                    (ultimaPantalla.getString(ultimaPantalla.getColumnIndex("id_pantalla"))).toString()
                gbdRest.getPanatalles()
                var jocPage: Intent
                if (idUltimaPantalla == "1") {
                    jocPage = Intent(this@MainActivity, JocUnActivity::class.java)
                } else if (idUltimaPantalla == "2") {
                    jocPage = Intent(this@MainActivity, JocDosActivity::class.java)
                } else if (idUltimaPantalla == "3") {
                    jocPage = Intent(this@MainActivity, JocTresActivity::class.java)
                } else if (idUltimaPantalla == "4") {
                    jocPage = Intent(this@MainActivity, JocQuatreActivity::class.java)
                } else if (idUltimaPantalla == "4.1") {
                    jocPage = Intent(this@MainActivity, JocQuatreUnActivity::class.java)
                } else if (idUltimaPantalla == "5") {
                    jocPage = Intent(this@MainActivity, JocCincActivity::class.java)
                } else if (idUltimaPantalla == "5.1") {
                    jocPage = Intent(this@MainActivity, JocCincUnActivity::class.java)
                } else if (idUltimaPantalla == "6") {
                    jocPage = Intent(this@MainActivity, JocSisActivity::class.java)
                } else if (idUltimaPantalla == "7") {
                    jocPage = Intent(this@MainActivity, JocSetUnActivity::class.java)
                } else if (idUltimaPantalla == "7.1") {
                    jocPage = Intent(this@MainActivity, JocSetUnActivity::class.java)
                } else if (idUltimaPantalla == "8") {
                    jocPage = Intent(this@MainActivity, JocVuitActivity::class.java)
                } else if (idUltimaPantalla == "8.1") {
                    jocPage = Intent(this@MainActivity, JocVuitUnActivity::class.java)
                } else if (idUltimaPantalla == "10") {
                    jocPage = Intent(this@MainActivity, JocDeuActivity::class.java)
                } else {
                    jocPage = Intent(this@MainActivity, FinalActivitu::class.java)
                }
                startActivity(jocPage);
            }else{
                val jocPage = Intent(this@MainActivity, JocUnActivity::class.java)
                startActivity(jocPage);
            }
        }


        buttonInfo.setOnClickListener {
            val a = 0
            val infoPage = Intent(this@MainActivity, InformacioActivit::class.java)
            startActivity(infoPage);
        }


        buttonInfo.setOnClickListener {
            val a = 0
            val infoPage = Intent(this@MainActivity, InformacioActivit::class.java)
            startActivity(infoPage);
        }

        buttonPuntuacio.setOnClickListener {
            val jocPage = Intent(this@MainActivity, PuntuacioActivity::class.java)
            startActivity(jocPage);
        }


        // seleccionar imatges


//        val mutableMap = mapOf(
//            "1" to mapOf(
//                "horizontal" to arrayOf(0,119),
//                "vertical" to arrayOf(0,418),
//            ),
//            "2" to mapOf(
//                "horizontal" to arrayOf(119,238),
//                "vertical" to arrayOf(0,418),
//            ),
//            "3" to mapOf(
//                "horizontal" to arrayOf(0,119),
//                "vertical" to arrayOf(418,836),
//            ),
//            "4" to mapOf(
//                "horizontal" to arrayOf(119,238),
//                "vertical" to arrayOf(418,836),
//            ),
//            "5" to mapOf(
//                "horizontal" to arrayOf(0,119),
//                "vertical" to arrayOf(836,1256),
//            ),
//            "6" to mapOf(
//                "horizontal" to arrayOf(119,238),
//                "vertical" to arrayOf(836,1256),
//            )
//        )


    }


}