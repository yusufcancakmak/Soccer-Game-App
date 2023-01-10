package com.footstone22

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import androidx.activity.viewModels
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.footstone22.adapter.CardAdapter
import com.footstone22.adapter.SetChooseAdapter
import com.footstone22.databinding.ActivityCraftBinding

import com.footstone22.model.LocalFootbalItem
import com.footstone22.utils.CraftHelper
import com.footstone22.viewmodel.FootballPlayerViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CraftActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCraftBinding
    private lateinit var setChooseAdapter: SetChooseAdapter
    private lateinit var cardAdapter: CardAdapter
    private var savecard = mutableListOf<LocalFootbalItem>()
    private val viewmodelll: FootballPlayerViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCraftBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setChooseAdapter = SetChooseAdapter()
        cardAdapter = CardAdapter()
        getselectitem()
        startGetItem()

        binding.homeImage.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()


        }


    }

    @SuppressLint("MissingInflatedId")
    private fun getselectitem() {
        val builder = AlertDialog.Builder(this)
        val diaologView = LayoutInflater.from(this)
            .inflate(R.layout.popup_choose_card, null, false)
        val cancel = diaologView.findViewById<ImageView>(R.id.choose_close)
        val recyclerview_choose =
            diaologView.findViewById<RecyclerView>(R.id.recycler_view_choose)
        val alerDialogg = builder.create()
        alerDialogg.setView(diaologView)
        cancel.setOnClickListener {
            alerDialogg.dismiss()
        }
        binding.chooseSelect.setOnClickListener {
            alerDialogg.dismiss()

            recyclerview_choose.apply {
                layoutManager = LinearLayoutManager(it.rootView.context)
                adapter = setChooseAdapter


            }
            setChooseAdapter.indexthose = 0

            lifecycleScope.launchWhenStarted {
                viewmodelll.getSavedPlayer().collect { data ->
                    setChooseAdapter.favoritesListt = data.chunked(3)
                }
            }

            alerDialogg.show()


        }




        binding.chooseSelectTwo.setOnClickListener {
            alerDialogg.dismiss()
            val recyclerview_choose =
                diaologView.findViewById<RecyclerView>(R.id.recycler_view_choose)
            val cons = diaologView.findViewById<ConstraintLayout>(R.id.popup_choose_cons)


            recyclerview_choose.apply {
                layoutManager = LinearLayoutManager(it.rootView.context)
                adapter = setChooseAdapter
            }
            setChooseAdapter.indexthose = 1
            lifecycleScope.launchWhenStarted {
                viewmodelll.getSavedPlayer().collect { data ->
                    setChooseAdapter.favoritesListt = data.chunked(3)
                }
            }


            alerDialogg.show()


        }


        setChooseAdapter.setOnClickListener { item, index, index2 ->
            if (CraftHelper.selectedNumberList.contains(index2))
                return@setOnClickListener
            CraftHelper.selectedNumberList.add(index2)
            alerDialogg.dismiss()

            when (index) {
                0 -> {
                    binding.imageChoseYellowcard.visibility = View.VISIBLE
                    binding.txtChooseName.visibility = View.VISIBLE
                    binding.txtChooseMatch.visibility = View.VISIBLE
                    binding.txtChooseFord.visibility = View.VISIBLE
                    binding.txtChooseStar.visibility = View.VISIBLE
                    binding.imageviewChooseOne.visibility = View.VISIBLE
                    binding.txtChooseName.text = item.name.toString()
                    binding.txtChooseMatch.text = item.matches.toString()
                    binding.txtChooseFord.text = item.formattedValue.toString()
                    Glide.with(this).load(item.imageviewurl).into(binding.imageviewChooseOne)
                }
                1 -> {
                    binding.imageChooseBlue.visibility = View.VISIBLE
                    binding.txtChooseNameTwo.visibility = View.VISIBLE
                    binding.txtChooseMatchTwo.visibility = View.VISIBLE
                    binding.txtChooseFordTwo.visibility = View.VISIBLE
                    binding.txtChooseStarTwo.visibility = View.VISIBLE
                    binding.imageviewChooseTwo.visibility = View.VISIBLE
                    binding.txtChooseName.text = item.name.toString()
                    binding.txtChooseMatch.text = item.matches.toString()
                    binding.txtChooseFord.text = item.formattedValue.toString()
                    Glide.with(this).load(item.imageviewurl).into(binding.imageviewChooseTwo)

                }

            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        CraftHelper.clear()
    }

    private fun startGetItem() {

        binding.startItem.setOnClickListener {
            binding.apply {
                chooseImageGreen.visibility = View.VISIBLE
                txtChooseNameTwoRandom.visibility = View.VISIBLE
                txtChooseMatchTwoRandom.visibility = View.VISIBLE
                txtChooseFordRandom.visibility = View.VISIBLE
                txtChooseStarTwoRandom.visibility = View.VISIBLE
                randomImageviewCardChoose.visibility = View.VISIBLE


            }
            viewmodelll.getallplayerviewModel()
            viewmodelll.getfootballist.observe(this, Observer { data ->
                data.get(1).topPlayers.shuffled().take(1).forEachIndexed { index, topPlayer ->
                    savecard.add(
                        LocalFootbalItem(
                            name = topPlayer.player.name,
                            matches = topPlayer.matches,
                            formattedValue = topPlayer.formattedValue,
                            imageviewurl = "https://api.sofascore.com/api/v1/player/${topPlayer.player.id}/image",
                            platerId = topPlayer.player.id
                        )
                    )
                }
                binding.txtChooseNameTwoRandom.text =
                    savecard.get(0).name.toString()
                binding.txtChooseMatchTwoRandom.text =
                    savecard.get(0).matches.toString()
                binding.txtChooseFordRandom.text =
                    savecard.get(0).formattedValue
                Glide.with(this)
                    .load(savecard.get(0).imageviewurl)
                    .into(binding.randomImageviewCardChoose)
                savecard.forEach {
                    viewmodelll.insertPlayer(savecard)


                }



                binding.startItem.visibility = View.GONE
                binding.chooseConfirm.visibility = View.VISIBLE


            })
        }
        binding.chooseConfirm.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


    }
}