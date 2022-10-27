package com.example.coursesgridlist.models

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Topic(
    @StringRes val name: Int,
    val nrOfCourses: Int,
    @DrawableRes val image: Int,
)
