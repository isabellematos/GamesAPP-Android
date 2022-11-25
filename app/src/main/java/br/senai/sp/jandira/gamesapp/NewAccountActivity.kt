package br.senai.sp.jandira.gamesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import br.senai.sp.jandira.gamesapp.R
import br.senai.sp.jandira.gamesapp.databinding.ActivityNewAccountBinding
import br.senai.sp.jandira.gamesapp.model.NiveisEnum
import br.senai.sp.jandira.gamesapp.model.Usuario
import br.senai.sp.jandira.gamesapp.repository.GameRepository

class NewAccountActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewAccountBinding
    lateinit var userRepository: GameRepository
    lateinit var user: Usuario


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNewAccountBinding.inflate(layoutInflater)
        setContentView(binding.root)

        userRepository = GameRepository(this)

        val lista = userRepository.getAllConsole()

        val arrayAdapter = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, lista)
        binding.spinner.adapter = arrayAdapter

        binding.enumLevel.text = NiveisEnum.INICIANTE.toString()

        binding.slider.addOnChangeListener { _, value, _ ->
            if (value.toInt() == 1){
                binding.enumLevel.text = NiveisEnum.INICIANTE.toString()
            } else if (value.toInt() == 2){
                binding.enumLevel.text = NiveisEnum.BASICO.toString()
            }else if (value.toInt() == 3){
                binding.enumLevel.text = NiveisEnum.CASUAL.toString()
            }else if (value.toInt() == 4){
                binding.enumLevel.text = NiveisEnum.AVANCADO.toString()
            }
        }
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        val inflater = menuInflater
        inflater.inflate(R.menu.menu_new_user, menu)

        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if(item.itemId == R.id.menu_save){
            user = Usuario()
            save()
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

    private fun save() {

        user.email = binding.editTextEmail.text.toString()
        user.password = binding.editTextPassword.text.toString()
        user.name = binding.editTextName.text.toString()
        user.city = binding.editTextCidade.text.toString()

        val op = binding.radioGroup!!.checkedRadioButtonId

        user.sex = op.toChar()
        user.console = binding.spinner.selectedItem.toString()

        userRepository = GameRepository(this)


        val id = userRepository.saveUser(user)

        Toast.makeText(this, "ID: $id", Toast.LENGTH_LONG).show()


        finish()
    }
}