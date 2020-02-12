package com.example.githubusermvvm.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusermvvm.BaseActivity
import com.example.githubusermvvm.R
import com.example.githubusermvvm.api.model.Location
import com.example.githubusermvvm.api.model.Name
import com.example.githubusermvvm.api.model.User
import com.example.githubusermvvm.databinding.ActivityMainBinding
import com.example.githubusermvvm.viewmodel.UserListViewModel
import com.example.githubusermvvm.viewmodel.UserListViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class UserListActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutResourceId = R.layout.activity_main

    private lateinit var userListViewModel: UserListViewModel

    private lateinit var userListViewModelFactory: UserListViewModelFactory

    private val _adapter : UserListAdapter = UserListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        userListViewModelFactory = UserListViewModelFactory(_adapter)

        userListViewModel = ViewModelProviders.of(this, userListViewModelFactory)[UserListViewModel::class.java]

        viewDataBinding.viewModel = userListViewModel

        viewDataBinding.lifecycleOwner = this

        main_recyclerView.apply {
            layoutManager = LinearLayoutManager(this@UserListActivity, LinearLayoutManager.VERTICAL, false)
            adapter = _adapter
            setHasFixedSize(true)
        }


        main_btn_add.setOnClickListener { userListViewModel.addData() }



    }
}
