package com.example.orga

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class JocNouActivity : AppCompatActivity() {
    var gbdRest: GestorBDPartida = GestorBDPartida(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_joc_nou)



    }

    override fun onBackPressed() {
        gbdRest.createPantalla("7")
        gbdRest.getPanatalles()
        val main = Intent(this@JocNouActivity, MainActivity::class.java)
        startActivity(main);
    }
}