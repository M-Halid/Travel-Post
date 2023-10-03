package com.ewig.travelpost

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.ewig.travelpost.databinding.SignUpBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class FragmentSignUp : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private var _binding: SignUpBinding?=null
    private val binding get() = _binding!!
    private lateinit var auth:FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=SignUpBinding.inflate(inflater,container,false)
        val view=binding.root
        auth=Firebase.auth
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val signName=binding.signName.text
        val signEmail = binding.signEmail.text
        val signPassword = binding.signPassword.text
        val signedUp=binding.signedUpButton

        signedUp.setOnClickListener {
           if(signName.isEmpty() || signEmail.isEmpty() || signPassword.isEmpty()){
                Toast.makeText(getContext(),"Enter email and password!",Toast.LENGTH_SHORT).show()
            }else{
                auth.createUserWithEmailAndPassword(signEmail.toString(),signPassword.toString()).addOnSuccessListener {

                  /*  val action=FragmentSignUpDirections.actionFragmentSignUpToMainFragment()
                    Navigation.findNavController(signedUp).navigate(action)*/
                }.addOnFailureListener {
                    Toast.makeText(getContext(), it.localizedMessage, Toast.LENGTH_LONG).show()
                }
            }
        }

    }
}


