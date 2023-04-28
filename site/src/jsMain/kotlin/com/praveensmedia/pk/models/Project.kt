package com.praveensmedia.pk.models

import com.praveensmedia.pk.utils.Res.Images.lyk_app
import com.praveensmedia.pk.utils.Res.Images.sepal_app
import com.praveensmedia.pk.utils.Res.Images.this_app
import com.praveensmedia.pk.utils.Res.Images.train_app

enum class Project (
    val title:String,
    val desc:String,
    val image:String,
    val link:String
){
    SEPAL(
        title = "SEPAL App",
        desc = "As a Mobile Lead Developer at SEPAL, I'm responsible for complete lifecycle. " +
                "App integrated with Here maps SDK, Reddit feed, Android Call manager and Media controller." +
                "I made few custom features, one of them is Trip path tracking and displaying path in the Map." +
                "You can experience the app, download it from PlayStore",
        image = sepal_app,
        link = "https://play.google.com/store/apps/details?id=com.sagiam.newsepal"
    ),
    TRAIN(
        title = "Train Announcement App",
        desc = "I Design & Built TRAIN Announcement app as a freelancer , " +
                "This app enables Announce Arrival, Departure of train or any other" +
                "information with the help of prerecorded voice files. " +
                "This app is in production in 7+ railway stations" ,
        image = train_app,
        link =""
    ),
    LYK_WATER(
        title = "LykWater App",
        desc = "This app is a companion app for Water tank cleaning device." +
                "This app Connects to its Device via Wifi, helps to setup the device, " +
                "control, update settings and getting alerts from the device",
        image = lyk_app,
        ""
    ),
    THIS(
        title = "This Website",
        desc = "I built this website with kotlin JS, Compose Web and Kobweb library. This is fully responsive website." +
                "I made it open source because I know the power of open source. " +
                "You can find source code link at bottom of this page. If you find it helpful Please give me a star on github" ,
        image = this_app,
        ""
    )
}