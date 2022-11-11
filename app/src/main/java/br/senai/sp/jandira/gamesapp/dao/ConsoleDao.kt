package br.senai.sp.jandira.gamesapp.dao

import androidx.room.*
import br.senai.sp.jandira.gamesapp.model.Console


@Dao
interface ConsoleDao {

    @Insert
    fun  save(console: Console): Long

    @Update
    fun  update(console: Console): Int

    @Query("SELECT * FROM tbl_user ORDER BY nome ASC")
    fun getAll(): List<Console>

    @Query("SELECT * FROM tbl_user WHERE id = :id")
    fun getContactById(id: Int): Console
}