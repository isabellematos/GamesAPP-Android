package br.senai.sp.jandira.gamesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import br.senai.sp.jandira.gamesapp.R
import br.senai.sp.jandira.gamesapp.databinding.ActivityNewAccountBinding
import br.senai.sp.jandira.gamesapp.model.Console
import br.senai.sp.jandira.gamesapp.model.Games
import br.senai.sp.jandira.gamesapp.model.NiveisEnum
import br.senai.sp.jandira.gamesapp.model.Usuario
import br.senai.sp.jandira.gamesapp.repository.ConsoleRepository
import br.senai.sp.jandira.gamesapp.repository.UserRepository
import java.time.LocalDate

class NewAccountActivity : AppCompatActivity() {

    lateinit var binding: ActivityNewAccountBinding
    lateinit var userRepository: UserRepository
    lateinit var consoleRepository: ConsoleRepository
    lateinit var user: Usuario
    lateinit var console: Console
    private var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_account)


            binding = ActivityNewAccountBinding.inflate(layoutInflater)

            setContentView(binding.root)

        console = Console()


            id = intent.getIntExtra("id", 0)
        consoleRepository = ConsoleRepository(this)

        val aS = listOf<String>(consoleRepository.getAll().toString())
        val aA = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, aS)
        binding.spinner.adapter = aA
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menu_save){
            Toast.makeText(this, "salvar", Toast.LENGTH_SHORT).show()
            if(id > 0) {
                carregarUsuario()
            }
            return true

        } else if (item.itemId == R.id.menu_settings){
            Toast.makeText(this, "configurações", Toast.LENGTH_SHORT).show()
            return true
        } else {
            Toast.makeText(this, "Sair", Toast.LENGTH_SHORT).show()
            return true
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_new_user, menu)

        return true
    }



        private fun carregarUsuario() {
          userRepository = UserRepository(this)
             user = userRepository.getUserById(id)

            binding.editTextName.setText(user.nome)
            binding.editTextEmail.setText(user.email)
            binding.editTextPassword.setText(user.senha)
            binding.editTextCidade.setText(user.cidade)
            binding.editTextDatebirth.setText(user.dataNascimento.toString())

        }

    }
