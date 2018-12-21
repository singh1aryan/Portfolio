package com.himanshurawat.portfolio.ui.personal

class PersonalFragmentPresenterImpl(private val view: PersonalFragmentContract.View): PersonalFragmentContract.Presenter {



    override fun validate(firstName: String, email: String, mobileNumber: String): Boolean {
        if(isValidFirstName(firstName) && isValidMobileNumber(mobileNumber) && isValidEmail(email)){
            return true
        }
        return false
    }

    override fun isValidFirstName(firstName: String):Boolean {
        if(firstName.isEmpty()){
            view.setFirstNameError("Your Portfolio needs your Name.")
            return false
        }
        return true
    }


    override fun isValidEmail(email: String): Boolean {
        if(email.isEmpty()){
            view.setEmailError("Need an Email To Deliver Your Offer Letters.")
            return false
        }


        return true
    }

    override fun isValidMobileNumber(mobileNumber: String): Boolean {
        if (mobileNumber.isEmpty()){
            view.setMobilePhoneError("For Those Telephonic Interviews? Right.")
            return false
        }

        return true
    }

}