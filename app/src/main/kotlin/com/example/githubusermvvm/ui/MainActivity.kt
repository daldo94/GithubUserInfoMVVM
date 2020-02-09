package com.example.githubusermvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.githubusermvvm.BaseActivity
import com.example.githubusermvvm.R
import com.example.githubusermvvm.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutResourceId = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}
