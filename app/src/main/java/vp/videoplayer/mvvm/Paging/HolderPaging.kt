package vp.videoplayer.mvvm.Paging

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item.view.*
import vp.videoplayer.mvvm.Models.ResultsItem

class HolderPaging(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun setData( resultsItem: ResultsItem) {
        itemView.tvAuthor.text="\""+resultsItem.author+"\""
        itemView.tvQuotes.text="~ "+resultsItem.content
    }
}