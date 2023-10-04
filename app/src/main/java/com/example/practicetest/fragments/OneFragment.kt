package com.example.practicetest.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.practicetest.R
import com.example.practicetest.base.BaseFragment
import com.example.practicetest.base.NewBaseFragment
import com.example.practicetest.data.NetworkClass
import com.example.practicetest.databinding.FragmentOneBinding
import com.example.practicetest.viewmodal.MyViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.lang.NullPointerException

@AndroidEntryPoint
class OneFragment : NewBaseFragment<FragmentOneBinding>(
    FragmentOneBinding::inflate
) {

    private val viewModel: MyViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        makeApiCall()
        myToolbar(view)
    }

    @SuppressLint("ResourceType")
    private fun myToolbar(view: View) {
        try {
            val toolbar = view.findViewById<Toolbar>(R.layout.my_toolbar)!!
            val activity = activity as AppCompatActivity?
            activity!!.setSupportActionBar(toolbar)
            val title = requireActivity().findViewById<TextView>(R.id.txtTitle_toolbar)
            title.text = getString(R.string.first_page)
        } catch (e: NullPointerException) {
            Log.d("checkToolbar", e.message.toString())
        }

    }

    private fun makeApiCall() {
        viewModel.getQuestlist()
        viewModel.myQuestions.observe(requireActivity(), Observer { item ->
            binding.progressBar.hideVisibility()
            when (item) {

                is NetworkClass.onSuccess -> {

                    binding.apply {
                        textView.text = item.data?.get(0)?.question
                        radioButtonOne.text = item.data?.get(0)?.ans1
                        radioButtonTwo.text = item.data?.get(0)?.ans2

                        btnSubmit.setOnClickListener {
                            txtError.showVisibility()
                            txtError.text = item.data?.get(0)?.correct
                        }

                        imageAhead.setOnClickListener {
                            val bundle = Bundle()
                            bundle.putString("myQuest", item.data?.get(5)?.question)
                            findNavController().navigate(R.id.OneFragment_To_FragmentSecond)
                        }
                    }


                }

                is NetworkClass.onFailure -> Log.d("on Error", item.message!!)

                is NetworkClass.onLoading -> {
                    binding.progressBar.showVisibility()
                }
            }
        })
    }

    override fun onResume() {
        super.onResume()
        Log.d("OnResume", "From Fragment")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("OnDestroy", "From Fragment")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("OnDetach", "From Fragment")
    }


}