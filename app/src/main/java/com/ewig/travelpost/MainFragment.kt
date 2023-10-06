package com.ewig.travelpost

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.ewig.travelpost.databinding.FragmentMainBinding
import com.ewig.travelpost.databinding.LogInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    private  var _binding: FragmentMainBinding?=null
    private val binding get() = _binding!!

    private lateinit var auth: FirebaseAuth


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentMainBinding.inflate(inflater,container,false)
        val view= binding.root
        auth= Firebase.auth
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val addpost = binding.addpost
        addpost.setOnClickListener {
            val action= MainFragmentDirections.actionMainFragment2ToAddPost()
            Navigation.findNavController(addpost).navigate(action)
        }

        val abmelden=binding.abmelden
        abmelden.setOnClickListener{
            auth.signOut()
            val action = MainFragmentDirections.actionMainFragment2ToFragmentLogIn2()
            Navigation.findNavController(abmelden).navigate(action)
        }
    }


    }