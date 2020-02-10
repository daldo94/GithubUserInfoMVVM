package com.example.githubusermvvm.utils

import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusermvvm.api.model.User
import com.example.githubusermvvm.ui.UserListAdapter


@BindingAdapter("bind_items")
fun setBindItems(view : RecyclerView, items : List<User>){
    val adapter : UserListAdapter = view.adapter as UserListAdapter
    adapter.setItems(items)
    adapter.notifyDataSetChanged()

}
