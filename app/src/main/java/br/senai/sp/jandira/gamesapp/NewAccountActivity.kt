package br.senai.sp.jandira.gamesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class NewAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_account)

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