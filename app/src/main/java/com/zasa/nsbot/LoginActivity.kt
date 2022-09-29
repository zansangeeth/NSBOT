package com.zasa.nsbot

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    //google client
    private lateinit var googleSignInClient: GoogleSignInClient

    //firebase auth
    private lateinit var firebaseAuth: FirebaseAuth

    //constants
    private companion object {
        private const val RC_SIGN_IN = 100
        private const val TAG = "GOOGLE_SIGN_IN_TAG"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //configure google sign in
        val googleSignInOptions = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()
        googleSignInClient = GoogleSignIn.getClient(this, googleSignInOptions)

        //init firebase auth
        firebaseAuth = FirebaseAuth.getInstance()
        checkUser()

        //Google sign in button to begin google sign in
        btnGoogleSignIn.setOnClickListener {
            Log.i(TAG, "onCreate : begin google sign in")
            val intent = googleSignInClient.signInIntent
            startActivityForResult(intent, RC_SIGN_IN)

        }
    }

    private fun checkUser() {

        //check if user is logged in or not
        val firebaseUser = firebaseAuth.currentUser
        if (firebaseUser != null) {
            // user is already logged in
            // start main activity
            //starts profile activity
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        //results return from launching the intent from GoogleSignInApi.getSignInIntent
        if (requestCode == RC_SIGN_IN) {
            Log.i(TAG, "onActivityResult : Google Sign in intent result")
            val accountTask = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {

                //google sign in success
                val account = accountTask.getResult(ApiException::class.java)
                firebaseAuthWithGoogleAccount(account)

            } catch (e: Exception) {

                //failed google sign in
                Log.i(TAG, "onActivityResult : ${e.message}")

            }
        }
    }

    private fun firebaseAuthWithGoogleAccount(account: GoogleSignInAccount?) {

        Log.i(TAG, "firebaseAuthWithGoogleAccount : begin firebase auth with google account")

        val credentials = GoogleAuthProvider.getCredential(account!!.idToken, null)

        firebaseAuth.signInWithCredential(credentials)
            .addOnSuccessListener { authResults ->
                //login success
                Log.i(TAG, "firebaseAuthWithGoogleAccount : LoggedIn")

                //get logged in user
                val firebaseUser = firebaseAuth.currentUser

                //get user info
                val uid = firebaseUser!!.uid
                val email = firebaseUser.email

                Log.i(TAG, "firebaseAuthWithGoogleAccount : uid: $uid")
                Log.i(TAG, "firebaseAuthWithGoogleAccount : uid: $email")

                //check if id now or existing
                if (authResults.additionalUserInfo!!.isNewUser) {
                    //user is new now
                    Log.i(TAG, "firebaseAuthWithGoogleAccount : account created : \n$email")
                    Toast.makeText(this, "Account Created \n$email", Toast.LENGTH_SHORT).show()
                } else {
                    //existing user
                    Log.i(TAG, "firebaseAuthWithGoogleAccount : existing user : \n$email")
                    Toast.makeText(this, "Logged in \n$email", Toast.LENGTH_SHORT).show()
                }

                //starts profile activity
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
            .addOnFailureListener { e ->
                Log.i(TAG, "firebaseAuthWithGoogleAccount : Logged in failed due to ${e.message}")
                Toast.makeText(this, "Logged in failed due to ${e.message}", Toast.LENGTH_SHORT)
                    .show()
            }
    }

}