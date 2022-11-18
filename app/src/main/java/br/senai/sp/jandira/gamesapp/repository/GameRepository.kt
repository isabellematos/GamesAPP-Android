package br.senai.sp.jandira.gamesapp.repository

import android.content.Context
import br.senai.sp.jandira.gamesapp.dao.GamesDb
import br.senai.sp.jandira.gamesapp.model.Usuario

class  GameRepository (context: Context){

    private val db = GamesDb.getDataBase(context).userDao()


    fun getAll(): List<Usuario> {
        return db.getAll()
    }

    fun getUserById(id: Int): Usuario {
        return db.getUserById(id)
    }
}