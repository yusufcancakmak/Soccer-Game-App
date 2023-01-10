package com.footstone22.adapter

import android.annotation.SuppressLint
import android.app.AlertDialog


import android.view.LayoutInflater
import android.view.View

import android.view.ViewGroup
import android.widget.ImageView

import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.footstone22.databinding.CardItemBinding


import com.footstone22.model.FootballItem


class CardAdapter() : RecyclerView.Adapter<CardAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: CardItemBinding) : RecyclerView.ViewHolder(binding.root)

    private lateinit var mydialog: AlertDialog

    private val differutil = object : DiffUtil.ItemCallback<FootballItem>() {
        override fun areItemsTheSame(oldItem: FootballItem, newItem: FootballItem): Boolean {
            return newItem.topPlayers[0].player.id == oldItem.topPlayers[0].player.id

        }

        override fun areContentsTheSame(oldItem: FootballItem, newItem: FootballItem): Boolean {
            return newItem == oldItem
        }


    }
    private val differ = AsyncListDiffer(this, differutil)
    var playerlist: List<FootballItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            CardItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    @SuppressLint("ResourceType", "MissingInflatedId")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentlist = playerlist[position]
        holder.binding.txtName.text = currentlist.topPlayers.get(3).player.name
        holder.binding.txtMatch.text = currentlist.topPlayers.get(3).formattedValue.toString()
        holder.binding.txtMatchOne.text = currentlist.topPlayers[3].matches.toString()
        Glide.with(holder.itemView.context)
            .load("https://api.sofascore.com/api/v1/player/${currentlist.topPlayers.get(3).player.id}/image")
            .into(holder.binding.imageViewPlayer)
        holder.binding.txtName2.text = currentlist.topPlayers.get(6).player.name
        holder.binding.txtMatch2.text = currentlist.topPlayers.get(6).formattedValue.toString()
        holder.binding.txtMatchTwo.text = currentlist.topPlayers[6].matches.toString()
        Glide.with(holder.itemView.context)
            .load("https://api.sofascore.com/api/v1/player/${currentlist.topPlayers.get(6).player.id}/image")
            .into(holder.binding.imageViewPlayer2)
        holder.binding.txtName3.text = currentlist.topPlayers.get(2).player.name
        holder.binding.txtMatchThree3.text = currentlist.topPlayers.get(2).formattedValue.toString()
        holder.binding.txtMatchThree.text = currentlist.topPlayers[2].matches.toString()
        Glide.with(holder.itemView.context)
            .load("https://api.sofascore.com/api/v1/player/${currentlist.topPlayers.get(2).player.id}/image")
            .into(holder.binding.imageViewPlayer3)
    }

    override fun getItemCount() = playerlist.size


}








