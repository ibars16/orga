package com.example.orga

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class JocSetActivity : AppCompatActivity() {
    var gbdRest: GestorBDPartida = GestorBDPartida(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joc_set)

        val buttonSeguent = findViewById<Button>(R.id.siguiente)
        buttonSeguent.setOnClickListener{
            val infoPage = Intent(this@JocSetActivity , JocSetUnActivity::class.java)
            startActivity(infoPage);
        }

        val butoInformacio = findViewById<Button>(R.id.infoJoc7)
        butoInformacio.setOnClickListener {
            val infoPage = Intent(this@JocSetActivity, InformacioJocActivity::class.java)
            infoPage.putExtra("id_informacio", "5")
            startActivity(infoPage);
        }

    }

    override fun onBackPressed() {
        gbdRest.createPantalla("7")
        gbdRest.getPanatalles()
        val main = Intent(this@JocSetActivity, MainActivity::class.java)
        startActivity(main);
    }
}