package hu.bme.aut.android.familychores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import hu.bme.aut.android.familychores.adapter.ToDoListAdapter
import hu.bme.aut.android.familychores.databinding.AddTodoBinding

class NewTodoItemDialogFragment(var adapter: ToDoListAdapter) : DialogFragment(){

    private lateinit var binding: AddTodoBinding

    companion object {
        const val TAG = "NewItemDialogFragment"
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = AddTodoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bOk = binding.bOk
        val bCancel = binding.bCancel
        bOk.setOnClickListener{
            if(isValid()){
                val item = getNewItem()
                adapter.addTodo(item)
                dismiss()
            }
        }
        bCancel.setOnClickListener{
            dismiss()
        }

    }

    private fun isValid() = binding.etTodo.text.isNotEmpty()

    private fun getNewItem() = binding.etTodo.text.toString()


}