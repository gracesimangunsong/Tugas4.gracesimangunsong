package com.example.tugas4gracesimangunsong

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(
    private val list: List<WisataData>,
    private val onClick: (WisataData) -> Unit
) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.item_image)
        val tvTitle: TextView = itemView.findViewById(R.id.item_title)
        val tvDesc: TextView = itemView.findViewById(R.id.item_description)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    onClick(list[position])
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_wisata_data, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val wisata = list[position]
        holder.imgPhoto.setImageResource(wisata.imageRes)
        holder.tvTitle.text = wisata.name
        holder.tvDesc.text = wisata.description
    }
}

