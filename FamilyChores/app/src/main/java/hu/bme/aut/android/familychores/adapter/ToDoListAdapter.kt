package hu.bme.aut.android.familychores.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import hu.bme.aut.android.familychores.`interface`.TodoListener
import hu.bme.aut.android.familychores.data.User
import hu.bme.aut.android.familychores.databinding.TodoItemBinding

class ToDoListAdapter(var user: User, val listener: TodoListener):
    RecyclerView.Adapter<ToDoListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        TodoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = user.toDoList[position]
        holder.binding.cbTodo.text = currentItem
        holder.binding.cbTodo.setOnCheckedChangeListener { buttonView, isChecked ->
            listener.onItemChanged()
        }
    }

    override fun getItemCount(): Int {
        return user.toDoList.size
    }

    fun addTodo(todo: String){
        user.toDoList.add(todo)
        notifyItemInserted(user.toDoList.size - 1)
    }

    inner class ViewHolder(val binding: TodoItemBinding) : RecyclerView.ViewHolder(binding.root)
}