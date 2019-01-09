package com.himanshurawat.portfolio.pojo

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import androidx.recyclerview.widget.ItemTouchHelper.ACTION_STATE_SWIPE



 class SwipeController : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {

     private val swipeBack = false

     override fun onMove(
         recyclerView: RecyclerView,
         viewHolder: RecyclerView.ViewHolder,
         target: RecyclerView.ViewHolder
     ): Boolean {
         TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
     }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.

    }

     override fun convertToAbsoluteDirection(flags: Int, layoutDirection: Int): Int {
         if (swipeBack) {
//             swipeBack = false
             return 0
         }
         return super.convertToAbsoluteDirection(flags, layoutDirection)
     }

     override fun onChildDraw(
         c: Canvas,
         recyclerView: RecyclerView,
         viewHolder: RecyclerView.ViewHolder,
         dX: Float, dY: Float,
         actionState: Int, isCurrentlyActive: Boolean
     ) {

         if (actionState == ACTION_STATE_SWIPE) {
             setTouchListener(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
         }
         super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
     }

     @SuppressLint("ClickableViewAccessibility")
     private fun setTouchListener(
         c: Canvas,
         recyclerView: RecyclerView,
         viewHolder: RecyclerView.ViewHolder,
         dX: Float, dY: Float,
         actionState: Int, isCurrentlyActive: Boolean
     ) {

//         recyclerView.setOnTouchListener(object : View.OnTouchListener() {
//             override fun onTouch(v: View, event: MotionEvent): Boolean {
////                 swipeBack = event.action == MotionEvent.ACTION_CANCEL || event.action == MotionEvent.ACTION_UP
//                 return false
//             }
//         })
     }
}