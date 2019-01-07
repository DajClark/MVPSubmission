package com.example.mvpsubmission.Presenter

// Interface for Login Presenter.
interface ILoginPresenter {
    fun onLogin(email:String,password:String)
    fun onNavigateToHome()
}