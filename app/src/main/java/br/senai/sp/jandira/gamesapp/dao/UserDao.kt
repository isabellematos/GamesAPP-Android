package br.senai.sp.jandira.gamesapp.dao

import androidx.room.*
import br.senai.sp.jandira.gamesapp.model.Usuario


@Dao
    interface UserDao {

        @Insert
        fun  save(usuario: Usuario): Long

        @Update
        fun  update(usuario: Usuario): Int

        @Query("SELECT * FROM tbl_user ORDER BY nome ASC")
        fun getAll(): List<Usuario>

        @Query("SELECT * FROM tbl_user WHERE id = :id")
        fun getContactById(id: Int): Usuario
    }
