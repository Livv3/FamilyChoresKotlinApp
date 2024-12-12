package hu.bme.aut.android.familychores.data


data class User(
    val name: String,
    val image: Int,
    var toDoList: ArrayList<String> = ArrayList()
    ): java.io.Serializable
