package com.example.orga

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


const val RESPUESTA_VUIT_CORRECTA_ID = "L’orguener construeix i l’organista toca"
const val RONDA_NUMERO_VUIT = "8"
const val NUM_OPCIONS_JOC_VUIT = 4

class JocVuitUnActivity : AppCompatActivity() {
    var gbdRest: GestorBDPartida = GestorBDPartida(this)



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joc_vuit_un)

        gbdRest.createRonda(RONDA_NUMERO_VUIT,NUM_OPCIONS_JOC_VUIT)
        val fallos: TextView =  findViewById<TextView>(R.id.fallosJoc7)
        var numFallos = 0
        val radioGroup = findViewById<RadioGroup>(R.id.radioJoc8)

        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            val checkedRadioButton = group.findViewById<View>(checkedId) as RadioButton

            if(checkedRadioButton.text == RESPUESTA_VUIT_CORRECTA_ID){
                gbdRest.updateRonda(RONDA_NUMERO_VUIT, true, NUM_OPCIONS_JOC_VUIT, "drag")
                val infoPage = Intent(this@JocVuitUnActivity, InfoActivity::class.java)
                infoPage.putExtra("id_ronda", RONDA_NUMERO_VUIT)
                infoPage.putExtra("total_opcions", NUM_OPCIONS_JOC_VUIT.toString())
                startActivity(infoPage);
            }else{
                numFallos++
                fallos?.setText("Fallos: ".plus(numFallos.toString()))
                gbdRest.updateRonda(RONDA_NUMERO_VUIT, false, NUM_OPCIONS_JOC_VUIT)
            }


        })



    }

    override fun onBackPressed() {
        gbdRest.createPantalla("8.1")
        gbdRest.getPanatalles()
        val main = Intent(this@JocVuitUnActivity, MainActivity::class.java)
        startActivity(main);
    }
}