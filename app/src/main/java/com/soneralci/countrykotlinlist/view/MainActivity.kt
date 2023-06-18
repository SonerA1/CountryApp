package com.soneralci.countrykotlinlist.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.soneralci.countrykotlinlist.R
import com.soneralci.countrykotlinlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


    }

}


