package com.example.practicetest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.practicetest.base.BaseActivity
import com.example.practicetest.databinding.ActivityMainBinding
import com.example.practicetest.googlesignin.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var mAuth : FirebaseAuth

    override fun initView() {
        mAuth = FirebaseAuth.getInstance()
        val user = mAuth.currentUser
        binding.txtName.text = user?.displayName
        binding.txtEmail.text = user?.email

        binding.btnLogout.setOnClickListener {
            logOut()
        }
    }

    private fun logOut() {
        showToast("Log out successfully")
        mAuth.signOut()
        startActivity(Intent(this,LoginActivity::class.java))
    }

    override fun getViewBinding() = ActivityMainBinding.inflate(layoutInflater)


//    override fun onDestroy() {
//        super.onDestroy()
//        _binding = null
//    }
}