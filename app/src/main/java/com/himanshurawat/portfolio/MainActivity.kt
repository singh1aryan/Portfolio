package com.himanshurawat.portfolio

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.fragment.app.FragmentManager
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import android.view.MotionEvent
import android.view.View
import android.widget.FrameLayout
import com.himanshurawat.portfolio.ui.PersonalFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnTouchListener {

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        if(v != null && v.id == activity_main_seekbar.id){
            return true
        }
        return false
    }

    private lateinit var frameLayoutContainer: FrameLayout
    private lateinit var fragmentManager: androidx.fragment.app.FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fragmentManager = supportFragmentManager
        activity_main_seekbar.progress = 20
        activity_main_seekbar.setOnTouchListener(this)
        setup()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun setup(){
        fragmentManager.beginTransaction().
                replace(R.id.content_main_frame_layout_container,PersonalFragment(),"PersonalFragment").
                commit()
    }
}
