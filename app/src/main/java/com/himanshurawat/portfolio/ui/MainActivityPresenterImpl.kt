package com.himanshurawat.portfolio.ui

class MainActivityPresenterImpl(private val view: MainActivityContract.View): MainActivityContract.Presenter {


    override fun nextFragment(fragmentTag: String): String {
       when(fragmentTag){

           "PersonalFragment" ->{
               view.updateSeekbar(40)
               view.updateStepTitleTextView("Educational Qualification")
               view.updateStepTextView("2 OF 5")
               view.loadEducationFragment()
               return "EducationFragment"
           }

           "EducationFragment" ->{

           }
       }
        return "PersonalFragment"
    }

    override fun previousFragment(fragmentTag: String): String {
        when(fragmentTag){
            "EducationFragment" ->{
                view.updateSeekbar(20)
                view.updateStepTextView("1 OF 5")
                view.updateStepTitleTextView("Personal Details")
                view.popToPersonalFragment()
                return "PersonalFragment"
            }
        }
        return "PersonalFragment"
    }






}