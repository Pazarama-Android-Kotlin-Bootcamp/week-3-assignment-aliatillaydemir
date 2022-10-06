package com.ayd.series.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.ayd.series.databinding.AvatarRowLayoutBinding
import com.ayd.series.models.Avatar
import com.ayd.series.models.AvatarItem
import com.ayd.series.util.AvatarDiffUtil

class AvatarAdapter: RecyclerView.Adapter<AvatarAdapter.ViewHolder>() {

    private var avatarList = emptyList<AvatarItem>()

    class ViewHolder(private val binding: AvatarRowLayoutBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(avatarResult: AvatarItem) {
            binding.avatarItem = avatarResult             //databindingde ulaşacağımız yer.
            binding.executePendingBindings()              //data ne zaman değişse update  olmasını sağlıyor.
        }

        companion object{
            fun from(parent: ViewGroup): ViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = AvatarRowLayoutBinding.inflate(layoutInflater,parent,false)
                return ViewHolder(binding)
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = avatarList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return avatarList.size
    }

    fun setData(newDataList: Avatar){

        //notifyDataSetChanged()
        val avatarDiff = AvatarDiffUtil(avatarList, newDataList.result)
        val diffUtilResult = DiffUtil.calculateDiff(avatarDiff)

        avatarList = newDataList.result
        diffUtilResult.dispatchUpdatesTo(this)
    }

}