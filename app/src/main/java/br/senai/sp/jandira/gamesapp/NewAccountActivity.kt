package br.senai.sp.jandira.gamesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import br.senai.sp.jandira.gamesapp.R
import br.senai.sp.jandira.gamesapp.databinding.ActivityNewAccountBinding
import br.senai.sp.jandira.gamesapp.model.Games
import br.senai.sp.jandira.gamesapp.model.Usuario
import br.senai.sp.jandira.gamesapp.repository.UserRepository
import java.time.LocalDate

class NewAccountActivity : AppCompatActivity() {

    lateinit var binding: ActivityNewAccountBinding
    lateinit var userRepository: UserRepository
    lateinit var user: Usuario
    private var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_account)


            binding = ActivityNewAccountBinding.inflate(layoutInflater)

            setContentView(binding.root)

            binding.menuSave.setOnClickListener {
                save()
            }

            id = intent.getIntExtra("id", 0)

            if(id > 0) {
                binding.buttonExcluir.visibility = View.VISIBLE
                binding.button.text = "Atualizar"
                carregarContato()
            }



        private fun carregarUsuario() {
            userRepository = UserRepository(this)
            user = userRepository.getContactById(id)

            binding.editTextName.setText(user.nome)
            binding.editTextEmail.setText(user.email)
            binding.editTextPassword.setText(user.senha)
            binding.editTextCidade.setText(user.cidade)
            binding.editTextDatebirth.float.(user.dataNascimento)


        }
    }


        private fun save() {

            user.email = binding.editTextEmail.text.toString()
            user.senha = binding.editTextPassword.text.toString()
            user.nome = binding.editTextName.text.toString()
            user.dataNascimento = binding.editTextDatebirth.text.toString()

            //criar uma instancia do repositorio
            userRepository = UserRepository(this)

            if (id > 0) {
                user.id = id
                userRepository.update(user)
            }else {
                val id = userRepository.save(user)
            }

            Toast.makeText(this,
                "ID:$id",
                Toast.LENGTH_SHORT).show()



            finish()
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (item.itemId == R.id.menu_save){
            Toast.makeText(this, "salvar", Toast.LENGTH_SHORT).show()
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

}