package com.example.orga

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class JocDeuActivity : AppCompatActivity() {
        var gbdRest: GestorBDPartida = GestorBDPartida(this)

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_joc_nou)
            gbdRest.createRonda(RONDA_DOS_ID, NUM_OPCIONS_DOS)

            val radioGroup = findViewById<RadioGroup>(R.id.radioJoc2)
            val fallos: TextView =  findViewById<TextView>(R.id.fallosJoc10)
            var numFallos = 0

            radioGroup.setOnCheckedChangeListener(RadioGroup.OnCheckedChangeListener { group, checkedId ->
                val checkedRadioButton = group.findViewById<View>(checkedId) as RadioButton

                if(checkedRadioButton.text == RESPUESTA_DOS_CORRECTA_ID){
                    gbdRest.updateRonda(RONDA_DOS_ID, true, NUM_OPCIONS_DOS, "test")
                    val infoPage = Intent(this@JocDeuActivity, InfoActivity::class.java)
                    infoPage.putExtra("id_ronda", RONDA_DOS_ID)
                    infoPage.putExtra("total_opcions", NUM_OPCIONS_DOS.toString())
                    startActivity(infoPage);
                }else{
                    numFallos++
                    fallos?.setText("Fallos: ".plus(numFallos.toString()))
                    gbdRest.updateRonda(RONDA_DOS_ID, false, NUM_OPCIONS_DOS)
                }

            })


        }

        override fun onBackPressed() {
            gbdRest.createPantalla("10")
            gbdRest.getPanatalles()
            val main = Intent(this@JocDeuActivity, MainActivity::class.java)
            startActivity(main);
        }
}