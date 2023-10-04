package com.example.practicetest.googlesignin

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.lifecycleScope
import com.example.practicetest.MainActivity
import com.example.practicetest.R
import com.example.practicetest.base.BaseActivity
import com.example.practicetest.databinding.ActivityLoginBinding
import com.example.practicetest.map.GoogleMapActivity
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class LoginActivity : BaseActivity<ActivityLoginBinding>() {
    companion object{
        const val RC_SIGN_IN = 100
    }
    private lateinit var mGoogleSignInClient : GoogleSignInClient
    private val TAG = "LOGIN_PAGE"
    private lateinit var mAuth : FirebaseAuth

    override fun getViewBinding() = ActivityLoginBinding.inflate(layoutInflater)

    override fun initView() {
        mAuth = FirebaseAuth.getInstance()

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        binding.btnGoogle.setOnClickListener(myClick)
    }

    private val myClick : View.OnClickListener = View.OnClickListener {id ->
        when(id.id){

            R.id.btnGoogle -> signIn()
        }
    }



    private fun signIn() {
        val signInIntent = mGoogleSignInClient.signInIntent
        myLauncher.launch(signInIntent)
    }

    private val myLauncher =  registerForActivityResult(ActivityResultContracts.StartActivityForResult()){myResult ->
        if (myResult.resultCode == Activity.RESULT_OK){
            val task = GoogleSignIn.getSignedInAccountFromIntent(myResult.data)
            lifecycleScope.launch(Dispatchers.IO) {
            handlerResult(task)
            }
        }
    }

    private suspend fun handlerResult(task: Task<GoogleSignInAccount>) {
        if (task.isSuccessful){
            val account : GoogleSignInAccount? = task.result
            updateUi(account)
        }else{
            showToast(task.exception.toString())
        }
    }

    private fun updateUi(account: GoogleSignInAccount?) {
        val credential = GoogleAuthProvider.getCredential(account?.idToken,null)
        mAuth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful){
                val i = Intent(this,GoogleMapActivity::class.java)
                i.putExtra("name",account?.account)
                i.putExtra("email",account?.email)
                startActivity(i)
            }else{
                showToast(it.exception?.message.toString())
            }
        }
    }


}