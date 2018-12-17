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
        fun validate(firstName: String,email: String, mobileNumber: String): Boolean
        fun isValidFirstName(firstName: String): Boolean
        fun isValidEmail(email: String): Boolean
        fun isValidMobileNumber(mobileNumber: String): Boolean
    }
}