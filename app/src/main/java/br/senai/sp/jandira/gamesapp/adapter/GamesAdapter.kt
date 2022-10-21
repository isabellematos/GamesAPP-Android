package br.senai.sp.jandira.gamesapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.gamesapp.R
import br.senai.sp.jandira.gamesapp.model.Games


class GamesAdapter(val context: Context) : RecyclerView.Adapter<GamesAdapter.HolderGames>() {

        private var gamesList = listOf<Games>()

        fun updatePontosTuristicosList(pontosTuristicos: List<Games>) {
            this.gamesList = pontosTuristicos
            notifyDataSetChanged()
        }

        //Criar uma inner class
        class HolderGames(view: View): RecyclerView.ViewHolder(view) {

            val textTituloG = view.findViewById<TextView>(R.id.text_view_titulo)
            val textMarca = view.findViewById<TextView>(R.id.text_view_marca)
            val textDescricao = view.findViewById<TextView>(R.id.text_view_descricao)
            val imageHolder = view.findViewById<ImageView>(R.id.image_holder)

            fun bind(Games: Games) {
                textTituloG.text = Games.nomeGame
                textMarca.text = Games.marcaGame
                textDescricao.text = Games.descricao
                imageHolder.setImageDrawable(Games.imagem)
            }


        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderGames {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.holder_layout, parent, false)
            return HolderGames(view)
        }

        override fun onBindViewHolder(holder: HolderGames, position: Int) {
            holder.bind(gamesList.get(position))
        }

        override fun getItemCount(): Int {
            return gamesList.size
        }


    }