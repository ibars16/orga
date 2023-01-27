package com.example.orga

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class JocCincActivity : AppCompatActivity() {
    var gbdRest: GestorBDPartida = GestorBDPartida(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joc_cinc)

        val buttonSeguent = findViewById<Button>(R.id.siguiente)
        buttonSeguent.setOnClickListener{
            val infoPage = Intent(this@JocCincActivity , JocCincUnActivity::class.java)
            startActivity(infoPage);
        }

        val butoInformacio = findViewById<Button>(R.id.infoJoc5)
        butoInformacio.setOnClickListener {
            val infoPage = Intent(this@JocCincActivity, InformacioJocActivity::class.java)
            infoPage.putExtra("id_informacio", "4")
            startActivity(infoPage);
        }

    }

    override fun onBackPressed() {
        gbdRest.createPantalla("5")
        gbdRest.getPanatalles()
        val main = Intent(this@JocCincActivity, MainActivity::class.java)
        startActivity(main);
    }
}