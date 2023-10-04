package com.example.practicetest.base

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.practicetest.R

abstract class BaseFragment<VB : ViewBinding?> : Fragment() {

    private var _binding : VB? = null
    private val binding get() = _binding!!
    @SuppressLint("ResourceType")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        getToolbar(requireView())
        _binding = getBindTheView()
        return binding.root

    }

    abstract fun getToolbar(view: View)


    abstract fun getBindTheView() : VB

    protected fun showToast(message : String){
        Toast.makeText(requireContext(),message,Toast.LENGTH_LONG).show()
    }

    protected fun View.showVisibility(){
        visibility = View.VISIBLE
    }

    protected fun View.hideVisibility(){
        visibility = View.GONE
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}