package com.example.practicetest.mypractice

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicetest.R

class BFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("My Practice Module","On Create From Fragment B")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val myView =inflater.inflate(R.layout.fragment_b, container, false)
        Log.d("My Practice Module","On CreateView From Fragment B")
        return myView
    }



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("My Practice Module","On ViewCreated From Fragment B")

    }

    override fun onStart() {
        super.onStart()
        Log.d("My Practice Module","On Start From Fragment B")

    }

    override fun onResume() {
        super.onResume()
        Log.d("My Practice Module","On Resume From Fragment B")

    }

    override fun onPause() {
        super.onPause()
        Log.d("My Practice Module","On Pause From Fragment B")

    }

    override fun onStop() {
        super.onStop()
        Log.d("My Practice Module","On onStop From Fragment B")

    }


    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("My Practice Module","On Destroy View From Fragment B")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("My Practice Module","On Destroy From Fragment B")

    }

    override fun onDetach() {
        super.onDetach()
        Log.d("My Practice Module","On Detach From Fragment B")

    }

}