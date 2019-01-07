package com.example.mvpsubmission.Presenter

import com.example.mvpsubmission.Model.User
import com.example.mvpsubmission.Model.UserList
import com.example.mvpsubmission.View.ISignUpView


class SignUpPresenter (internal var iSignUpView: ISignUpView):ISignUpPresenter {

    // Accepts email and password and username attempts to login to application,
    // calls view methods to pass messages using the interface depending on the result code
    // from the User class validation method.
    override fun onSignUp(email: String, password: String, username: String) {
        val user = User(email, password, username)
        val resultCode = user.isLoginValid()
        if (resultCode == 0)
            iSignUpView.onSignUpError("Username is Empty")
        else if (resultCode == 1)
            iSignUpView.onSignUpError("Email is Empty")
        else if (resultCode == 2)
            iSignUpView.onSignUpError("Invalid Email Address")
        else if (resultCode == 3)
            iSignUpView.onSignUpError("Password too short")
        else
            if (!UserList.findUserByEmail(email)) {
                iSignUpView.onSignUpSuccess("Sign Up Successful")
                UserList.addUser(user)
                iSignUpView.endActivity() }
            else
                iSignUpView.onSignUpError("Email Already Used")
    }
}