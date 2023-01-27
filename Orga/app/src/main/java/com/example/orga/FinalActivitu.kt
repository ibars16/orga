package com.example.orga

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class FinalActivitu : AppCompatActivity() {

    var gbdRest: GestorBDPartida = GestorBDPartida(this)

    @SuppressLint("ClickableViewAccessibility", "Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_final)

        var str = gbdRest.getPuntuacioFinal()
        val textPuntuacio = findViewById<TextView>(R.id.puntuacioFinal)
        val fallos = gbdRest.getFallos()
        textPuntuacio.setText(str)

        if(fallos >= 0 && fallos <= 10 ){
            findViewById<ImageView>(R.id.estrella1).setColorFilter(Color.YELLOW)
            findViewById<ImageView>(R.id.estrella2).setColorFilter(Color.YELLOW)
            findViewById<ImageView>(R.id.estrella3).setColorFilter(Color.YELLOW)
        }else if(fallos > 10 && fallos < 23 ){
            findViewById<ImageView>(R.id.estrella1).setColorFilter(Color.YELLOW)
            findViewById<ImageView>(R.id.estrella2).setColorFilter(Color.YELLOW)
        }else if(fallos > 23 && fallos <= 30 ){
            findViewById<ImageView>(R.id.estrella1).setColorFilter(Color.YELLOW)
        }

        val butonMenu = findViewById<Button>(R.id.tornar);

        butonMenu.setOnClickListener {
            val a = 0
            gbdRest.createPantalla("15")
            val infoPage = Intent(this@FinalActivitu, MainActivity::class.java)
            infoPage.putExtra("id_pantalla", "15")
            startActivity(infoPage);
        }


    }
}