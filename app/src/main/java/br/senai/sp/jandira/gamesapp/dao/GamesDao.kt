package br.senai.sp.jandira.gamesapp.dao

import androidx.room.*
import br.senai.sp.jandira.gamesapp.model.Console
import br.senai.sp.jandira.gamesapp.model.Games
import br.senai.sp.jandira.gamesapp.model.Usuario

@Dao
interface GamesDao {

    @Insert
    fun saveUser (user: Usuario): Long

    @Delete
    fun deleteUser(user: Usuario): Int

    @Update
    fun updateUser(user: Usuario): Int

    @Insert
    fun saveConsole (console: Console): Long

    @Delete
    fun deleteConsole(console: Console): Int

    @Update
    fun updateConsole(console: Console): Int

    @Query("SELECT nome FROM tbl_console ORDER BY nome ASC")
    fun getAllConsole(): List<String>

    @Insert
    fun saveGame (games: Games): Long

    @Delete
    fun deleteGame(games: Games): Int

    @Update
    fun updateGame(games: Games): Int

    @Query("SELECT * FROM tbl_games ORDER BY name ASC")
    fun getAllGames(): List<Games>

    @Query("SELECT * FROM tbl_user WHERE email = :email AND password = :pass")
    fun autenticarUser(email: String, pass: String): Usuario

    @Query("SELECT * FROM tbl_user ORDER BY name ASC")
    fun getAll(): List<Usuario>

    @Query("SELECT * FROM tbl_user WHERE id = :id")
    fun getUserById(id: Int): Usuario

    @Query("SELECT nome FROM tbl_console ORDER BY nome ASC")
    fun getAllConsoles(): List<String>
}