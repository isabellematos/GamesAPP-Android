package br.senai.sp.jandira.gamesapp.dao

import androidx.room.*
import br.senai.sp.jandira.gamesapp.model.Usuario


@Dao
    interface UserDao {

        @Query("SELECT * FROM tbl_user ORDER BY nome ASC")
        fun getAll(): List<Usuario>

        @Query("SELECT * FROM tbl_user WHERE id = :id")
        fun getUserById(id: Int): Usuario

        @Query("SELECT nome FROM tbl_console ORDER BY nome ASC")
        fun getAllConsoles(): List<String>
    }
