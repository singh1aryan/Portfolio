package com.himanshurawat.portfolio.ui.personal

interface PersonalFragmentContract {


    interface Model{

    }

    interface View{
        fun setFirstNameError(error: String)
        fun setEmailError(error: String)
        fun setMobilePhoneError(error: String)

    }

    interface Presenter{
        fun validateFirstName(firstName: String)
        fun validateEmail(email: String)
        fun validateMobileNumber(mobileNumber: String)
    }
}