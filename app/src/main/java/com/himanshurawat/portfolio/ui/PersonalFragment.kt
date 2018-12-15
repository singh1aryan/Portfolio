package com.himanshurawat.portfolio.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.SeekBar
import com.himanshurawat.portfolio.R

class PersonalFragment : androidx.fragment.app.Fragment() {

    private lateinit var seekBar: SeekBar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_personal,container,false)


//        progress = 20
//        setOnTouchListener(this)

        return view
    }
}