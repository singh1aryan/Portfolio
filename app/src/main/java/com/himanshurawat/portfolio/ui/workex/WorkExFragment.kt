package com.himanshurawat.portfolio.ui.education

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.himanshurawat.portfolio.R
import com.himanshurawat.portfolio.adapter.WorkexFragmentAdapter
import com.himanshurawat.portfolio.pojo.WorkEx
import com.himanshurawat.portfolio.ui.main.PortfolioMakerEventListener

class WorkExFragment: Fragment(), EducationFragmentContract.View, View.OnClickListener {
    override fun onClick(v: View?) {

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

    private lateinit var addWorkex: MaterialButton
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
        addWorkex.setOnClickListener{
            addWorkex()
        }
        initSwipe()
        return view
    }

    private fun setup(view: View){
        //TextInputEditText
        addWorkex = view.findViewById(R.id.fragment_work_ex_add_material_button)
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
        workExList.add(WorkEx())
        workExAdapter.notifyDataSetChanged()
    }
    private fun initSwipe() {
        val simpleItemTouchCallback = object : ItemTouchHelper.SimpleCallback(
            0, ItemTouchHelper.LEFT
        ) {

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition

                if (direction == ItemTouchHelper.LEFT) {
                    workExList.removeAt(position)
                    workExAdapter.notifyDataSetChanged()
                }
            }

        }
        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(workExRecyclerView)
    }
}
