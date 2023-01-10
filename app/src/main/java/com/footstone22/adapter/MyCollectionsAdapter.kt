package com.footstone22.adapter

import android.app.AlertDialog
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.footstone22.R
import com.footstone22.databinding.MyCollectionsBinding

import com.footstone22.model.FootballItem
import com.footstone22.model.LocalFootbalItem
import com.footstone22.model.Player

class MyCollectionsAdapter():RecyclerView.Adapter<MyCollectionsAdapter.MyvievHolder>() {
    inner class MyvievHolder(val binding: MyCollectionsBinding):RecyclerView.ViewHolder(binding.root)

    private val differutil=object :DiffUtil.ItemCallback<List<LocalFootbalItem>>(){
        override fun areItemsTheSame(oldItem: List<LocalFootbalItem>, newItem: List<LocalFootbalItem>): Boolean {
           return newItem.get(0).id==oldItem.get(0).id
        }

        override fun areContentsTheSame(oldItem: List<LocalFootbalItem>, newItem: List<LocalFootbalItem>): Boolean {
            return newItem==oldItem
        }

    }
    private val differ= AsyncListDiffer(this,differutil)
    var favoritesList:List<List<LocalFootbalItem>>
        get() = differ.currentList
        set(value){
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyvievHolder {
        return MyvievHolder(MyCollectionsBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MyvievHolder, position: Int) {
        val currentlist=favoritesList[position]
        try {
            holder.binding.txtFavName.text=currentlist.get(0).name
            holder.binding.txtMatchFav.text=currentlist.get(0).matches.toString()
            holder.binding.txtMatchFav2.text=currentlist.get(0).formattedValue
            Glide.with(holder.itemView).load(currentlist.get(0).imageviewurl).into(holder.binding.imageViewPlayerFav)

            holder.binding.txtNameFav2.text=currentlist.get(1).name.toString()
            holder.binding.txtMatchFav4.text=currentlist.get(1).matches.toString()
            holder.binding.txtMatchFav5.text=currentlist.get(1).formattedValue.toString()
            Glide.with(holder.itemView).load(currentlist.get(1).imageviewurl).into(holder.binding.imageViewPlayerFav2)

            holder.binding.txtNameFav3.text=currentlist.get(2).name.toString()
            holder.binding.txtMatchFav7.text=currentlist.get(2).matches.toString()
            holder.binding.txtMatchFav8.text=currentlist.get(2).formattedValue.toString()
            Glide.with(holder.itemView).load(currentlist.get(2).imageviewurl).into(holder.binding.imageViewPlayerFav3)

            holder.binding.yellowCardFavOne.setOnClickListener {
                val builder = AlertDialog.Builder(it.rootView.context)
                val dialogView = LayoutInflater.from(it.rootView.context).inflate(R.layout.popup, null)
                val aletdialog=builder.create()
                val txt_name = dialogView.findViewById<TextView>(R.id.txt_name_popup)
                val txt_match = dialogView.findViewById<TextView>(R.id.txt_match_popup)
                val tx_format = dialogView.findViewById<TextView>(R.id.txt_forth_popup)
                val popup_close_image = dialogView.findViewById<ImageView>(R.id.popup_close)
                val image_popup =
                    dialogView.findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.imageview_popup)
                txt_name.text = currentlist.get(0).name
                txt_match.text = currentlist.get(0).matches.toString()
                tx_format.text = currentlist.get(0).formattedValue.toString()
                Glide.with(it.rootView.context)
                    .load(currentlist.get(0).imageviewurl)
                    .into(image_popup)
                aletdialog.setView(dialogView)
                aletdialog.setCancelable(true)
                aletdialog.show()

                popup_close_image.setOnClickListener {
                    aletdialog.dismiss()
                }
            }

            holder.binding.greenCardFavTwo.setOnClickListener {
                val builder = AlertDialog.Builder(it.rootView.context)
                val dialogView = LayoutInflater.from(it.rootView.context).inflate(R.layout.popup_green, null)
                val aletdialog=builder.create()
                val txt_name = dialogView.findViewById<TextView>(R.id.txt_name_popup_green)
                val txt_match = dialogView.findViewById<TextView>(R.id.txt_match_popup_green)
                val tx_format = dialogView.findViewById<TextView>(R.id.txt_forth_popup_green)
                val popup_close_image = dialogView.findViewById<ImageView>(R.id.popup_close_green)
                val image_popup =
                    dialogView.findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.imageview_popup_green)
                txt_name.text = currentlist.get(1).name
                txt_match.text = currentlist.get(1).matches.toString()
                tx_format.text = currentlist.get(1).formattedValue.toString()
                Glide.with(it.rootView.context)
                    .load(currentlist.get(1).imageviewurl)
                    .into(image_popup)
                aletdialog.setView(dialogView)
                aletdialog.setCancelable(true)
                aletdialog.show()

                popup_close_image.setOnClickListener {
                    aletdialog.dismiss()
                }
            }

            holder.binding.blueCardFavThree.setOnClickListener {
                val builder = AlertDialog.Builder(it.rootView.context)
                val dialogView = LayoutInflater.from(it.rootView.context).inflate(R.layout.popup_blue, null)
                val aletdialog=builder.create()
                val txt_name = dialogView.findViewById<TextView>(R.id.txt_name_popup_blue)
                val txt_match = dialogView.findViewById<TextView>(R.id.txt_match_popup_blue)
                val tx_format = dialogView.findViewById<TextView>(R.id.txt_forth_popup_blue)
                val popup_close_image = dialogView.findViewById<ImageView>(R.id.popup_close_blue)
                val image_popup =
                    dialogView.findViewById<de.hdodenhof.circleimageview.CircleImageView>(R.id.imageview_popup_blue)
                txt_name.text = currentlist.get(2).name
                txt_match.text = currentlist.get(2).matches.toString()
                tx_format.text = currentlist.get(2).formattedValue.toString()
                Glide.with(it.rootView.context)
                    .load(currentlist.get(2).imageviewurl)
                    .into(image_popup)
                aletdialog.setView(dialogView)
                aletdialog.setCancelable(true)
                aletdialog.show()

                popup_close_image.setOnClickListener {
                    aletdialog.dismiss()
                }
            }



        }catch (e:java.lang.Exception){


        }

    }

    override fun getItemCount()=favoritesList.size
}