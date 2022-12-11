package com.example.yassirmovies.helper

import android.content.res.ColorStateList
import android.graphics.Color
import com.example.yassirmovies.model.Genres

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

    fun turnGenresToCategoriesString(arrayGenres: ArrayList<Genres>):String
    {
        val categories = arrayListOf<String>()

        for (genres in arrayGenres)
        {
            categories.add(genres.name)
        }

        return categories.joinToString(" - ")
    }

}