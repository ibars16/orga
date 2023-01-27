package com.example.orga

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

const val RESPUESTA_SIS_CORRECTA_ID = "Està suspès en una balconada"
const val RONDA_NUMERO_SIS = "6"
const val NUM_OPCIONS_JOC_SIS = 2

class JocSisActivity  : AppCompatActivity() {
    var gbdRest: GestorBDPartida = GestorBDPartida(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joc_sissss)

        gbdRest.createRonda(RONDA_NUMERO_SIS, NUM_OPCIONS_JOC_SIS)

        val fallos: TextView =  findViewById<TextView>(R.id.fallosJoc6)
        var numFallos = 0
        val radioGroup = findViewById<RadioGroup>(R.id.radioJoc9)

        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            val checkedRadioButton = group.findViewById<View>(checkedId) as RadioButton

            if(checkedRadioButton.text == RESPUESTA_SIS_CORRECTA_ID){
                gbdRest.updateRonda(RONDA_NUMERO_SIS, true, NUM_OPCIONS_JOC_SIS, "test2")
                val infoPage = Intent(this@JocSisActivity, InfoActivity::class.java)
                infoPage.putExtra("id_ronda", RONDA_NUMERO_SIS)
                infoPage.putExtra("total_opcions", NUM_OPCIONS_JOC_SIS.toString())
                startActivity(infoPage);
            }else{
                numFallos++
                fallos?.setText("Fallos: ".plus(numFallos.toString()))
                gbdRest.updateRonda(RONDA_NUMERO_SIS, false, NUM_OPCIONS_JOC_SIS)
            }


        })


        val butoInformacio = findViewById<Button>(R.id.infoJoc6)
        butoInformacio.setOnClickListener {
            val infoPage = Intent(this@JocSisActivity, InformacioJocActivity::class.java)
            infoPage.putExtra("id_informacio", "2")
            startActivity(infoPage);
        }

    }

    override fun onBackPressed() {
        gbdRest.createPantalla("6")
        gbdRest.getPanatalles()
        val main = Intent(this@JocSisActivity, MainActivity::class.java)
        startActivity(main);
    }
}