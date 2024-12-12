package hu.bme.aut.android.familychores

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.navigation.NavArgs
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import hu.bme.aut.android.familychores.`interface`.NewTodoItemDialogListener
import hu.bme.aut.android.familychores.`interface`.TodoListener
import hu.bme.aut.android.familychores.adapter.ToDoListAdapter
import hu.bme.aut.android.familychores.data.User
import hu.bme.aut.android.familychores.databinding.FragmentProfileBinding
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size

class ProfileFragment : Fragment(), TodoListener, NewTodoItemDialogListener {

    private lateinit var binding: FragmentProfileBinding
    private lateinit var user: User
    private lateinit var adapter: ToDoListAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        binding = FragmentProfileBinding.inflate(inflater, container, false)
        if(arguments!=null){
            val args: ProfileFragmentArgs by navArgs()
            user = args.user
        }
        return binding.root;
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(context)
        binding.rvRecycleView.layoutManager = layoutManager
        binding.rvRecycleView.setHasFixedSize(true)
        adapter = ToDoListAdapter(user, this)
        binding.rvRecycleView.adapter = adapter

        binding.fab.setOnClickListener {
            NewTodoItemDialogFragment(adapter).show(
                childFragmentManager,
                NewTodoItemDialogFragment.TAG

            )

        }
    }


    override fun onItemChanged() {
        binding.viewKonfetti.build()
            .addColors(Color.CYAN, Color.YELLOW, Color.MAGENTA, Color.GREEN)
            .setDirection(0.0, 360.0)
            .setSpeed(5f, 8f)
            .setFadeOutEnabled(true)
            .setTimeToLive(300L)
            .addShapes(Shape.Circle, Shape.Square)
            .addSizes(Size(13))
            .setPosition(-50f, binding.viewKonfetti.width+50f, -50f, binding.viewKonfetti.width+50f)
            .streamFor(300, 1300L)
    }

    override fun onTodoItemCreated(newItem: String) {
        adapter.addTodo(newItem)
    }




}