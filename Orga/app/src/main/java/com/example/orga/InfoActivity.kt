package com.example.orga

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity

class InfoActivity : AppCompatActivity() {
    var gbdRest: GestorBDPartida = GestorBDPartida(this)

    @SuppressLint("SetTextI18n", "ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = ""

        setContentView(R.layout.activity_acierto)

        val idRonda = getIntent().getStringExtra("id_ronda");
        val numOpcions = getIntent().getStringExtra("total_opcions");

        val ronda = idRonda?.let { gbdRest.getRonda(it) }
        val fallos = ronda?.getColumnIndex("fallos")?.let { ronda.getInt(it) }

        val puntuacio = findViewById<TextView>(R.id.puntuacio)
        var totalPuntuacio : Int = numOpcions!!.toInt() -  fallos!!.toInt()
        var percentatge =  ronda?.getColumnIndex("porcentageFallos")?.let { ronda.getInt(it) }?.toInt()

        if (percentatge != null) {

            if(percentatge < 0){
                percentatge = percentatge*-1
            }

            if(percentatge >= 80 && percentatge <= 100 ){
                findViewById<ImageView>(R.id.estrella1).setColorFilter(getColor(R.color.yellow))
                findViewById<ImageView>(R.id.estrella2).setColorFilter(getColor(R.color.yellow))
                findViewById<ImageView>(R.id.estrella3).setColorFilter(getColor(R.color.yellow))
            }else if(percentatge > 35 && percentatge < 80 ){
                findViewById<ImageView>(R.id.estrella1).setColorFilter(getColor(R.color.yellow))
                findViewById<ImageView>(R.id.estrella2).setColorFilter(getColor(R.color.yellow))
            }else if(percentatge > 0 && percentatge <= 35 ){
                findViewById<ImageView>(R.id.estrella1).setColorFilter(getColor(R.color.yellow))
            }
        }

        if(fallos!!.toInt() > numOpcions!!.toInt()){
            totalPuntuacio = 0
        }
        puntuacio.setText(puntuacio.getText().toString() + totalPuntuacio + " de " + numOpcions)

        val buttonSeguent = findViewById<Button>(R.id.siguienteAcierto)


        buttonSeguent.setOnClickListener {
            val a = 0
            val infoPage: Intent
            if(idRonda == "1"){
                infoPage = Intent(this@InfoActivity , JocDosActivity::class.java)
            }else if(idRonda == "3"){
                infoPage = Intent(this@InfoActivity , JocQuatreActivity::class.java)
            }else if(idRonda == "4"){
                infoPage = Intent(this@InfoActivity , JocCincActivity::class.java)
            }else if(idRonda == "5") {
                infoPage = Intent(this@InfoActivity, JocSisActivity::class.java)
            }else if(idRonda == "6") {
                infoPage = Intent(this@InfoActivity, JocSetActivity::class.java)
            }else if(idRonda == "7") {
                infoPage = Intent(this@InfoActivity, JocVuitActivity::class.java)
            }else if(idRonda == "8"){
                infoPage = Intent(this@InfoActivity , JocDeuActivity::class.java)
            }else if(idRonda == "2"){
                infoPage = Intent(this@InfoActivity , FinalActivitu::class.java)
            }else{
                infoPage = Intent(this@InfoActivity , MainActivity::class.java)

            }

            startActivity(infoPage);

        }

    }


}






