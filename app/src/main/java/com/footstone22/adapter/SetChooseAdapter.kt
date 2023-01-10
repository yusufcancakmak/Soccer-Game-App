package com.footstone22.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.footstone22.databinding.MyCollectionsBinding

import com.footstone22.model.LocalFootbalItem

class SetChooseAdapter():RecyclerView.Adapter<SetChooseAdapter.MyHolder>() {
    inner class MyHolder(val binding: MyCollectionsBinding):RecyclerView.ViewHolder(binding.root)
    override fun getItemCount()=favoritesListt.size
    var indexthose:Int=0
    private var onClick: (item: LocalFootbalItem, index:Int, index2:Int) -> Unit = { localFootbalItem: LocalFootbalItem, i: Int , index2-> }
    fun setOnClickListener(listener: (item: LocalFootbalItem, index:Int, index2:Int) -> Unit) {
        onClick = listener


    }
    private val differutill=object : DiffUtil.ItemCallback<List<LocalFootbalItem>>(){
        override fun areItemsTheSame(oldItem: List<LocalFootbalItem>, newItem: List<LocalFootbalItem>): Boolean {
            return newItem.get(0).id==oldItem.get(0).id
        }

        override fun areContentsTheSame(oldItem: List<LocalFootbalItem>, newItem: List<LocalFootbalItem>): Boolean {
            return newItem==oldItem
        }

    }

    private val diffeer= AsyncListDiffer(this,differutill)
    var favoritesListt:List<List<LocalFootbalItem>>
        get() = diffeer.currentList
        set(value){
            diffeer.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        return MyHolder(MyCollectionsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val setchooselist = favoritesListt[position]
        try {
            holder.binding.txtFavName.text = setchooselist.get(0).name
            holder.binding.txtMatchFav.text = setchooselist.get(0).matches.toString()
            holder.binding.txtMatchFav2.text = setchooselist.get(0).formattedValue
            Glide.with(holder.itemView).load(setchooselist.get(0).imageviewurl)
                .into(holder.binding.imageViewPlayerFav)
            holder.binding.yellowCardFavOne.setOnClickListener {
                onClick(setchooselist.get(0), indexthose,0+position)
            }
            holder.binding.txtNameFav2.text = setchooselist.get(1).name.toString()
            holder.binding.txtMatchFav4.text = setchooselist.get(1).matches.toString()
            holder.binding.txtMatchFav5.text = setchooselist.get(1).formattedValue.toString()
            Glide.with(holder.itemView).load(setchooselist.get(1).imageviewurl)
                .into(holder.binding.imageViewPlayerFav2)
            holder.binding.greenCardFavTwo.setOnClickListener {
                onClick(setchooselist.get(1), indexthose,1+position)
            }
            holder.binding.txtNameFav3.text = setchooselist.get(2).name.toString()
            holder.binding.txtMatchFav7.text = setchooselist.get(2).matches.toString()
            holder.binding.txtMatchFav8.text = setchooselist.get(2).formattedValue.toString()
            Glide.with(holder.itemView).load(setchooselist.get(2).imageviewurl)
                .into(holder.binding.imageViewPlayerFav3)
            holder.binding.blueCardFavThree.setOnClickListener {
                onClick(setchooselist.get(2), indexthose,2+position)
            }

        } catch (e:java.lang.Exception) {

        }

    }


}