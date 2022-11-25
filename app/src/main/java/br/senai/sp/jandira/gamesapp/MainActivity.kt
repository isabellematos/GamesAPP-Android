package br.senai.sp.jandira.gamesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import br.senai.sp.jandira.gamesapp.R
import br.senai.sp.jandira.gamesapp.databinding.ActivityMainBinding
import br.senai.sp.jandira.gamesapp.databinding.ActivityNewAccountBinding
import br.senai.sp.jandira.gamesapp.model.Console
import br.senai.sp.jandira.gamesapp.repository.GameRepository

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var console: Console
    lateinit var userRepository: GameRepository

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        console = Console()
        userRepository = GameRepository(this)
        val lista = userRepository.getAllConsole()

        if (lista.size == 0){
            cadastro()
        }

        binding.textViewCreate.setOnClickListener{
            val openSignupActivity = Intent(this, NewAccountActivity::class.java)
            startActivity(openSignupActivity)
        }

        binding.buttonSignin.setOnClickListener {

            if(inputValidate()){
                val usuario = binding.editTextTextEmailAddress.text.toString()
                val senha = binding.editTextTextPassword.text.toString()

                val logar = userRepository.autenticate(usuario, senha)
                Toast.makeText(this, "$logar", Toast.LENGTH_SHORT).show()

                if(logar != null){
                    val openUserActivity = Intent(this, UserActivity::class.java)
                    startActivity(openUserActivity)
                } else{
                    Toast.makeText(this, "oi", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }

    private fun cadastro() {
        console.anoLancamento = 2013
        console.descricao = "O PlayStation 4, ou PS4 (como é mais conhecido) é um video game da Sony lançado em 2013. O console tem três versões principais: fat, slim e Pro. A primeira (e original) tem esse nome por causa do peso e conta com 500 GB de armazenamento."
        console.fabricante = "Sony"
        console.nome = "Playstation 4"

        userRepository = GameRepository(this)

        userRepository.saveConsole(console)

        console.anoLancamento = 2013
        console.descricao = "O Xbox One é uma central multimídia além de um videogame. Nele podem ser acessados diversos aplicativos como Netflix, YouTube e redes sociais que permitem o usuário ter Internet, TV e games em uma única plataforma, além de ser compatível com o Windows 10 e a Xbox Live."
        console.fabricante = "Microsoft"
        console.nome = "Xbox One"

        userRepository.saveConsole(console)
    }

    private fun inputValidate(): Boolean {
        if (binding.editTextTextPassword.text.isEmpty()){
            binding.editTextTextEmailAddress.error = "E-mail is required"
            return false
        }
        if (binding.editTextTextPassword.text.isEmpty()){
            binding.editTextTextPassword.error = "Password is required"
            return false
        }

        return true
    }
}