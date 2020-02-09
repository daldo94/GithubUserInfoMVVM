package com.example.githubusermvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.example.githubusermvvm.BaseActivity
import com.example.githubusermvvm.R
import com.example.githubusermvvm.api.model.User
import com.example.githubusermvvm.databinding.ActivityMainBinding
import com.example.githubusermvvm.viewmodel.UserListViewModel
import com.example.githubusermvvm.viewmodel.UserListViewModelFactory

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutResourceId = R.layout.activity_main

    private lateinit var userListViewModel: UserListViewModel

    private lateinit var userListViewModelFactory: UserListViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userListViewModelFactory = UserListViewModelFactory()

        userListViewModel = ViewModelProviders.of(this, userListViewModelFactory)[UserListViewModel::class.java]



    }
}
