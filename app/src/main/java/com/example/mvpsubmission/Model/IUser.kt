package com.example.mvpsubmission.Model

interface IUser {

    // Hold variables for login email and password.
    val email:String
    val password:String
    val username:String

    // Function to test if data is valid.
    fun isLoginValid():Int

}