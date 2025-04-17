package com.example.tugas4gracesimangunsong

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(private val namalist: ArrayList<ItemData>) :
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_data, parent, false)

        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val currentItem = namalist[position]
        holder.gambar.setImageResource(currentItem.gambar)
        holder.nama.text = currentItem.nama
        holder.asal.text = currentItem.asal
    }

    override fun getItemCount(): Int {
        return namalist.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gambar: ImageView = itemView.findViewById(R.id.imageView2)
        val nama: TextView = itemView.findViewById(R.id.idNamaPahlawan)
        val asal: TextView = itemView.findViewById(R.id.idAsal)
    }
}

