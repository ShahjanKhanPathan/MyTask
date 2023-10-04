package com.example.practicetest.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

abstract class NewBaseFragment<VB : ViewBinding>(
    private val bindingInflater: (inflate: LayoutInflater) -> VB
) : Fragment() {

    private var _binding: VB? = null
    val binding: VB
        get() = _binding as VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = bindingInflater.invoke(inflater)
        return binding.root

    }

    protected fun showToast(message : String){
        Toast.makeText(requireContext(),message, Toast.LENGTH_LONG).show()
    }

    fun showSnackBar(view: View, title: String) {
        val mySnack = Snackbar.make(view, title, Snackbar.LENGTH_LONG)
        mySnack.setAction("Dismiss") {
            mySnack.dismiss()
        }
        mySnack.show()
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