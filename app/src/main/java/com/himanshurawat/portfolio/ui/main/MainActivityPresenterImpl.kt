package com.himanshurawat.portfolio.ui.main

class MainActivityPresenterImpl(private val view: MainActivityContract.View):
    MainActivityContract.Presenter {


    override fun nextFragment(fragmentTag: String): String {
       when(fragmentTag){

           "PersonalFragment" -> {
               view.updateSeekbar(40)
               view.updateStepTitleTextView("Educational Qualification")
               view.updateStepTextView("2 OF 5")
               view.loadEducationFragment()
               return "EducationFragment"
           }

           "EducationFragment" ->{
               view.updateSeekbar(60)
               view.updateStepTitleTextView("Work Experience")
               view.updateStepTextView("3 OF 5")
               view.loadWorkExFragment()
               return "WorkExFragment"
           }

           "WorkExFragment" ->{
               view.updateSeekbar(80)
               view.updateStepTitleTextView("Projects")
               view.updateStepTextView("4 OF 5")
               view.loadProjectsFragment()
               return "ProjectsFragment"
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

            "WorkExFragment" ->{
                view.updateSeekbar(40)
                view.updateStepTitleTextView("Educational Qualification")
                view.updateStepTextView("2 OF 5")
                view.popToEducationFragment()
                return "EducationFragment"
            }

            "ProjectsFragment" ->{
                view.updateSeekbar(40)
                view.updateStepTitleTextView("Work Experience")
                view.updateStepTextView("3 OF 5")
                view.popToWorkExFragment()
                return "WorkExFragment"
            }

        }
        return "PersonalFragment"
    }






}