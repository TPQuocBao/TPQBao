package com.example.roomapp.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.roomapp.R
import com.example.roomapp.data.User
import com.example.roomapp.data.UserViewModel
import com.example.roomapp.databinding.FragmentAddBinding


class AddFragment : Fragment() {
    private var _binding: FragmentAddBinding? = null
    private val binding get() =  _binding!!

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAddBinding.inflate(inflater, container, false)

        mUserViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        binding.addBtn.setOnClickListener{
            insertDatatoDatabase()
        }

        return binding.root
    }

    private fun insertDatatoDatabase() {
        val firstName = binding.addFnId.text.toString()
        val lastName = binding.addLnId.text.toString()
        val age = binding.addAgeID.text

        if (inputCheck(firstName, lastName, age)){
            // Create User Object
            val user = User(0, firstName, lastName, Integer.parseInt(age.toString()))
            //Add Data to Database
            mUserViewModel.addUser(user)
            Toast.makeText(requireContext(), "Successfully added !", Toast.LENGTH_LONG).show()
            //Navigate Back
            findNavController().navigate(R.id.action_addFragment_to_listFragment)
        }else{
            Toast.makeText(requireContext(), "Please fill out all fields!", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(firstName: String, lastName: String, age: Editable): Boolean{
        return!(TextUtils.isEmpty(firstName) && TextUtils.isEmpty(lastName) && age.isEmpty())
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}