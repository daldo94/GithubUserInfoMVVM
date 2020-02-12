package com.example.githubusermvvm.utils

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusermvvm.api.model.User
import com.example.githubusermvvm.ui.UserListAdapter

/*
@BindingAdapter("bind_items")
fun setBindItems(view : RecyclerView, items : List<User>){
    val adapter = view.adapter as? UserListAdapter ?: UserListAdapter().apply { view.adapter = this }
    adapter.items = items
    adapter.notifyDataSetChanged()
}
*/