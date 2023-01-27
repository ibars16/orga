package com.example.orga

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity


const val RESPUESTA_DOS_CORRECTA_ID = "Més de 40"
const val RONDA_DOS_ID ="2"
const val NUM_OPCIONS_DOS = 3

class JocDosActivity : AppCompatActivity() {
    var gbdRest: GestorBDPartida = GestorBDPartida(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joc_dos)
        val buttonSeguent = findViewById<Button>(R.id.siguiente)
//        val radioGroup = findViewById<RadioGroup>(R.id.radioJoc2)
//
//        radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
//            val checkedRadioButton = group.findViewById<View>(checkedId) as RadioButton
//
//            var respostaCorrecte = false
//
//            if(checkedRadioButton.text == RESPUESTA_DOS_CORRECTA_ID){
//                respostaCorrecte = true
//            }
//
//          //  gbdRest.createRonda(RONDA_DOS_ID, respostaCorrecte)
//          //  gbdRest.getRondes()
//
//        })

        buttonSeguent.setOnClickListener{
            val infoPage = Intent(this@JocDosActivity , JocTresActivity::class.java)
            startActivity(infoPage);
        }
    }

    override fun onBackPressed() {
        gbdRest.createPantalla("2")
        gbdRest.getPanatalles()
        val main = Intent(this@JocDosActivity, MainActivity::class.java)
        startActivity(main);
    }
}