package com.ayd.series.util

import androidx.recyclerview.widget.DiffUtil
import com.ayd.series.models.AvatarItem

class AvatarDiffUtil(
    private val oldList: List<AvatarItem>,
    private val newList: List<AvatarItem>
): DiffUtil.Callback(){
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    // eski ve yeni listenin aynı itemları ile mi temsil ediliyor kontrolü.
    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] === newList[newItemPosition]
    }

    //sadede fonksiyon isimleri aynı returnü veriyorsa
    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}