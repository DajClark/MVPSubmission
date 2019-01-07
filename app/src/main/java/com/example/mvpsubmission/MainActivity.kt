package com.example.mvpsubmission

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mvpsubmission.Model.User
import com.example.mvpsubmission.Model.UserList
import com.example.mvpsubmission.Presenter.ILoginPresenter
import com.example.mvpsubmission.Presenter.LoginPresenter
import com.example.mvpsubmission.View.ILoginView
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent



class MainActivity : AppCompatActivity(), ILoginView {

    // Navigates to the welcome page.
    override fun navigateToHome() {
        startActivity(Intent(this, WelcomeActivity::class.java))
    }

    // Navigates to the sign up page.
    override fun navigateToSignUp() {
        startActivity(Intent(this, SignUpActivity::class.java))
    }

    // Shows toast message on login success.
    override fun onLoginSuccess(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    // Shows toast message on login error.
    override fun onLoginError(message: String) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }

    // Declares new LoginPresenter class instance.
    internal lateinit var loginPresenter: ILoginPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Added for testing. TODO move out of view layer.
        val user = User("User1@gmail.com","12345678", "Dan")
        UserList.addUser(user)

        // Initialises LoginPresenter class instance for the view to communicate with presenter.
        loginPresenter = LoginPresenter(this)

        // Listener for login button click.
        btn_login.setOnClickListener {
            loginPresenter.onLogin(edit_email.text.toString(),edit_password.text.toString())
        }

        // Listener for sign up button click.
        btn_new_user.setOnClickListener {
            loginPresenter.onNavigateToHome()
        }
    }
}
