package ir.reversedev.solid.model

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM tb_user WHERE userName = :userName AND password = :password")
    fun auth (userName :String , password :String) :User?

    @Query("SELECT * FROM tb_user WHERE userName = :userName")
    fun getUser (userName :String) :User

    @Query("SELECT userName FROM tb_user WHERE userName = :userName")
    fun getUserName (userName: String) :String?
    @Insert()
    fun register (user :User)
}