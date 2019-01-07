package com.example.mvpsubmission.Presenter

import com.example.mvpsubmission.Model.User
import com.example.mvpsubmission.Model.UserList
import com.example.mvpsubmission.View.ILoginView


class LoginPresenter (internal var iLoginView:ILoginView):ILoginPresenter {

    // Function to navigate to the sign up activity.
    override fun onNavigateToHome() {
        iLoginView.navigateToSignUp()
    }

    // Accepts email and password and attempts to login to application, calls view
    // methods to pass messages using the interface depending on the result code
    // from the User class validation method.
    override fun onLogin(email: String, password: String) {
        val user = User(email, password, "login")
        val loginCode = user.isLoginValid()
        if (loginCode == 1)
            iLoginView.onLoginError("Please Provide Email")
        else if (loginCode == 2)
            iLoginView.onLoginError("Wrong Email Address")
        else if (loginCode == 3)
            iLoginView.onLoginError("Password Too Short")
        else
            if (UserList.findUser(email, password)) {
                iLoginView.onLoginSuccess("Login Success")
                iLoginView.navigateToHome() }
            else
                iLoginView.onLoginError("User Not Found")

    }
}