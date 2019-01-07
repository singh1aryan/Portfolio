package com.himanshurawat.portfolio.ui.Skills

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.himanshurawat.portfolio.R

class SkillsFragment: Fragment() {
    // add the coursework
    // multi select drop down - courses

    private lateinit var addButton: MaterialButton
    private lateinit var courseTextInputEditText: TextInputEditText
    private lateinit var coursesTextLayout: TextInputLayout

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_education,container,false)

        setup(view)

        addButton.setOnClickListener{
            addCourse()
        }
        return view
    }

    private fun setup(view: View){
        //addButton = view.findViewById(R.id.fragment_course_work_add_course_button)
        //courseTextInputEditText = view.findViewById(R.id.fragment_course_work_course_name_text_input_edit_text)
        // coursesTextLayout = view.findViewById(R.id.fragment_course_work_courses_text_input_layout)
    }

    private fun addCourse(){
        // chips - for skills
        var course = courseTextInputEditText.text.toString()
        // maka a text view, boxes layout
    }
}