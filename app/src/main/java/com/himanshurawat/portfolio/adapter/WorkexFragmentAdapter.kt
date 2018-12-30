package com.himanshurawat.portfolio.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.himanshurawat.portfolio.R
import com.himanshurawat.portfolio.pojo.Education

class WorkexFragmentAdapter(private val context: Context,private val list: MutableList<Education> )
    : RecyclerView.Adapter<WorkexFragmentAdapter.WorkexViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkexViewHolder {
        return WorkexViewHolder(LayoutInflater.from(context).inflate(R.layout.education_recycler_view_item,parent,false))
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: WorkexViewHolder, position: Int) {
        val pos = holder.adapterPosition
        val item = list[pos]
        holder.qualificationTextView.text = "Qualification ${pos+1}"
    }


    class WorkexViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val schoolNameTextInputEditText: TextInputEditText = itemView.findViewById(R.id.education_recycler_view_item_school_text_input_edit_text)
        val gpaTextInputEditText: TextInputEditText = itemView.findViewById(R.id.education_recycler_view_item_gpa_text_input_edit_text)
        val yearOfCompletionTextInputEditText: TextInputEditText = itemView.findViewById(R.id.education_recycler_view_item_year_of_completion_text_input_edit_text)
        val majorTextInputEditText: TextInputEditText = itemView.findViewById(R.id.education_recycler_view_item_major_text_input_edit_text)
        val courseTextInputEditText: TextInputEditText = itemView.findViewById(R.id.education_recycler_view_item_course_text_input_edit_text)
        val qualificationTextView: TextView = itemView.findViewById(R.id.education_recycler_view_item_qualification_text_view)
    }

}