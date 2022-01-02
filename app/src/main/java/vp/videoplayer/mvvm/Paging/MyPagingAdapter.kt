package vp.videoplayer.mvvm.Paging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import vp.videoplayer.mvvm.Models.ResultsItem
import vp.videoplayer.mvvm.R

class MyPagingAdapter:PagingDataAdapter<ResultsItem,HolderPaging>(diffUtil) {
    companion object{
        val diffUtil= object :DiffUtil.ItemCallback<ResultsItem>(){
            override fun areItemsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem.id==newItem.id
            }

            override fun areContentsTheSame(oldItem: ResultsItem, newItem: ResultsItem): Boolean {
                return oldItem==newItem
            }

        }
    }

    override fun onBindViewHolder(holder: HolderPaging, position: Int) {
        val data=getItem(position)
        if (data != null) {
            holder.setData(data)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HolderPaging {
        val viewType=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return HolderPaging(viewType)
    }
}