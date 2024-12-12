package hu.bme.aut.android.familychores.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.android.familychores.R
import hu.bme.aut.android.familychores.`interface`.UserListClickListener
import hu.bme.aut.android.familychores.data.User
import hu.bme.aut.android.familychores.databinding.UserItemBinding

class UserListAdapter (var userlist: ArrayList<User>, val userListClickListener: UserListClickListener):
    RecyclerView.Adapter<UserListAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        UserItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val userItem = userlist[position]
        holder.binding.ivUserImage.setImageResource(userItem.image)
        holder.binding.tvUserName.text = userItem.name
        holder.binding.root.setOnClickListener{
            userListClickListener.onUserListItemClick(it, userlist[position])
        }

    }

    override fun getItemCount(): Int {
        return userlist.size
    }

    fun addUser(name: String, pic: Int){
        var list = ArrayList<String>()

        var profile = 0
        if(pic==0){
            profile = R.drawable.momm
        }
        if(pic==1){
            profile = R.drawable.dadd
        }
        if(pic==2){
            profile = R.drawable.boyy
        }
        if(pic==3){
            profile = R.drawable.daughter
        }
        if(pic==4){
            profile = R.drawable.dogg
        }
        if(pic==5){
            profile = R.drawable.person
        }
        if(pic==6){
            profile = R.drawable.alien
        }
        if(pic==7){
            profile = R.drawable.pingu
        }

        userlist.add(
            User(
                name,
                profile,
                list
            )
        )
    }

    inner class ViewHolder(val binding: UserItemBinding): RecyclerView.ViewHolder(binding.root)
}