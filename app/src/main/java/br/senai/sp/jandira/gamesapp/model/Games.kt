package br.senai.sp.jandira.gamesapp.model

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Console
import java.time.LocalDate

class Games {
    @PrimaryKey(autoGenerate = true)
    var codigo = 0
    var imagem: Bitmap? = null
    var nomeGame = ""
    var descricao = ""
    var marcaGame = ""
    var anoLancamento = ""
    var finalizado: Boolean? = null

}




