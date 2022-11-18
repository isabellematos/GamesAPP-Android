package br.senai.sp.jandira.gamesapp.model

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
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
    var dataNascimento = ""
    var nivel = NiveisEnum.INICIANTE
    //var console = Console
    //var foto: Drawable? = null
    var sex = 'I'

}