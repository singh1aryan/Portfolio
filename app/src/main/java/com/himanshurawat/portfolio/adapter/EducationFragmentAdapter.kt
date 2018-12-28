//package com.himanshurawat.portfolio.adapter
//
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.textfield.TextInputEditText
import com.himanshurawat.portfolio.R
import com.himanshurawat.portfolio.adapterjava.Educ
import kotlinx.android.synthetic.main.educ_recycler_layout.view.*

//class EducationFragmentAdapter(private val context: Context, private val itemList):

class EducationFragmentAdapter(val items : ArrayList<Educ>, val context: Context)
        : RecyclerView.Adapter<EducationFragmentAdapter.ViewHolder>() {
//    RecyclerView.Adapter<EducationFragmentAdapter.EducationFragmentViewHolder>() {

    private lateinit var firstNameTextInputEditText: TextInputEditText
    private val mItems: List<Educ>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(layoutInflater.inflate(R.layout.educ_recycler_layout, parent, false))
    }

    override fun getItemCount(): Int {
        if (mItems != null) {
            return mItems.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val school_name = itemView.school_edittext
        val gpa = itemView.gpa_edittext
        val year = itemView.year_edittext
        val major = itemView.major_edittext
        val course_work = itemView.course_edittext

    }
}