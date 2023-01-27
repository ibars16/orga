package com.example.orga

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


const val CUANDRANT_CORRECTE_RONDA_UN = "4"
const val RONDA_NUMERO_UN = "1"
const val NUM_OPCIONS_JOC_UN = 6


class JocUnActivity : AppCompatActivity() {
    var gbdRest: GestorBDPartida = GestorBDPartida(this)

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joc_inici)

        gbdRest.createRonda(RONDA_NUMERO_UN, NUM_OPCIONS_JOC_UN)

        val imageGame: ImageView = findViewById<ImageView>(R.id.imagen2Joc1)
        val fallos: TextView =  findViewById<TextView>(R.id.fallosJoc1)
        val marcarImatge = MarcarImatgeService(gbdRest, CUANDRANT_CORRECTE_RONDA_UN, RONDA_NUMERO_UN, fallos, NUM_OPCIONS_JOC_UN)


        imageGame.setOnTouchListener(object : View.OnTouchListener {
                override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                    marcarImatge.marcarImatge(imageGame, event, v)

                    if (marcarImatge.getOpcioCorrecte() == true) {
                        val seguentJoc = Intent(this@JocUnActivity, InfoActivity::class.java)
                        seguentJoc.putExtra("id_ronda", RONDA_NUMERO_UN)
                        seguentJoc.putExtra("total_opcions", NUM_OPCIONS_JOC_UN.toString())
                        startActivity(seguentJoc);
                    }

                    return true
                }
        })

        val butoInformacio = findViewById<Button>(R.id.infoJoc1)
        butoInformacio.setOnClickListener {
            val infoPage = Intent(this@JocUnActivity, InformacioJocActivity::class.java)
            infoPage.putExtra("id_informacio", "0")
            startActivity(infoPage);
        }




        }

    override fun onBackPressed() {
        gbdRest.createPantalla("1")
        gbdRest.getPanatalles()
        val main = Intent(this@JocUnActivity, MainActivity::class.java)
        startActivity(main);
    }

    }
