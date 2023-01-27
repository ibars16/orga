package com.example.orga

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

val INFORMACIO_ORGA_TITUL = mutableMapOf(
    0 to "L’EDIFICI",
)

val INFORMACIO_ORGA_DESCRIPCIO = mutableMapOf(
    0 to R.string.orgaEdifici,
)

val INFORMACIO_ORGA_IMATGE = mutableMapOf(
    0 to R.drawable.ic_launcher_background,
)

class InformacioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_informacio)

        var list: List<Informacio> = ArrayList()

        for ((key, info) in INFORMACIO_ORGA_TITUL){
            list += Informacio(INFORMACIO_ORGA_TITUL[key]!!, INFORMACIO_ORGA_DESCRIPCIO[key].toString(), INFORMACIO_ORGA_IMATGE[key])
        }



    }


}