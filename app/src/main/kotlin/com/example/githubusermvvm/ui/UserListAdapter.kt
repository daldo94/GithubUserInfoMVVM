package com.example.githubusermvvm.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.githubusermvvm.R
import com.example.githubusermvvm.api.model.User
import com.example.githubusermvvm.databinding.ActivityMainBinding
import com.example.githubusermvvm.databinding.ItemUserBinding
import kotlinx.android.synthetic.main.item_user.view.*

class UserListAdapter() : RecyclerView.Adapter<UserListAdapter.ViewHolder>()  {
    private var items: List<User> = listOf()
    inner class ViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent, false)
        val viewHolder = ViewHolder(ItemUserBinding.bind(view))
        return viewHolder
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.user = items[position]
    }

    fun setItems(items : List<User>){
        this.items = items
        Log.d("GithubUserMVVM","${this.items.toString()}")
        notifyDataSetChanged()
    }
}