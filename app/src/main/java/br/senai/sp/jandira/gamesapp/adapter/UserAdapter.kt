package br.senai.sp.jandira.gamesapp.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import br.senai.sp.jandira.gamesapp.NewAccountActivity
import br.senai.sp.jandira.gamesapp.R
import br.senai.sp.jandira.gamesapp.model.Usuario

class UserAdapter(var userList: List<Usuario>, var context: Context):
    RecyclerView.Adapter<UserAdapter.UserHolder>() {


    fun updateContactList(newContactList: List<Usuario>) {
        this.userList = newContactList
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserHolder {
        val view = LayoutInflater
            .from(parent.context).inflate(R.layout.activity_new_account, parent, false)

        return UserHolder(view)

    }

    override fun onBindViewHolder(holder: UserHolder, position: Int) {
        val user = userList[position]

        holder.textViewNome.text = user.nome
        holder.textViewEmail.text = user.email
        holder.textViewCidade.text = user.cidade
        holder.textViewPassword.text = user.senha
        holder.textViewDataNasc.text = user.dataNascimento

        holder.cardViewContact.setOnClickListener {
            val intent = Intent(context, NewAccountActivity::class.java)
            intent.putExtra("id", user.id)
            context.startActivity(intent)
        }


    }

    override fun getItemCount(): Int {
        return userList.size
    }

    class UserHolder(view: View) : RecyclerView.ViewHolder(view) {

        val textViewNome: TextView = view.findViewById(R.id.edit_text_name)
        val textViewEmail: TextView = view.findViewById(R.id.edit_text_email)
        val textViewPassword: TextView = view.findViewById(R.id.edit_text_password)
        val textViewCidade: TextView = view.findViewById(R.id.edit_text_cidade)
        val textViewDataNasc: TextView = view.findViewById(R.id.edit_text_datebirth)
    }
}