package ir.reversedev.solid.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "tb_user")
class User (
    val name : String ,
    val family : String ,
    @PrimaryKey(autoGenerate = false)
    val userName : String ,
    val email : String ,
    val password : String
        ) :Parcelable