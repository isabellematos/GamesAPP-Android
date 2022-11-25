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

    var name = ""
    var email = ""
    var password = ""
    var city = ""
    var birthDate = ""
    var level = NiveisEnum.INICIANTE
    var console = ""
    //var foto: Drawable? = null
    var sex = 'I'

}