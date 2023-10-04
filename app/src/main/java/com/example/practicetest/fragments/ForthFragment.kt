package com.example.practicetest.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicetest.R
import com.example.practicetest.base.BaseFragment
import com.example.practicetest.base.NewBaseFragment
import com.example.practicetest.databinding.FragmentForthBinding

class ForthFragment : NewBaseFragment<FragmentForthBinding>(
    FragmentForthBinding::inflate
) {

//    override fun getBindTheView() = FragmentForthBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}