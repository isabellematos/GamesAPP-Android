package br.senai.sp.jandira.gamesapp.repository

import android.content.Context
import br.senai.sp.jandira.gamesapp.dao.GamesDB

import br.senai.sp.jandira.gamesapp.model.Usuario

class ConsoleRepository (context: Context){

    private val db = GamesDB.getDatabase(context).gamesDao(context)


    fun getAll(): List<String> {
        return db.getAllConsole()
    }
}