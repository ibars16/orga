package com.example.orga

class Pantalla {

    private var id: String
        get() {
            return id
        }
    private var esUltima: Int
        get() {
            return esUltima
        }

    constructor(id: String, esUltima: Int){
        this.id = id
        this.esUltima = esUltima
    }
}