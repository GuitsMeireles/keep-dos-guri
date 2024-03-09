package com.febatis.googlekeepdosguri.domain.listnote

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.febatis.googlekeepdosguri.databinding.ItemNoteListBinding


class NoteAdapter(private val dataSet: Array<String>) :
    RecyclerView.Adapter<NoteAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemNoteListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val binding = ItemNoteListBinding.inflate(inflater, viewGroup, false)


        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.binding.tvTitle.text =dataSet[position]
        viewHolder.binding.tvContent.text =dataSet[position]
    }

    override fun getItemCount() = dataSet.size

}