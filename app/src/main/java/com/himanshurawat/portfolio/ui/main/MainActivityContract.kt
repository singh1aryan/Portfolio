package com.himanshurawat.portfolio.ui.main

interface MainActivityContract {


    interface Model{

    }

    interface View {
        fun loadPersonalFragment()

        fun loadEducationFragment()

        fun loadWorkExFragment()

        fun loadProjectsFragment()

        fun popToPersonalFragment()

        fun popToEducationFragment()

        fun popToWorkExFragment()

        fun popToProjectsFragment()

        fun popFragment()

        fun updateSeekbar(progress: Int)
        fun updateStepTextView(step: String)
        fun updateStepTitleTextView(title: String)

    }

    interface Presenter{
        fun nextFragment(fragmentTag: String): String
        fun previousFragment(fragmentTag: String): String
    }
}