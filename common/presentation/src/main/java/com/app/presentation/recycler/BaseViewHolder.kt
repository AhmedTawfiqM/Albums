package com.app.presentation.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<T>(
    viewGroup: ViewGroup,
    @LayoutRes val layoutRes: Int,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.ViewHolder(
    LayoutInflater.from(viewGroup.context).inflate(layoutRes, viewGroup, false)
) {

    var item: T? = null
    abstract fun bindView(item: T)

    init {
        itemView.setOnClickListener {
            onItemClickListener.onItemClick(adapterPosition)
        }
    }
    //fun getString(@StringRes resId: Int): String = itemView.context.getString(resId)
}