package com.himanshurawat.portfolio.ui.personal

class PersonalFragmentPresenterImpl(private val view: PersonalFragmentContract.View): PersonalFragmentContract.Presenter {

    override fun validateFirstName(firstName: String) {
        if(firstName.isEmpty()){
            view.setFirstNameError("Your Portfolio, Needs Your Name.")
            return
        }
    }

    override fun validateEmail(email: String) {
        if(email.isEmpty()){
            view.setEmailError("Need an Email To Deliver Your Offer Letters.")
            return
        }
    }

    override fun validateMobileNumber(mobileNumber: String) {
        if (mobileNumber.isEmpty()){
            view.setMobilePhoneError("For Those Telephonic Interviews? Right.")
        }
    }

}