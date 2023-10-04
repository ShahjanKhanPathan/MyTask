package com.example.practicetest.mypractice

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.example.practicetest.R

class AFragment : Fragment() {
    private var myText : TextView? = null
    private var myClass = NormalClass()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("My Practice Module","On Attach From Fragment A")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("My Practice Module","On Create From Fragment A")
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       val myView =   inflater.inflate(R.layout.fragment_a, container, false)
        Log.d("My Practice Module","On CreateView From Fragment A")
        myText = myView.findViewById<TextView>(R.id.myTextButton)
        myText?.setOnClickListener(myClicks)
        myClass.setIntents()
        return myView
    }

    private var myClicks : View.OnClickListener = View.OnClickListener { v ->
        when(v?.id){
            R.id.myTextButton -> findNavController().navigate(R.id.Fragment_A_To_Fragment_B)
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("My Practice Module","On ViewCreated From Fragment A")

    }

    override fun onStart() {
        super.onStart()
        Log.d("My Practice Module","On Start From Fragment A")

    }

    override fun onResume() {
        super.onResume()
        Log.d("My Practice Module","On Resume From Fragment A")

    }

    override fun onPause() {
        super.onPause()
        Log.d("My Practice Module","On Pause From Fragment A")

    }

    override fun onStop() {
        super.onStop()
        Log.d("My Practice Module","On Stop From Fragment A")

    }


    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("My Practice Module","On Destroy View From Fragment A")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("My Practice Module","On Destroy From Fragment A")

    }

    override fun onDetach() {
        super.onDetach()
        Log.d("My Practice Module","On Detach From Fragment A")

    }
}