package com.example.mvpsubmission.Model

import android.text.TextUtils
import android.util.Patterns

// User object to hold user data.
class User(override val email:String,override val password:String,override val username:String):IUser {

    // Function to test if the login information is valid.
    override fun isLoginValid(): Int {
        if(TextUtils.isEmpty(username))
            return 0
        else if(TextUtils.isEmpty(email))
            return 1
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return 2
        else if (password.length <= 7)
            return 3
        else
            return -1
    }

}