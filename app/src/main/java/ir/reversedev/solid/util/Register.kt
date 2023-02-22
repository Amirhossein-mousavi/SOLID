package ir.reversedev.solid.util

import ir.reversedev.solid.model.User
import ir.reversedev.solid.model.UserDao

class Register(
    val dao: UserDao
) {

    fun signUp(user: User):  Boolean{
        val userName = dao.getUserName(userName = user.userName)

        return if (user.userName == userName) {
             false
        } else {
            dao.register(user)
            true
        }
    }

}