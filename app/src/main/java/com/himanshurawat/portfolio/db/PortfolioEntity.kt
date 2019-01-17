package com.himanshurawat.portfolio.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.himanshurawat.portfolio.pojo.Education
import com.himanshurawat.portfolio.pojo.WorkEx

@Entity(tableName = "portfolio")
data class PortfolioEntity(

    @PrimaryKey(autoGenerate = true)
    var id:Long = 0L,
    var firstName: String = "",
    var lastName: String = "",
    var mobileNumber: Long = 0L,
    var email: String = "",
    var address: String = "",

    var educationQualification: List<Education>,
    var workExperience: List<WorkEx>

    )