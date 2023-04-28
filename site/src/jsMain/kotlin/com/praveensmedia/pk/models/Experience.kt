package com.praveensmedia.pk.models

import com.praveensmedia.pk.utils.Constants.ANDROID_DEV_DESC
import com.praveensmedia.pk.utils.Constants.INTERN_DESC
import com.praveensmedia.pk.utils.Constants.MOBILE_LEAD_DEV_DESC

enum class Experience(
    val number:String,
    val jobPosition:String,
    val description:String,
    val company : String,
    val from : String,
    val to : String
) {
    First(
        number = "01",
        jobPosition = "Mobile Lead Developer",
        description = MOBILE_LEAD_DEV_DESC,
        company = "SEPAL",
        from = "july 2022",
        to = "NOW",
    ),
    Second(
        number = "02",
        jobPosition = "Android Developer",
        description = ANDROID_DEV_DESC,
        company = "Techtion Innovation",
        from = "Nov 2018",
        to = "July 2022",
    ),
    Third(
        number = "03",
        jobPosition = "Intern",
        description = INTERN_DESC,
        company = "Cyrrup Solutions",
        from = "July 2017",
        to = "July 2018",
    )
}