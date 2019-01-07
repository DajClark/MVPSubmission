package com.example.mvpsubmission.View

// Interface for the login activity class.
interface ILoginView {
    fun onLoginSuccess(message: String)
    fun onLoginError(message: String)
    fun navigateToHome()
    fun navigateToSignUp()
}