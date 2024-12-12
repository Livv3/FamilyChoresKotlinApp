package hu.bme.aut.android.familychores

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import hu.bme.aut.android.familychores.adapter.UserListAdapter
import hu.bme.aut.android.familychores.databinding.AddPersonBinding

class NewUserItemDialogFragment(private var userAdapter: UserListAdapter) : DialogFragment(){

    private lateinit var binding: AddPersonBinding


    companion object {
        const val TAG = "NewUserItemDialogFragment"
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = AddPersonBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bOk = binding.bOk
        val bCancel = binding.bCancel
        val spinner = binding.spCategory
        var spin = 0
        spinner.adapter = ArrayAdapter(
            requireContext(),
            androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,
            resources.getStringArray(R.array.category_items)
        )
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, Id: Long) {
                spin = pos
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

        }
        bOk.setOnClickListener{
            if(isValid()){
                val name = getNewItem()
                userAdapter.addUser(name, spin)
                dismiss()
            }
        }
        bCancel.setOnClickListener{
            dismiss()
        }

    }

    private fun isValid() = binding.etUser.text.isNotEmpty()

    private fun getNewItem() = binding.etUser.text.toString()


}