package com.example.mvpsubmission.Model

// Interface for UserList
interface IUserList {
    var userList: ArrayList<User>

    fun findUser(email: String, password: String):Boolean
    fun findUserByEmail(email: String):Boolean
    fun addUser(user: User)
}