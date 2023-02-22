package ir.reversedev.solid.util

import android.util.Log

class Login (
    private val authentication: Authenticator,
    private val errorHandel: NewErrorHandle,
        ) {
    fun login (userName :String , password :String) :Pair<String , Boolean> {
        val login = authentication.signIn(userName , password)
        return if (login) {
            Log.e("3169" , "login")
            Pair("login success" , true)
        } else {
            Pair(errorHandel.loginError(userName , password) , false)

        }
    }
}