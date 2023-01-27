package com.example.orga

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class JocQuatreActivity : AppCompatActivity() {
    var gbdRest: GestorBDPartida = GestorBDPartida(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joc_quatre)

        val buttonSeguent = findViewById<Button>(R.id.siguiente)
        buttonSeguent.setOnClickListener{
            val infoPage = Intent(this@JocQuatreActivity , JocQuatreUnActivity::class.java)
            startActivity(infoPage);
        }
    }

    override fun onBackPressed() {
        gbdRest.createPantalla("4")
        gbdRest.getPanatalles()
        val main = Intent(this@JocQuatreActivity, MainActivity::class.java)
        startActivity(main);
    }
}