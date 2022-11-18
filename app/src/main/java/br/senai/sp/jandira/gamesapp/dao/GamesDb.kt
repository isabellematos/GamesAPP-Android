package br.senai.sp.jandira.gamesapp.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.gamesapp.model.Console
import br.senai.sp.jandira.gamesapp.model.Games
import br.senai.sp.jandira.gamesapp.model.Usuario

@Database(entities = [Usuario::class, Games::class, Console::class], version = 1)
abstract class GamesDb: RoomDatabase() {
    abstract fun userDao():UserDao

    companion object {
        private lateinit var instance: GamesDb

        fun getDataBase(context: Context): GamesDb{
            if(!::instance.isInitialized) {
                instance = Room.databaseBuilder(context,
                    GamesDb::class.java, "db_games")
                    .allowMainThreadQueries().build()

            }
            return instance
        }

    }


}