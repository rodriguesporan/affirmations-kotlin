package com.example.affirmations.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.affirmations.R
import com.example.affirmations.model.Affirmation

class ItemAdapter(private val context: Context, private val dataset: List<Affirmation>) :
        RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    /**
     * Defining a class inside another class is called creating a nested class.
     *
     * Since ItemViewHolder is only used by ItemAdapter,
     * creating it inside ItemAdapter shows this relationship.
     * This is not mandatory,
     * but it helps other developers understand the structure of your program
     */
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById(R.id.item_title)
        val imageView: ImageView = view.findViewById(R.id.item_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context) // get an instance of LayoutInflater
                .inflate(R.layout.list_item, parent, false) // inflate the list item view

        return ItemViewHolder(adapterLayout)
    }

    override fun getItemCount() = dataset.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.textView.text = context.resources.getText(item.stringResourceId)
        holder.imageView.setImageResource(item.imageResourceId)
    }
}