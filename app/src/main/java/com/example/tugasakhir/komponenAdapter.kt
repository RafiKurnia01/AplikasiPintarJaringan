package com.example.tugasakhir

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class komponenAdapter(private val komponenList: ArrayList<Komponen>) : RecyclerView.Adapter<komponenAdapter.KomponenViewHolder>(){
    class KomponenViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
        val imageView : ImageView = itemView.findViewById(R.id.imgview)
        val textView : TextView = itemView.findViewById(R.id.textview)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): KomponenViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return KomponenViewHolder((view))
    }

    override fun getItemCount(): Int {
        return komponenList.size
    }

    override fun onBindViewHolder(holder: KomponenViewHolder, position: Int) {
        val komponen = komponenList[position]
        holder.textView.text = komponen.name
    }
}