package com.example.home9

import androidx.viewpager2.widget.ViewPager2

fun ViewPager2.onPageChange(callback: (Int) -> Unit) {
    this.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            callback.invoke(position)
        }
    })
}