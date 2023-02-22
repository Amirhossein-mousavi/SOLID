package ir.reversedev.solid.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class] , version = 1 , exportSchema = false)
abstract class DataBase() :RoomDatabase() {
    abstract val dao :UserDao
    companion object {
        private var instance : DataBase? =null
         fun getInstance (context: Context) :DataBase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, DataBase::class.java,"solid").allowMainThreadQueries().build()
            }
            return instance!!
        }
    }
}