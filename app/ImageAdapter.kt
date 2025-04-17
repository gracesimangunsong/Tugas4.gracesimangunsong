package com.example.tugas4gracesimangunsong

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ImageAdapter(
    private val listWisata: List<WisataData>,
    private val onItemClick: (WisataData) -> Unit
) : RecyclerView.Adapter<ImageAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val imgWisata: ImageView = itemView.findViewById(R.id.imageView)
        private val txtNama: TextView = itemView.findViewById(R.id.txtNama)

        fun bind(wisata: WisataData) {
            imgWisata.setImageResource(wisata.image)
            txtNama.text = wisata.name
            itemView.setOnClickListener { onItemClick(wisata) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_data, parent, false)
        return ImageViewHolder(view)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.bind(listWisata[position])
    }

    override fun getItemCount(): Int = listWisata.size
}









