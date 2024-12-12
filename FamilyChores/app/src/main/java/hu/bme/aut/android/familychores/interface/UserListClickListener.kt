package hu.bme.aut.android.familychores.`interface`

import android.view.View
import hu.bme.aut.android.familychores.data.User

interface UserListClickListener {
    fun onUserListItemClick(view: View, user: User)
}
interface TodoListener {
    fun onItemChanged()
}

interface NewTodoItemDialogListener {
    fun onTodoItemCreated(newItem: String)
}