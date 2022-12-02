package br.senai.sp.jandira.gamesapp.repository

import android.content.Context
import br.senai.sp.jandira.gamesapp.dao.GamesDB
import br.senai.sp.jandira.gamesapp.model.Games
import br.senai.sp.jandira.gamesapp.model.Usuario

class UserRepository (context: Context){

    private val db = GamesDB.getDatabase(context).gamesDao(context)

    fun getUser(email: String, senha:String): Usuario {
        return db.autenticarUser(email, senha)
    }

}