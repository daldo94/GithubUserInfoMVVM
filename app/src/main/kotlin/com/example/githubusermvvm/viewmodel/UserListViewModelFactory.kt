package com.example.githubusermvvm.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.githubusermvvm.ui.UserListAdapter

class UserListViewModelFactory(private val userListAdapter: UserListAdapter) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        return UserListViewModel(userListAdapter) as T
    }
}