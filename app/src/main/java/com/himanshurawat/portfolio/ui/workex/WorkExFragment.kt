package com.himanshurawat.portfolio.ui.education

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.himanshurawat.portfolio.R
import com.himanshurawat.portfolio.adapter.EducationFragmentAdapter
import com.himanshurawat.portfolio.adapter.WorkexFragmentAdapter
import com.himanshurawat.portfolio.pojo.Education
import com.himanshurawat.portfolio.pojo.WorkEx
import com.himanshurawat.portfolio.ui.main.PortfolioMakerEventListener

class WorkExFragment: Fragment(), EducationFragmentContract.View, View.OnClickListener {
    override fun onClick(v: View?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        if(v != null){
            when(v.id){

                backButton.id ->{
                    listener.backButtonClicked("WorkExFragment")
                }

                nextButton.id ->{
                    listener.nextQuestionButtonClicked("WorkExFragment")
                }
            }
        }

    }

    private lateinit var workExList: MutableList<WorkEx>
    private lateinit var workExRecyclerView: RecyclerView
    private lateinit var workExAdapter: WorkexFragmentAdapter

    private lateinit var addWorkex: TextInputEditText
    private lateinit var backButton: MaterialButton
    private lateinit var nextButton: MaterialButton

    private lateinit var listener: PortfolioMakerEventListener

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try{
            this.listener = context as PortfolioMakerEventListener
        }catch (e: ClassCastException) {
            throw ClassCastException(context.toString() + " must implement PortfolioMakerEventListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_workex,container,false)

        setup(view)


        return view
    }

    private fun setup(view: View){
        //TextInputEditText
        //addEduc = view.findViewById(R.id.addEduc)
        backButton = view.findViewById(R.id.fragment_work_ex_go_back_material_button)
        nextButton = view.findViewById(R.id.fragment_work_ex_next_question_material_button)

        workExList = arrayListOf()
        workExList.add(WorkEx())

        workExAdapter = WorkexFragmentAdapter(context!!,workExList)
        workExRecyclerView = view.findViewById(R.id.fragment_work_ex_recycler_view)
        workExRecyclerView.adapter = workExAdapter
        workExRecyclerView.layoutManager = LinearLayoutManager(context!!,RecyclerView.VERTICAL,false)

    }

    fun addWorkex() {
        // add the list rv here
        workExList.add(WorkEx())

    }
}
