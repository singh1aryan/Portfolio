package com.himanshurawat.portfolio.adapter

import android.content.Context
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.himanshurawat.portfolio.R
import com.himanshurawat.portfolio.pojo.Education

class EducationFragmentAdapter(private val context: Context,private val list: MutableList<Education> ): RecyclerView.Adapter<EducationFragmentAdapter.EducationViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        return EducationViewHolder(LayoutInflater.from(context).inflate(R.layout.education_recycler_view_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        val pos = holder.adapterPosition
        val item = list[pos]
        holder.qualificationTextView.text = "Qualification ${pos+1}"

        holder.schoolNameTextInputEditText.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s != null) {
                    list[pos].school = s.toString()
                }
            }

        })

        holder.gpaTextInputEditText.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s != null) {
                    list[pos].gpa = s.toString()
                }
            }

        })

        holder.yearOfCompletionTextInputEditText.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s != null && s.isNotEmpty()) {
                    list[pos].yearOfCompletion = s.toString()
                }
            }
        })

        holder.courseTextInputEditText.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s != null && s.isNotEmpty()) {
                    list[pos].course = s.toString()
                }
            }
        })

        holder.majorTextInputEditText.addTextChangedListener(object: TextWatcher{
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(s != null && s.isNotEmpty()) {
                    list[pos].major = s.toString()
                }
            }
        })


    }


    class EducationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val schoolNameTextInputEditText: TextInputEditText = itemView.findViewById(R.id.education_recycler_view_item_school_text_input_edit_text)
        val gpaTextInputEditText: TextInputEditText = itemView.findViewById(R.id.education_recycler_view_item_gpa_text_input_edit_text)
        val yearOfCompletionTextInputEditText: TextInputEditText = itemView.findViewById(R.id.education_recycler_view_item_year_of_completion_text_input_edit_text)
        val majorTextInputEditText: TextInputEditText = itemView.findViewById(R.id.education_recycler_view_item_major_text_input_edit_text)
        val courseTextInputEditText: TextInputEditText = itemView.findViewById(R.id.education_recycler_view_item_course_text_input_edit_text)
        val qualificationTextView: TextView = itemView.findViewById(R.id.education_recycler_view_item_qualification_text_view)
    }

}