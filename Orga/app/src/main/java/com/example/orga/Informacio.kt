package com.example.orga

import android.graphics.drawable.Icon

class Informacio {

    private var titul: String
        get() {
            return titul
        }
    private var descripcio: String
        get() {
            return descripcio
        }
    private var imatge: Int
        get() {
            return imatge
        }

    constructor(titul: String, descripcio: String, imatge: Int?) {
        this.titul = titul
        this.descripcio = descripcio
        this.imatge = imatge!!
    }

}