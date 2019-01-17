package com.himanshurawat.portfolio.pojo

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.himanshurawat.portfolio.db.PortfolioEntity

data class Education(
    var id: Long = 0L,
    var user_id: Long,
    var school: String = "",
    var gpa: String = "",
    var yearOfCompletion: String = "",
    var major: String = "",
    var course: String = "")