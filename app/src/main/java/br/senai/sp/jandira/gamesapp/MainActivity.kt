package br.senai.sp.jandira.gamesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.senai.sp.jandira.gamesapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewCreate.setOnClickListener {
            val abrirNewAccountActivity = Intent(this, NewAccountActivity::class.java)
            startActivity(abrirNewAccountActivity)


            binding.buttonSignin.setOnClickListener {
                login()
            }
        }

    }

    private fun login() {

        if(validar()){
            val email = binding.editTextTextEmailAddress.text.toString()
            val pass = binding.editTextTextPassword.text.toString()

            val dados = getSharedPreferences("dados", MODE_PRIVATE)

            val emailSp = dados.getString("email", "Email não encontrado")
            val passSp = dados.getString("password", "")

            //verificar se os dados de autentificacao estao corretos
            if(email == emailSp && pass == passSp) {
                val openCalculate = Intent(
                    this,
                    NewAccountActivity::class.java)
                startActivity(openCalculate)
            } else {
                Toast.makeText(
                    this,
                    "Authentication failed",
                    Toast.LENGTH_SHORT).show()
            }

        }


    }

    private fun validar(): Boolean {
        if (binding.editTextTextEmailAddress.text.isEmpty()){
            binding.editTextTextEmailAddress.error = "Email is required!"
            return false
        }

        if (binding.editTextTextPassword.text.isEmpty()){
            binding.editTextTextPassword.error = "Password is required"
            return false
        }
        return true
    }
}


