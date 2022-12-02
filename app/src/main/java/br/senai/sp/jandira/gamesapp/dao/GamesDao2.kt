package br.senai.sp.jandira.gamesapp.dao

import android.content.Context
import br.senai.sp.jandira.gamesapp.R
import br.senai.sp.jandira.gamesapp.model.Jogos

class GamesDao2 {

        //Tudo o que esta dentro do metodo companion é estatico
        companion object {
            fun getGames(context: Context): List<Jogos> {
                val pt1 = Jogos()
                pt1.codigo = 1
                pt1.nomeGame = "Stardew Valley"
                pt1.marcaGame = "ConcernedApe"
                pt1.descricao = "Stardew Valley é um jogo de videogame, dos gêneros RPG e simulação, desenvolvido por Eric Barone e publicado pela ConcernedApe e pela Chucklefish."
                pt1.imagem = context.getDrawable(R.drawable.stardew )
                pt1.anoLancamento = 2010

    val pt2 = Jogos()
    pt2.codigo = 2
    pt2.nomeGame = "The Sims 4"
    pt2.marcaGame = "Eletronic Arts"
    pt2.descricao = "The Sims 4 é um jogo de simulação social de 2014 desenvolvido pela Maxis e publicado pela Electronic Arts. É o quarto título principal da série The Sims e é a sequência de The Sims 3."
    pt2.imagem = context.getDrawable(R.drawable.sims4 )
    pt2.anoLancamento = 1998

    val pt3 = Jogos()
    pt3.codigo = 3
    pt3.nomeGame = "League of Legends"
    pt3.marcaGame = "Riot Games"
    pt3.descricao = "League of Legends é um jogo eletrônico do gênero multiplayer online battle arena desenvolvido e publicado pela Riot Games. Foi lançado em outubro de 2009 para Microsoft Windows. "
    pt3.imagem = context.getDrawable(R.drawable.lol )
    pt3.anoLancamento = 2010

    val pt4 = Jogos()
    pt4.codigo = 4
    pt4.nomeGame = "Undertale"
    pt4.marcaGame = "Toby Fox"
    pt4.descricao = "Undertale é um RPG eletrônico criado pelo desenvolvedor independente norte-americano Toby Fox. No jogo, o jogador pode controlar uma criança humana que caiu em uma caverna e vive aventuras. "
    pt4.imagem = context.getDrawable(R.drawable.undertale )
    pt4.anoLancamento = 2014

    val pt5 = Jogos()
    pt5.codigo = 5
    pt5.nomeGame = "The Last of US"
    pt5.marcaGame = "Naughty Dog"
    pt5.descricao = "The Last of Us Part II é um jogo eletrônico de ação-aventura desenvolvido pela Naughty Dog e publicado pela Sony Interactive Entertainment. "
    pt5.imagem = context.getDrawable(R.drawable.last )
    pt5.anoLancamento = 2000

                val games = listOf<Jogos>(pt1, pt2, pt3, pt4, pt5)
                return games
            }
        }

}