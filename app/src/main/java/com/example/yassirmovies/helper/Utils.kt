package com.example.yassirmovies.helper

import android.content.res.ColorStateList
import android.graphics.Color

class Utils {
    fun getColorByUserScore(score:Int): ColorStateList
    {
        if (score < 70)
        {
            return ColorStateList.valueOf(Color.parseColor("#FFDF72"))
        }
        else if (score > 70)
        {
            return ColorStateList.valueOf(Color.parseColor("#61C688"))
        }
        return ColorStateList.valueOf(Color.WHITE)
    }
}