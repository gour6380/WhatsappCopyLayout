package com.biti.whatsapplayout

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.support.annotation.ColorInt
import android.support.annotation.FloatRange
import android.support.v7.widget.RecyclerView
import android.util.TypedValue
import android.view.View

class SeparatorDecoration(context: Context, @ColorInt color: Int,
                          @FloatRange(from = 0.0, fromInclusive = false) heightDp: Float) : RecyclerView.ItemDecoration() {

    private val mPaint: Paint = Paint()

    init {
        mPaint.color = color
        val thickness = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                heightDp, context.resources.displayMetrics)
        mPaint.strokeWidth = thickness
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State?) {
        val params = view.layoutParams as RecyclerView.LayoutParams

        val position = params.viewAdapterPosition

        if (position < state!!.itemCount) {
            outRect.set(0, 0, 0, mPaint.strokeWidth.toInt())
        } else {
            outRect.setEmpty()
        }
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State?) {
        val offset = (mPaint.strokeWidth / 2).toInt()

        for (i in 0 until parent.childCount) {
            val view = parent.getChildAt(i)
            val params = view.layoutParams as RecyclerView.LayoutParams

            val position = params.viewAdapterPosition

            if (position < state!!.itemCount) {
                c.drawLine((view.left + 190).toFloat(), (view.bottom + offset).toFloat(), (view.right - 30).toFloat(), (view.bottom + offset).toFloat(), mPaint)
            }
        }
    }
}
