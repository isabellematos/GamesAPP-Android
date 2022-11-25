package br.senai.sp.jandira.gamesapp.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import br.senai.sp.jandira.gamesapp.model.Console
import br.senai.sp.jandira.gamesapp.model.Games
import br.senai.sp.jandira.gamesapp.model.Usuario

@Database(entities = [Games::class, Usuario::class, Console::class], version = 1)
abstract class GamesDB: RoomDatabase() {

    abstract fun gamesDao(context: Context): GamesDao

    companion object {

        private lateinit var instace: GamesDB

        fun getDatabase(context: Context):GamesDB{
            if (!::instace.isInitialized){
                instace = Room.databaseBuilder(context, GamesDB::class.java, "db_games").allowMainThreadQueries().build()
            }
            return instace
        }
    }

}