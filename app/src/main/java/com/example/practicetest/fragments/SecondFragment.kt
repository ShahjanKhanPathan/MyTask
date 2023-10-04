package com.example.practicetest.fragments

import android.annotation.SuppressLint
import android.os.Bundle
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
import com.example.practicetest.base.NewBaseFragment
import com.example.practicetest.data.NetworkClass
import com.example.practicetest.databinding.FragmentSecondBinding
import com.example.practicetest.viewmodal.MyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SecondFragment : NewBaseFragment<FragmentSecondBinding>(
    FragmentSecondBinding::inflate
) {

     private val viewModel : MyViewModel by viewModels()
    @SuppressLint("ResourceType")


//    override fun getBindTheView() = FragmentSecondBinding.inflate(layoutInflater)!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myToolbar(view)
        makeApiCall()
    }

    private fun makeApiCall() {
        viewModel.getQuestlist()
        viewModel.myQuestions.observe(requireActivity(), Observer {
            binding.progressBar.hideVisibility()

            when(it){

                is NetworkClass.onSuccess ->{
                    binding.apply {
                        questTwo.text = it.data!![1]!!.question
                        radioButtonOneSecondFragment.text = it.data[1]!!.ans1
                        radioButtonTwoSecondFragment.text = it.data[1]!!.ans2

                        btnSubmitSecondFragment.setOnClickListener { item ->
                            txtErrorSecond.showVisibility()
//                            txtErrorSecond.text = it.data[1]!!.correct
                            var myAns = arguments?.getString("myQuest")
                            txtErrorSecond.text = "Previous Question : $myAns "
                        }

                        imageAheadSecond.setOnClickListener {
                            findNavController().navigate(R.id.FragmentSecond_To_FragmentThird)
                        }
                    }
                }

                is NetworkClass.onFailure ->{

                }

                is NetworkClass.onLoading -> binding.progressBar.showVisibility()
            }
        })
    }

    @SuppressLint("ResourceType")
    private fun myToolbar(view: View) {
        val toolbar = view.findViewById<Toolbar>(R.layout.my_toolbar)!!
//        val activity = activity as AppCompatActivity?
//        activity!!.setSupportActionBar(toolbar)
        (activity as AppCompatActivity?)!!.setSupportActionBar(toolbar)

        val title = view.findViewById<TextView>(R.id.txtTitle_toolbar)
        title.text = "Second Page"

        val backArrow = view.findViewById<ImageView>(R.id.imageBack_toolbar)
        backArrow.showVisibility()
        backArrow.setImageDrawable(ContextCompat.getDrawable(requireContext(),R.drawable.ic_back))

        backArrow.setOnClickListener {
            findNavController().navigate(R.id.FragmentSecond_To_OneFragment)
        }


    }

}