package com.app.presentation.recycler

import android.content.Context
import android.util.AttributeSet
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.core.model.ItemSource
import com.google.android.material.appbar.AppBarLayout

class TimeLineRecyclerView : RecyclerView {

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet?, defStyle: Int) : super(context, attrs, defStyle)

    private val _layoutManager: LinearLayoutManager by lazy {
        LinearLayoutManager(context)
    }

    private var isLoadingTimeline = false
    private var isLastPage = false

    var page = 1

    fun show(itemSource: ItemSource){

    }

    fun notifyDataSetChanged() {
    }

    fun showCollapsingToolbarLayout(toolbar_layout: AppBarLayout) {
        toolbar_layout.setExpanded(true)
    }

    fun clear() {
    }

    fun reset() {
        isLoadingTimeline = false
        isLastPage = false
    }
}