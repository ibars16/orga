package com.example.orga

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

const val RONDA_NUMERO_SET = "7"
const val NUM_OPCIONS_JOC_SET = 5

val PARAULES_CORRECTES = mapOf<Int, String>(
    0 to "Poms dels registres",
    1 to "Tubs",
    2 to "Manuals (teclats)",
    3 to "Pedaler",
    4 to "Pedal de l’expressiu")

class JocSetUnActivity : AppCompatActivity() {
    var gbdRest: GestorBDPartida = GestorBDPartida(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joc_set_un)

        gbdRest.createRonda(RONDA_NUMERO_SET, NUM_OPCIONS_JOC_SET)

        val barnilles = findViewById<TextView>(R.id.opcio1joc7)
        val caixa = findViewById<TextView>(R.id.opcio2joc7)
        val manuals = findViewById<TextView>(R.id.opcio3joc7)
        val manxes = findViewById<TextView>(R.id.opcio4joc7)
        val pedalExpresiu = findViewById<TextView>(R.id.opcio5joc7)
        val pedaler = findViewById<TextView>(R.id.opcio6joc7)
        val poms = findViewById<TextView>(R.id.opcio7joc7)
        val secret = findViewById<TextView>(R.id.opcio8joc7)
        val tubs = findViewById<TextView>(R.id.opcio9joc7)

        barnilles.setOnClickListener(clickListener)
        caixa.setOnClickListener(clickListener)
        manuals.setOnClickListener(clickListener)
        manxes.setOnClickListener(clickListener)
        pedalExpresiu.setOnClickListener(clickListener)
        pedaler.setOnClickListener(clickListener)
        poms.setOnClickListener(clickListener)
        secret.setOnClickListener(clickListener)
        tubs.setOnClickListener(clickListener)

        val resultados = arrayOf(barnilles, caixa, manuals, manxes, pedalExpresiu, pedaler, poms, secret, tubs)
        val buttonSeguent = findViewById<Button>(R.id.siguiente7)
        buttonSeguent.setOnClickListener{
            var totalResultats = 0

            val paraulesSeleccionades = mutableMapOf<String, Boolean>(
                "Poms dels registres" to false,
                "Tubs" to false,
                "Manuals (teclats)" to false,
                "Pedaler" to false,
                "Pedal de l’expressiu" to false)
            for (resultado in resultados){
                if(resultado.background != null){
                    totalResultats++
                    for((key,value) in PARAULES_CORRECTES){
                        if(value == resultado.text){
                            paraulesSeleccionades["$value"] = true
                            break
                        }
                    }
                }
            }

            if(totalResultats == 5){
                for((texto, resultadoFinal) in paraulesSeleccionades){
                    if(!resultadoFinal){
                        gbdRest.updateRonda(RONDA_NUMERO_SET, false, NUM_OPCIONS_JOC_SET)
                    }
                }

                gbdRest.updateRonda(RONDA_NUMERO_SET, true, NUM_OPCIONS_JOC_SET, "select")
                val infoPage = Intent(this@JocSetUnActivity, InfoActivity::class.java)
                infoPage.putExtra("id_ronda", RONDA_NUMERO_SET)
                infoPage.putExtra("total_opcions", NUM_OPCIONS_JOC_SET.toString())
                startActivity(infoPage);
            }else{
                val toast1 = Toast.makeText(
                    applicationContext,
                    "Has de seleccionar cinc opcions", Toast.LENGTH_SHORT
                )

                toast1.show()
            }


        }
    }

    @SuppressLint("ResourceAsColor")
    private val clickListener = View.OnClickListener { v ->
        var tag = v.tag
        if(tag != null && tag != ""){
            v.setBackgroundColor(0x00000000)
            v.setTag("")
        }else{
            v.setBackgroundColor(R.color.teal_200)
            v.setTag("Color")
        }
    }

    override fun onBackPressed() {
        gbdRest.createPantalla("7.1")
        gbdRest.getPanatalles()
        val main = Intent(this@JocSetUnActivity, MainActivity::class.java)
        startActivity(main);
    }
}