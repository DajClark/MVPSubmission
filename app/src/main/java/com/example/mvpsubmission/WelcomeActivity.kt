package com.example.mvpsubmission

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


class WelcomeActivity : AppCompatActivity() {

    // Shows welcome message to prove login.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }

}