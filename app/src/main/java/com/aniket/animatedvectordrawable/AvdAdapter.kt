package com.aniket.animatedvectordrawable

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import kotlinx.android.synthetic.main.image_list_item.view.*

class AvdAdapter(private val mContext: Context) : RecyclerView.Adapter<AvdAdapter.MyViewHolder>() {

    private val arrayList =
        arrayListOf(R.drawable.bell_ring, R.drawable.bicycle, R.drawable.search_cross, R.drawable.heart_broke_fill)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.image_list_item,
                parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val animationVectorDrawableCompat: AnimatedVectorDrawableCompat =
            AnimatedVectorDrawableCompat.create(mContext, arrayList[position])!!

        animationVectorDrawableCompat.apply {
            registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
                override fun onAnimationEnd(drawable: Drawable?) {
                    start()
                }

            })
            start()
        }
        holder.itemView.ivAnimation.setImageDrawable(animationVectorDrawableCompat)
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        init {

        }
    }
}
