package com.example.orga

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class JocVuitActivity : AppCompatActivity() {
    var gbdRest: GestorBDPartida = GestorBDPartida(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joc_vuit)

        val buttonSeguent = findViewById<Button>(R.id.siguiente)
        buttonSeguent.setOnClickListener{
            val infoPage = Intent(this@JocVuitActivity , JocVuitUnActivity::class.java)
            startActivity(infoPage);
        }

        val butoInformacio = findViewById<Button>(R.id.infoJoc8)
        butoInformacio.setOnClickListener {
            val infoPage = Intent(this@JocVuitActivity, InformacioJocActivity::class.java)
            infoPage.putExtra("id_informacio", "6")
            startActivity(infoPage);
        }

    }

    override fun onBackPressed() {
        gbdRest.createPantalla("8")
        gbdRest.getPanatalles()
        val main = Intent(this@JocVuitActivity, MainActivity::class.java)
        startActivity(main);
    }
}