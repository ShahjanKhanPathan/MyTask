package com.example.practicetest.questions

import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.practicetest.R
import com.example.practicetest.base.BaseActivity
import com.example.practicetest.databinding.ActivityImageTestBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.net.URL

class ImageTestActivity : BaseActivity<ActivityImageTestBinding>() {


    override fun getViewBinding() = ActivityImageTestBinding.inflate(layoutInflater)

    override fun initView()  {

        binding.button.setOnClickListener {

            CoroutineScope(Dispatchers.IO).launch {
                val url = URL("https://image.shutterstock.com/image-photo/mountains-during-sunset-beautiful-natural-260nw-407021107.jpg")
                val factory = BitmapFactory.decodeStream(url.openStream())
               withContext(Dispatchers.Main){
                   binding.imageView.setImageBitmap(factory)
               }

            }

        }

        
     }


}
