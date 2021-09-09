package com.example.home9

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView

class PagerAdapter(private val dataList: ArrayList<OnBoardModel>)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
    return when (viewType) {
        TYPE_SECOND -> {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_home9, parent, false)
            SecondTitleViewHolder(view)

        }
        TYPE_THIRD -> {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.third_layout9, parent, false)
            ThirdTitleViewHolder(view)
        }
        else -> {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.layout_onboard, parent, false)
            TitleViewHolder(view)
        }
    }

}
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(getItemViewType(position)){
            TYPE_SECOND -> (holder as SecondTitleViewHolder).bind(
                dataList[position]
            )
            TYPE_THIRD -> (holder as ThirdTitleViewHolder).bind(
                dataList[position]
            )
            TYPE_FIRST -> (holder as TitleViewHolder).bind(
                    dataList[position]
                )
        }
    }
    override fun getItemCount(): Int {
        return dataList.size
    }
    override fun getItemViewType(position: Int): Int {
        return when (position) {
             4 -> TYPE_SECOND
            5 -> TYPE_THIRD
            else -> TYPE_FIRST
        }
    }

    companion object{
        private const val TYPE_FIRST = 100
        private const val TYPE_SECOND = 101
        private const val TYPE_THIRD = 102
    }
}
class TitleViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    private val textBoard = view.findViewById<TextView>(R.id.textBoard)
    private val imgBoard = view.findViewById<ImageView>(R.id.imgBoard)
    private val consPar = view.findViewById<ConstraintLayout>(R.id.consPar)
    private val textLayout = view.findViewById<TextView>(R.id.textLayout)

    fun bind(onBoardModel: OnBoardModel) {
        textBoard.text = onBoardModel.title
        imgBoard.setImageResource(onBoardModel.image)
        consPar.setBackgroundColor(itemView.context.resources.getColor(onBoardModel.color))
        textLayout.text = onBoardModel.title1
    }
}

class SecondTitleViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    private val online = view.findViewById<TextView>(R.id.online)
    private val imgOnline = view.findViewById<ImageView>(R.id.imgOnline)

    fun bind(onBoardModel: OnBoardModel) {
        online.text =  onBoardModel.title2
        imgOnline.setImageResource(onBoardModel.image2)
    }
}

class ThirdTitleViewHolder(private val view: View): RecyclerView.ViewHolder(view) {

    private val getStar = view.findViewById<TextView>(R.id.getStar)
    private val imgStar = view.findViewById<ImageView>(R.id.imgStar)

    fun bind(onBoardModel: OnBoardModel){
        getStar.text = onBoardModel.title3
        imgStar.setImageResource(onBoardModel.image3)

    }
}