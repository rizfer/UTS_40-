package com.example.tugasuts

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fak_listitem.view.*

class ResepAdapter (val FKItemList: List<fk_data>, val clickListener: (fk_data) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.fak_listitem, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(FKItemList[position], clickListener)
    }

    override fun getItemCount() = FKItemList.size

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(FK: fk_data, clickListener: (fk_data) -> Unit) {
            itemView.tv_judul.text = FK.jdl
            itemView.imageView2.setImageResource(FK.img)
            itemView.setOnClickListener{ clickListener(FK)}
        }
    }
}