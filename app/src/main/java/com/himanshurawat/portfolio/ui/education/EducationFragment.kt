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
import com.himanshurawat.portfolio.adapter.EducationFragmentAdapter
import com.himanshurawat.portfolio.pojo.Education
import com.himanshurawat.portfolio.pojo.SwipeController
import com.himanshurawat.portfolio.ui.main.PortfolioMakerEventListener


class EducationFragment: Fragment(), EducationFragmentContract.View, View.OnClickListener {
    override fun onClick(v: View?) {
        if(v != null){
            when(v.id){

                backButton.id ->{
                    listener.backButtonClicked("EducationFragment")
                }

                nextQuestionButton.id ->{
                    listener.nextQuestionButtonClicked("EducationFragment")
                }
            }
        }
    }

    private lateinit var educationList: MutableList<Education>
    private lateinit var educationRecyclerView: RecyclerView
    private lateinit var educationAdapter: EducationFragmentAdapter
    private lateinit var backButton: MaterialButton
    private lateinit var nextQuestionButton: MaterialButton
    private lateinit var addEducation: MaterialButton

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
        val view = inflater.inflate(R.layout.fragment_education,container,false)

        setup(view)

        addEducation.setOnClickListener{
            addEduc()
        }
        initSwipe()
        return view
    }

    private fun setup(view: View){
        //TextInputEditText
        //addEduc = view.findViewById(R.id.addEduc)


//        var swipeController: SwipeController
//        val itemTouchhelper = ItemTouchHelper(swipeController)
//        itemTouchhelper.attachToRecyclerView(educationRecyclerView)

        backButton = view.findViewById(R.id.fragment_education_go_back_material_button)
        nextQuestionButton = view.findViewById(R.id.fragment_education_next_question_material_button)
        addEducation = view.findViewById(R.id.fragment_education_add_material_button)
        educationList = arrayListOf()

        educationList.add(Education())
        educationList.add(Education())

        educationAdapter = EducationFragmentAdapter(context!!,educationList)
        educationRecyclerView = view.findViewById(R.id.fragment_education_recycler_view)
        educationRecyclerView.adapter = educationAdapter

        educationRecyclerView.layoutManager = LinearLayoutManager(context!!,RecyclerView.VERTICAL,false)
        backButton.setOnClickListener(this)
        nextQuestionButton.setOnClickListener(this)

    }

    private fun addEduc(){
        educationList.add(Education())
        educationAdapter.notifyItemInserted(educationList.size - 1)
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
                    educationList.removeAt(position)
                    educationAdapter.notifyDataSetChanged()
                }
            }

        }
        val itemTouchHelper = ItemTouchHelper(simpleItemTouchCallback)
        itemTouchHelper.attachToRecyclerView(educationRecyclerView)
    }



        }