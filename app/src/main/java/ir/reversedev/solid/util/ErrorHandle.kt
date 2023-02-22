package ir.reversedev.solid.util

import android.util.Log

open class ErrorHandle {
    open fun loginError (
        userName :String,
        password :String,
    ) :String{
        Log.e("3169" , "userName : $userName")
        Log.e("3169" , "password : $password")
        return "login fail"
    }
    open fun registerError (
        userName :String,
        password :String,
        name :String,
        family :String,
    ) :String{
        Log.e("3169" , "name : $name")
        Log.e("3169" , "family : $family")
        Log.e("3169" , "userName : $userName")
        Log.e("3169" , "password : $password")
        return "register fail"
    }
}
class NewErrorHandle :ErrorHandle() {
    override fun loginError(userName: String, password: String): String {
        Log.e("3169" , "this userName : $userName")
        Log.e("3169" , "this password : $password")
        return "login fail try again"
    }
    fun myLoginError(userName: String, password: String): String {
        Log.e("3169" , "this userName : $userName")
        Log.e("3169" , "this password : $password")
        return "login fail try again"
    }
}