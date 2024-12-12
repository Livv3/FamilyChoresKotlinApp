package hu.bme.aut.android.familychores

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import hu.bme.aut.android.familychores.`interface`.UserListClickListener
import hu.bme.aut.android.familychores.adapter.UserListAdapter
import hu.bme.aut.android.familychores.data.DataManager
import hu.bme.aut.android.familychores.data.User
import hu.bme.aut.android.familychores.databinding.FragmentMenuBinding


class MenuFragment : Fragment(), UserListClickListener {

    private lateinit var binding: FragmentMenuBinding
    private lateinit var adapter: UserListAdapter
    private lateinit var userArrayList: ArrayList<User>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuBinding.inflate(inflater, container, false)
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(!DataManager.initialized){
            dataInitialize()
            DataManager.initialized = true
        }
        userArrayList = DataManager.users
        val layoutManager = LinearLayoutManager(context)
        binding.rvRecycleView.layoutManager = layoutManager
        binding.rvRecycleView.setHasFixedSize(true)
        adapter = UserListAdapter(userArrayList, this)
        binding.rvRecycleView.adapter = adapter

        binding.addButton.setOnClickListener{
            NewUserItemDialogFragment(adapter).show(
                childFragmentManager,
                NewUserItemDialogFragment.TAG
            )
        }

        binding.diagramButton.setOnClickListener {
            findNavController().navigate(R.id.action_menuFragment_to_barChartFragment)
        }
    }

    private fun dataInitialize(){

        var list1 = ArrayList<String>()
        list1.add("do the dishes")
        list1.add("vacuum")
        list1.add("clean the bathroom")
        list1.add("make dinner")

        var list2 = ArrayList<String>()
        list2.add("clean window")
        list2.add("make coffee")
        list2.add("fold dry clothes")

        var list3 = ArrayList<String>()
        list3.add("do homework")
        list3.add("clean up room")
        list3.add("feed the dog")


        DataManager.users = arrayListOf<User>(

            User(
                getString(R.string.name_1),
                R.drawable.momm,
                list1
            ),

            User(
                getString(R.string.name_2),
                R.drawable.dadd,
                list2
            ),

            User(
                getString(R.string.name_3),
                R.drawable.daughter,
                list3
            )
        )

    }

    override fun onUserListItemClick(view: View, user: User) {
        findNavController().navigate(MenuFragmentDirections.actionMenuFragmentToProfileFragment(user))
    }

}