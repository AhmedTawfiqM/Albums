package com.app.presentation.recycler

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerAdapter<MODEL, VH : BaseViewHolder<MODEL>>
    ( val list: MutableList<MODEL>) : RecyclerView.Adapter<VH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return getViewHolder(parent, viewType)
    }

    abstract fun getViewHolder(viewGroup: ViewGroup, viewType: Int): VH

    override fun onBindViewHolder(holder: VH, position: Int) {
        try {
            val item = list[position]
            holder.item = item
            holder.bindView(item)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun add(item: MODEL) {
        val initial = list.size
        list.add(item)
        notifyItemInserted(initial)
    }

    fun add(items: List<MODEL>) {
        val initial = itemCount
        list.addAll(items)
        notifyItemRangeInserted(initial, items.size)
    }
}