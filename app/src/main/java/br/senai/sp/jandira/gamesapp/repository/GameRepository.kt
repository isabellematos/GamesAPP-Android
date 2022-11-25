package br.senai.sp.jandira.gamesapp.repository

import android.content.Context
import br.senai.sp.jandira.gamesapp.dao.GamesDB
import br.senai.sp.jandira.gamesapp.model.Console
import br.senai.sp.jandira.gamesapp.model.Games
import br.senai.sp.jandira.gamesapp.model.Usuario

class  GameRepository (context: Context){

    private val db = GamesDB.getDatabase(context).gamesDao(context)

    fun saveUser(user: Usuario):Long{
        return db.saveUser(user)
    }

    fun updateUser(user: Usuario): Int{
        return db.updateUser(user)
    }

    fun deleteUser(user: Usuario): Int{
        return db.deleteUser(user)
    }

    fun saveGame(games: Games):Long{
        return db.saveGame(games)
    }

    fun autenticate(email: String, pass: String): Usuario{
        return db.autenticarUser(email, pass)
    }

    fun updateGame(games: Games): Int{
        return db.updateGame(games)
    }

    fun deleteGame(games: Games): Int{
        return db.deleteGame(games)
    }

    fun getAllGames(): List<Games>{
        return db.getAllGames()
    }

    fun saveConsole(console: Console):Long{
        return db.saveConsole(console)
    }

    fun updateConsole(console: Console): Int{
        return db.updateConsole(console)
    }

    fun deleteConsole(console: Console): Int{
        return db.deleteConsole(console)
    }

    fun getAllConsole(): List<String>{
        return db.getAllConsole()
    }

}