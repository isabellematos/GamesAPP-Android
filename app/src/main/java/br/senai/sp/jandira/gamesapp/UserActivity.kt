package br.senai.sp.jandira.gamesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.gamesapp.adapter.GamesAdapter
import br.senai.sp.jandira.gamesapp.dao.GamesDao


class UserActivity : AppCompatActivity() {

    lateinit var rvGames: RecyclerView
    lateinit var  adapterGames: GamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        //Criar uma instancia da recyclerView
        rvGames = findViewById(R.id.rv_games)

        //determinar o layout da recyclerview
        rvGames.layoutManager =
            LinearLayoutManager(
                this,
                LinearLayoutManager.VERTICAL,
                false)

        //criar uma instancia do adapter
        adapterGames = GamesAdapter(this)
        adapterGames.updateGamesList(GamesDao.getGames(this))

        //Ligar o adapter a nossa recyclerView
        rvGames.adapter = adapterGames
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menu_save){
            Toast.makeText(this, "adicionar", Toast.LENGTH_SHORT).show()
            return true
        } else if (item.itemId == R.id.menu_settings){
            Toast.makeText(this, "configurações", Toast.LENGTH_SHORT).show()
            return true
        } else {
            Toast.makeText(this, "sair", Toast.LENGTH_SHORT).show()
            return true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_user, menu)

        return true
    }
}