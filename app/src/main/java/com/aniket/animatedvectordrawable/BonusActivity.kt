package com.aniket.animatedvectordrawable

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.graphics.Color
import android.graphics.drawable.Animatable
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import kotlinx.android.synthetic.main.activity_bonus.*
import kotlinx.android.synthetic.main.bottom_sheet.*

class BonusActivity : AppCompatActivity() {

    private val layoutBottomSheet by lazy { BottomSheetBehavior.from(bottom_sheet) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bonus)

        btn.setOnClickListener {
            val anim: Animatable = highlight.background as Animatable
            anim.start()
            val colorAnim = ObjectAnimator.ofInt(
                highlight, "textColor",
                Color.BLACK, Color.WHITE, Color.BLACK
            )
            colorAnim.setEvaluator(ArgbEvaluator())
            colorAnim.duration = 600
            colorAnim.start()
        }

        val ogWidth = viewBox.layoutParams.width
        val ogHeight = viewBox.layoutParams.height
        val activity = this

        layoutBottomSheet.setBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
            override fun onStateChanged(bottomSheet: View, newState: Int) {

            }

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                Log.d("offset", "offset: $slideOffset")
                val screenWidth = activity.window.decorView.width
                viewBox.layoutParams.width = ogWidth + ((screenWidth - ogWidth) * slideOffset).toInt()
                if (slideOffset != 1f)
                    viewBox.layoutParams.height = ogHeight - (ogHeight * slideOffset).toInt()
                viewBox.requestLayout()
                Log.d("offset", "viewbox height ${viewBox.layoutParams.height}")
            }
        })

    }
}
