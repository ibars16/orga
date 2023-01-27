package com.example.orga

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

const val RESPUESTA_QUATRE_CORRECTA_ID = "Els castells i el campanar"
const val RONDA_NUMERO_QUATRE = "4"
const val NUM_OPCIONS_JOC_QUATRE = 3


class JocQuatreUnActivity : AppCompatActivity() {
    var gbdRest: GestorBDPartida = GestorBDPartida(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joc_cuatre_un)

        gbdRest.createRonda(RONDA_NUMERO_QUATRE, NUM_OPCIONS_JOC_QUATRE)
        val fallos: TextView =  findViewById<TextView>(R.id.fallosJoc4)
        var numFallos = 0
        val radioGroup = findViewById<RadioGroup>(R.id.radioJoc4)
        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
            val checkedRadioButton = group.findViewById<View>(checkedId) as RadioButton
            if(checkedRadioButton.text == RESPUESTA_QUATRE_CORRECTA_ID){
                gbdRest.updateRonda(RONDA_NUMERO_QUATRE, true, NUM_OPCIONS_JOC_QUATRE, "test")
                val infoPage = Intent(this@JocQuatreUnActivity, InfoActivity::class.java)
                infoPage.putExtra("id_ronda", RONDA_NUMERO_QUATRE)
                infoPage.putExtra("total_opcions", NUM_OPCIONS_JOC_QUATRE.toString())
                startActivity(infoPage);
            }else{
                numFallos++
                fallos?.setText("Fallos: ".plus(numFallos.toString()))
                gbdRest.updateRonda(RONDA_NUMERO_QUATRE, false, NUM_OPCIONS_JOC_QUATRE)
            }
        })

        val butoInformacio = findViewById<Button>(R.id.infoJoc4)
        butoInformacio.setOnClickListener {
            val infoPage = Intent(this@JocQuatreUnActivity, InformacioJocActivity::class.java)
            infoPage.putExtra("id_informacio", "3")
            startActivity(infoPage);
        }
    }

    override fun onBackPressed() {
        gbdRest.createPantalla("4.1")
        gbdRest.getPanatalles()
        val main = Intent(this@JocQuatreUnActivity, MainActivity::class.java)
        startActivity(main);
    }
}