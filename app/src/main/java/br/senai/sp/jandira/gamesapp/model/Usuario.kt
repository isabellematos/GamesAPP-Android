package br.senai.sp.jandira.gamesapp.model

import android.graphics.Bitmap
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

@Entity(tableName = "tbl_user")
class Usuario {

    @PrimaryKey(autoGenerate = true)
    var id = 0

    var nome = ""
    var telefone = ""
    var email = ""
    var senha = ""
    var cidade = ""
    var dataNascimento: LocalDate? = null
    var nivel = NiveisEnum.INICIANTE
    var console: Console? = null
    var foto: Bitmap? = null
    var sex = 'I'

}