package com.videumcorp.kotlinlifecycleexample.view

import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.videumcorp.kotlinlifecycleexample.R
import com.videumcorp.kotlinlifecycleexample.databinding.ActivityMainBinding
import com.videumcorp.kotlinlifecycleexample.viewmodel.UserViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)

        val userViewmodel = ViewModelProviders.of(this).get(UserViewModel::class.java)

        binding.userViewModel = userViewmodel

        button.setOnClickListener {
            userViewmodel.readUserFromEditText(editText.text.toString())
        }
    }
}
