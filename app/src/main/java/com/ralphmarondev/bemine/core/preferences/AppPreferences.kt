package com.ralphmarondev.bemine.core.preferences

import android.content.Context
import android.content.SharedPreferences

class AppPreferences(
    context: Context
) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences(
        PREFERENCES_NAME, Context.MODE_PRIVATE
    )

    companion object {
        private const val PREFERENCES_NAME = "be_mine_prefs"
        private const val TIME = "time"
        private const val FOOD = "food"
        private const val MOVIE = "movie"
        private const val EXCITEMENT_LEVEL = "excitement"
    }

    fun setTime(value: String) {
        sharedPreferences.edit().putString(TIME, value).apply()
    }

    fun getTime(): String {
        return sharedPreferences.getString(TIME, "Select Time")!!
    }

    fun setFood(value: Int) {
        sharedPreferences.edit().putInt(FOOD, value).apply()
    }

    fun getFood(): Int {
        return sharedPreferences.getInt(FOOD, -1)
    }

    fun setMovie(value: Int) {
        sharedPreferences.edit().putInt(MOVIE, value).apply()
    }

    fun getMovie(): Int {
        return sharedPreferences.getInt(MOVIE, -1)
    }
}