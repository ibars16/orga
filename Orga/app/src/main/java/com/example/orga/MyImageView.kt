package com.example.orga

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.ImageView

@SuppressLint("ResourceAsColor")
class MyImageView(context: Context?, attrs: AttributeSet?) :
    androidx.appcompat.widget.AppCompatImageView(context!!, attrs) {
    private val currentPaint: Paint
    var drawRect = false
    var left = 0f
    var top = 0f
    var right = 0f
    var bottom = 0f

    init {
        currentPaint = Paint()
        currentPaint.isDither = true
        currentPaint.color = -0xff3400 // alpha.r.g.b
        currentPaint.style = Paint.Style.STROKE
        currentPaint.strokeJoin = Paint.Join.ROUND
        currentPaint.strokeCap = Paint.Cap.ROUND
        currentPaint.strokeWidth = 6f
        currentPaint.color = R.color.black
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (drawRect) {
            canvas.drawRect(left, top, right, bottom, currentPaint)
        }
    }
}