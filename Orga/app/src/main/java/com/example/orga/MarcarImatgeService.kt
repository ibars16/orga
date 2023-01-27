package com.example.orga

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Rect
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat

class MarcarImatgeService {

    private var isMark: Boolean? = false
    private var cuadrantCorrecte: String? = null
    private var opcioCorrecte: Boolean? = false
    private var gbdRest: GestorBDPartida? = null
    private var numRonda: String? = null
    private var fallos: TextView? = null
    private var numFallos: Int = 0;
    private var numOpcions: Int = 0;


    constructor(gbdRest: GestorBDPartida, cuadrantCorrecte : String, numRonda: String, fallos: TextView, numOpcions: Int){
        this.gbdRest = gbdRest
        this.cuadrantCorrecte = cuadrantCorrecte
        this.numRonda = numRonda
        this.fallos = fallos
        this.numFallos = 0
        this.numOpcions = numOpcions
    }

    constructor(gbdRest: GestorBDPartida, cuadrantCorrecte : String, numRonda: String){
        this.gbdRest = gbdRest
        this.cuadrantCorrecte = cuadrantCorrecte
        this.numRonda = numRonda
        this.numFallos = 0
    }

    @SuppressLint("ClickableViewAccessibility")
    fun marcarImatge(imageGame: ImageView, event: MotionEvent?,v: View?): Boolean{
//                when (event?.action) {
//                    MotionEvent.ACTION_DOWN -> println()//Do Something
//                }
//                mAreas.add(Rect(0, 0, 325, 220))
//                mAreas.add(Rect(325, 0, 650, 220))
//                mAreas.add(Rect(0, 220, 325, 440))
//                mAreas.add(Rect(325, 220, 650, 440))
//                mAreas.add(Rect(0, 440, 325, 660))
//                mAreas.add(Rect(325, 440, 650, 660))
//                var viewCoords = IntArray(2)
//                imageGame.getLocationInWindow(viewCoords)
//                imageGame.getLocationOnScreen(viewCoords)

                val imagenTamano = Rect(0,0,0,0)
                imageGame.getLocalVisibleRect(imagenTamano)

                val cuadranUnX = (imagenTamano.right/2) + 5
                val cuadranUnY = imagenTamano.bottom/3
                val cuadranDosY = cuadranUnY * 2

                val mAreas: ArrayList<Rect> = ArrayList()
                mAreas.add(Rect(0, 0, cuadranUnX, cuadranUnY))
                mAreas.add(Rect(cuadranUnX, 0, imagenTamano.right+45, cuadranUnY))
                mAreas.add(Rect(0, cuadranUnY, cuadranUnX, cuadranDosY))
                mAreas.add(Rect(cuadranUnX, cuadranUnY, imagenTamano.right+45, cuadranDosY))
                mAreas.add(Rect(0, cuadranDosY, cuadranUnX,imagenTamano.bottom))
                mAreas.add(Rect(cuadranUnX, cuadranDosY, imagenTamano.right+45,imagenTamano.bottom))

                var coordenadasRectaElegida : Rect

                for (cRect in mAreas) {
                    if (cRect.contains(event!!.x.toInt(), event!!.y.toInt())) {
                        coordenadasRectaElegida = cRect
                        val drawView: MyImageView = v as MyImageView

                        var numeroRestarEjex = 100
                        var numeroRestarEjeY = 0

                        if(coordenadasRectaElegida.left == 0){
                            numeroRestarEjex = 0
                            numeroRestarEjeY = 64
                        }

                        drawView.top = coordenadasRectaElegida.top.toFloat() + 1
                        drawView.left = coordenadasRectaElegida.left.toFloat() + numeroRestarEjeY
                        drawView.right = coordenadasRectaElegida.right.toFloat() - numeroRestarEjex
                        drawView.bottom =  coordenadasRectaElegida.bottom.toFloat() - 1
                        drawView.invalidate()
                        drawView.drawRect = true

                        if (cRect.contains(event!!.x.toInt(), event!!.y.toInt()) && mAreas.indexOf(cRect) == getCuadrantCorrecte().toInt()) {
                            setOpcioCorrecte(true)
                        }

                        if(event.getAction() == MotionEvent.ACTION_DOWN){
                            if(getOpcioCorrecte() != true){
                                numFallos++
                                fallos?.setVisibility(View.VISIBLE)
                                numRonda?.let { getOpcioCorrecte()?.let { it1 ->
                                    getGbdRest().updateRonda(it,
                                        it1, numOpcions, "imagen")
                                } }
                                getGbdRest().getRondes()
                            }
                            fallos?.setText("Fallos: ".plus(numFallos.toString()))
                        }



                        setIsMark(true)
                    }
                }
                if(getOpcioCorrecte() == true){
                    numRonda?.let { getOpcioCorrecte()?.let { it1 ->
                        getGbdRest().updateRonda(it,
                            it1, numOpcions, "imagen")
                    } }



                }

                return true

    }

    fun getGbdRest(): GestorBDPartida{
        return this.gbdRest!!
    }

    fun setGbdRest(gbdRest:GestorBDPartida){
        this.gbdRest = gbdRest
    }

    fun getCuadrantCorrecte(): String{
        return this.cuadrantCorrecte!!
    }

    fun setCuadrantCorrecte(isMark:String){
        this.cuadrantCorrecte = cuadrantCorrecte
    }

    fun getIsMark(): Boolean?{
        return this.isMark
    }

    fun setIsMark(isMark:Boolean){
        this.isMark = isMark
    }

    fun getOpcioCorrecte(): Boolean?{
        return this.opcioCorrecte
    }

    fun setOpcioCorrecte(opcioCorrecte:Boolean){
        this.opcioCorrecte = opcioCorrecte
    }

}