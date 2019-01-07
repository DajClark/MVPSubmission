package com.example.mvpsubmission.View

// Interface for the sign up activity class.
interface ISignUpView {
    fun onSignUpSuccess(message: String)
    fun onSignUpError(message: String)
    fun endActivity()
}