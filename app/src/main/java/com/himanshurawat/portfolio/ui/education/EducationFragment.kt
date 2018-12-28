package com.himanshurawat.portfolio.ui.education

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.himanshurawat.portfolio.R
import com.himanshurawat.portfolio.adapterjava.Educ

class EducationFragment: Fragment(), EducationFragmentContract.View {

    val education: ArrayList<Educ> = ArrayList()
    private lateinit var addEduc: TextInputEditText
    private lateinit var backButton: MaterialButton
    private lateinit var nextButton: MaterialButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_education,container,false)

        setup(view)
        addEduc.setOnClickListener{
            addEduc()
        }

        return view
    }

    private fun setup(view: View){
        //TextInputEditText
        addEduc = view.findViewById(R.id.addEduc)
        backButton = view.findViewById(R.id.backButton)
        nextButton = view.findViewById(R.id.nextButton)

    }

    fun addEduc() {
    // add the list rv here

    }
}