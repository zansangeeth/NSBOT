package com.zasa.nsbot

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.zasa.nsbot.databinding.FragmentSettingBinding
import kotlinx.android.synthetic.main.fragment_setting.*


class Setting : Fragment() {

    //firebase auth
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // user logged in
        val firebaseUser = firebaseAuth.currentUser
        // get user info
        val email = firebaseUser!!.email
        tvEmail.text = email

        //handle click logout user
        btnLogout.setOnClickListener {
            firebaseAuth.signOut()
            checkUser()
        }
    }

    fun checkUser() {
        //get current user
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser == null) {
            // user not logged in
            startActivity(Intent(requireContext().applicationContext, LoginActivity::class.java))
            activity?.finish()
        } else {

        }
    }


}