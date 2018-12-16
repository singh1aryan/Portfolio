package com.himanshurawat.portfolio.ui.personal

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.SeekBar
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import com.himanshurawat.portfolio.R

class PersonalFragment : androidx.fragment.app.Fragment(), PersonalFragmentContract.View {


    private lateinit var seekBar: SeekBar
    private lateinit var presenter: PersonalFragmentContract.Presenter

    private lateinit var firstNameTextInputLayout: TextInputLayout
    private lateinit var emailTextInputLayout: TextInputLayout
    private lateinit var mobileNumberTextInputLayout: TextInputLayout

    private lateinit var firstNameTextInputEditText: TextInputEditText
    private lateinit var lastNameTextInputEditText: TextInputEditText
    private lateinit var emailTextInputEditText: TextInputEditText
    private lateinit var mobileNumberTextInputEditText: TextInputEditText
    private lateinit var addressTextInputEditText: TextInputEditText


    private lateinit var nextQuestionButton: MaterialButton

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_personal,container,false)
        presenter = PersonalFragmentPresenterImpl(this)


        firstNameTextInputEditText = view.findViewById(R.id.fragment_personal_first_name_text_input_edit_text)
        lastNameTextInputEditText = view.findViewById(R.id.fragment_personal_last_name_text_input_edit_text)
        emailTextInputEditText = view.findViewById(R.id.fragment_personal_email_text_input_edit_text)
        mobileNumberTextInputEditText = view.findViewById(R.id.fragment_personal_mobile_number_text_input_edit_text)
        addressTextInputEditText = view.findViewById(R.id.fragment_personal_address_text_input_edit_text)

        firstNameTextInputLayout = view.findViewById(R.id.fragment_personal_first_name_text_input_layout)
        emailTextInputLayout = view.findViewById(R.id.fragment_personal_email_text_input_layout)
        mobileNumberTextInputLayout = view.findViewById(R.id.fragment_personal_mobile_number_text_input_layout)


        nextQuestionButton = view.findViewById(R.id.fragment_personal_next_question_button)

        nextQuestionButton.setOnClickListener {
            firstNameTextInputLayout.isErrorEnabled = false
            mobileNumberTextInputLayout.isErrorEnabled = false
            emailTextInputLayout.isErrorEnabled = false

            presenter.validateFirstName(firstNameTextInputEditText.text.toString())
            presenter.validateEmail(emailTextInputEditText.text.toString())
            presenter.validateMobileNumber(mobileNumberTextInputEditText.text.toString())

        }


//        progress = 20
//        setOnTouchListener(this)

        return view
    }


    override fun setFirstNameError(error: String) {
        firstNameTextInputLayout.isErrorEnabled = true
        firstNameTextInputLayout.error = error

    }

    override fun setEmailError(error: String) {
        emailTextInputLayout.isErrorEnabled = true
        emailTextInputLayout.error = error
    }

    override fun setMobilePhoneError(error: String) {
        mobileNumberTextInputLayout.isErrorEnabled = true
        mobileNumberTextInputLayout.error = error
    }
}