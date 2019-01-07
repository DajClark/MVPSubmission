package com.example.mvpsubmission

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.mvpsubmission.Presenter.ISignUpPresenter
import com.example.mvpsubmission.Presenter.SignUpPresenter
import com.example.mvpsubmission.View.ISignUpView
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity(), ISignUpView {

    // Exits the activity to return to login page.
    override fun endActivity() {
        finish()
    }

    // Shows toast message on successful signup.
    override fun onSignUpSuccess(message: String) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }

    // Shows toast message on unsuccessful signup.
    override fun onSignUpError(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    // Late initialise to declare ISignUpPresenter interface to bypass null value.
    internal lateinit var signUpPresenter: ISignUpPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialises SignUpPresenter class.
        signUpPresenter = SignUpPresenter(this)

        // Listener to validate and add new user.
        btn_sign_up.setOnClickListener {
            signUpPresenter.onSignUp(edit_signup_email.text.toString(),edit_signup_password.text.toString(),edit_signup_username.text.toString())
        }
    }
}