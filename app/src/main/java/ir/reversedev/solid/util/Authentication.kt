package ir.reversedev.solid.util

import ir.reversedev.solid.model.UserDao

interface Authenticator {
    fun signIn(
        userName: String,
        password: String
    ): Boolean
}

class AuthenticationRoom(
    val dao : UserDao
) : Authenticator {

    override fun signIn(
        userName: String,
        password: String
    ): Boolean {
         return dao.auth(userName , password) != null
    }
}

class AuthenticationServer(
    val dao : UserDao
) : Authenticator {
    override fun signIn(
        userName: String,
        password: String
    ): Boolean {
        return dao.auth(userName , password) != null
    }
}