package com.example.tugasakhir

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ApiAdapter(val dataApi: List<DataItem?>?) : RecyclerView.Adapter<ApiAdapter.MyViewHolder>(){
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val judul = view.findViewById<TextView>(R.id.tvjudul)
        val isi = view.findViewById<TextView>(R.id.tvisi)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.each_item, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        if (dataApi != null){
            return dataApi.size
        }
        return 0

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.judul.text = dataApi?.get(position)?.judul
        holder.isi.text = dataApi?.get(position)?.isi
        holder.itemView.setOnClickListener{
            val nama = dataApi?.get(position)?.judul
            Toast.makeText(holder.itemView.context, "${nama}", Toast.LENGTH_SHORT).show()
        }
    }
}