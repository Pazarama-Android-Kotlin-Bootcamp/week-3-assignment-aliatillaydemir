package com.ayd.series.bindingAdapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

//image'ı, int değerleri vs. stringe dönüştürüp layouta veririz. çünkü data bindingte string kullanmak zorundayız.
class AvatarRowBinding {

    companion object{

        @BindingAdapter("imageUrl")
        @JvmStatic
        fun imageUrl(imageView: ImageView, imageUrl: String){
            imageView.load(imageUrl){
                crossfade(500)
            }
        }


    }

}