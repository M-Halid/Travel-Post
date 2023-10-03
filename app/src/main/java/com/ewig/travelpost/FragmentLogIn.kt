package com.ewig.travelpost

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.ewig.travelpost.databinding.LogInBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class FragmentLogIn : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    private  var _binding: LogInBinding?=null
    private val binding get() = _binding!!

    private lateinit var auth:FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=LogInBinding.inflate(inflater,container,false)
        val view= binding.root
        auth= Firebase.auth
        val currentUser=auth.currentUser
        if (currentUser!=null){
            val action=FragmentLogInDirections.actionFragmentLogIn2ToMainFragment2()
            findNavController().navigate(action)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val logEmail=binding.logEmail.text
        val logPassword=binding.logPassword.text
        val logIn=binding.logInButton


        logIn.setOnClickListener {
            if(logEmail.isEmpty() || logPassword.isEmpty()){
                Toast.makeText(getContext(),"Enter email and password!", Toast.LENGTH_SHORT).show()
            }else{
            auth.signInWithEmailAndPassword(logEmail.toString(),logPassword.toString()).addOnSuccessListener {
               val action = FragmentLogInDirections.actionFragmentLogIn2ToMainFragment2()
                Navigation.findNavController(logIn).navigate(action)
            }.addOnFailureListener{
                Toast.makeText(getContext(), it.localizedMessage, Toast.LENGTH_LONG).show()
            }
            }
        }

        val signUp=binding.signUpButton
        signUp.setOnClickListener {
            val action=FragmentLogInDirections.actionFragmentLogIn2ToFragmentSignUp()
            Navigation.findNavController(it).navigate(action)
          /*  val action = FragmentLogInDirections.actionLogInToSignUp()
            Navigation.findNavController(it).navigate(action)*/
        }
        val forgotText=binding.forgotText
        forgotText.setOnClickListener {
           /* val action = FragmentLogInDirections.actionLogInToSignUp()
            Navigation.findNavController(it).navigate(action)*/ }

    }
}
