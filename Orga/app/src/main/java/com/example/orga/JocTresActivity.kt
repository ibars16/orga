package com.example.orga

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val CUANDRANT_CORRECTE_RONDA_DOS = "3"
const val RONDA_NUMERO_TRES = "3"
const val NUM_OPCIONS_JOC_DOS = 6


class JocTresActivity : AppCompatActivity() {
    var gbdRest: GestorBDPartida = GestorBDPartida(this)

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joc_tres)

        gbdRest.createRonda(RONDA_NUMERO_TRES, NUM_OPCIONS_JOC_DOS)

        val imageGame: ImageView = findViewById<ImageView>(R.id.imagen2Joc3)
        val fallos: TextView =  findViewById<TextView>(R.id.fallosJoc3)

        val marcarImatge = MarcarImatgeService(gbdRest, CUANDRANT_CORRECTE_RONDA_DOS, RONDA_NUMERO_TRES, fallos, NUM_OPCIONS_JOC_DOS)

        imageGame.setOnTouchListener(object : View.OnTouchListener {
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                marcarImatge.marcarImatge(imageGame, event, v)

                if (marcarImatge.getOpcioCorrecte() == true) {
                    val infoPage = Intent(this@JocTresActivity, InfoActivity::class.java)
                    infoPage.putExtra("id_ronda", RONDA_NUMERO_TRES)
                    infoPage.putExtra("total_opcions", NUM_OPCIONS_JOC_DOS.toString())
                    startActivity(infoPage);
                }

                return true
            }

        })


    }

    override fun onBackPressed() {
        gbdRest.createPantalla("3")
        gbdRest.getPanatalles()
        val main = Intent(this@JocTresActivity, MainActivity::class.java)
        startActivity(main);
    }
}