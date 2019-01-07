package com.example.mvpsubmission.Model

import java.util.ArrayList

class UserList {

    companion object {

        // Arraylist to hold user data.
        var userList: ArrayList<User> = ArrayList()

        // Finds user using current email within list of user data and return boolean on success.
        fun findUser(email: String, password: String): Boolean {

            for (user in userList) {
                if (user.email.equals(email) && user.password.equals(password)) {
                    return true
                }
            }
            return false
        }

        // Finds user using current email within list of user data and return boolean on success.
        fun findUserByEmail(email: String): Boolean {

            for (user in userList) {
                if (user.email.equals(email)) {
                    return true
                }
            }
            return false
        }

        // Adds new user to the list.
        fun addUser(user: User) {
            userList.add(user)
        }
    }

}