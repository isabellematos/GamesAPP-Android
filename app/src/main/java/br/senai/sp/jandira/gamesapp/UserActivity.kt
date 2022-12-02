package br.senai.sp.jandira.gamesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.gamesapp.R
import br.senai.sp.jandira.gamesapp.adapter.GamesAdapter
import br.senai.sp.jandira.gamesapp.databinding.ActivityUserBinding
import br.senai.sp.jandira.gamesapp.model.Usuario
import br.senai.sp.jandira.gamesapp.repository.GameRepository
import br.senai.sp.jandira.gamesapp.repository.UserRepository

class UserActivity : AppCompatActivity() {
    lateinit var rvGames: RecyclerView
    lateinit var binding: ActivityUserBinding
    lateinit var gamesRepository: GameRepository
    lateinit var user: Usuario
    lateinit var adapter: GamesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        binding = ActivityUserBinding.inflate(layoutInflater)


        setContentView(binding.root)

        var nome = intent.getStringExtra("nome").toString()
        var email = intent.getStringExtra("email").toString()
        var level = intent.getStringExtra("level").toString()

        binding.viewNomeUsuario.text = (nome)
        binding.textViewEmailUser.text = (email)
        binding.textViewUserLevel.text = (level)


       gamesRepository = GameRepository(this)

        adapter = GamesAdapter(this)
        adapter.updateGamesList(gamesRepository.getAllGames())


        rvGames = findViewById(R.id.rv_games)
        rvGames.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)


       // loadProfile()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_user, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.menu_save){
            user = Usuario()
            Toast.makeText(this, "Click", Toast.LENGTH_SHORT).show()
            return true
        }else if(item.itemId == R.id.menu_settings){
            Toast.makeText(this, "Configurações", Toast.LENGTH_SHORT).show()
            return true
        } else{
            Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
            return true
        }
    }



}
