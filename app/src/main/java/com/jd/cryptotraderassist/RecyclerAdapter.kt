package com.jd.cryptotraderassist

import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter

class RecyclerAdapter (private var titles: List<Strings>, private var details: List<String>, private var images:List<Int> :
Adapter<RecyclerAdapter.ViewHolder>(){
    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemTitle: TextView = itemView.findViewById(R.id.tv_title)
        val itemDetail: TextView = itemView.findViewById(R.id.tv_description)
        val itemPicture: ImageView = itemView.findViewById(R.id.iv_image)

        init {
            itemView.setOnClickListener { v: View ->
                val position: Int = adapterPosition
                Toast.makeText(itemView.context, text: "You clicked on crypto asset # $(position +1)", Toast.LENGTH_SHORT).show()
                }
        }
    }
    override fun onCreatViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent, attachToRoot:false)
        return ViewHolder(v)
    }
    override fun getItemCount(): Int {
    return titles.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemPicture.setImageRource(images[position])
}
